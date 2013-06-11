import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.Robot;
import java.io.*;
import java.util.Random;


public class Aimbot{

	public static KeyListener keyListener = new KeyListener();
	public static MouseListener mouseListener = new MouseListener();
	public static Random randGen = new Random();
	public static File outputfile = new File("saved.png");
	public static Color centrepixel;
	public static Robot robot;
	public static BufferedImage image;
	public static Color curpixel;
	public int[] imageData;
	public static width = 1024;
	public static height = 768;
	//refactor code with methods at some point when finished to make clearer


	public static int 2Dtolinear(int[] xyCoords, int width){
		int x = xyCoords[0];
		int y = xyCoords[1];

		int linearIndex = (y*width)+x;
		return linearIndex;

	}


	public static int[] linearTo2D(int linearIndex){
		y=linearIndex/width; //both are ints so it returns the divison result with the remainder truncated, as desired.
		x=linearIndex % width; //returns remainder, as desired

	}


	public static void scanScreenAndMove() throws InterruptedException{

		//get array from bufferedimage here
		imageData = image.getRGB(0, 0, width, height, imageData, 0, width);
		/*pixel   = rgbArray[offset + (y-startY)*scansize + (x-startX)];
		therefore (x,y) is rgbArray[y*width + x] i.e. linear index*/


		for(int y=0; y<768; y++){
			for(int x=0; x<1024; x++){
				//System.out.println("Currently at:" + x + ", " + y);
				curpixel = robot.getPixelColor(x,y);
				//move to position if matches
				if (curpixel.equals(centrepixel)){
					System.out.println("Match found at:" + x + ", " + y);
					int xDist = x-512;
					int yDist = y-384;
					System.out.println("First Moving to: " + (mouseListener.curMousePosX + xDist) + ", " + (mouseListener.curMousePosY + yDist));
					robot.mouseMove((mouseListener.curMousePosX + xDist), (mouseListener.curMousePosY + yDist));
					Thread.sleep(50);
					System.out.println("Second Moving to: " + (mouseListener.curMousePosX) + ", " + (mouseListener.curMousePosY));
					robot.mouseMove(mouseListener.curMousePosX, mouseListener.curMousePosY);
					Thread.sleep(50);
					return;
				}

			}

		}


	}


	public static void main(String[] args) throws InterruptedException { 

		
		
		try{
			robot = new Robot();

			while(true){
				//robot.mouseMove(512, 384);
				//pListener.haspBeenReleased = true;
				if (keyListener.getHaspBeenReleased()==true){
					//System.out.println("got here!");
					keyListener.setHaspBeenReleased(false);
					
				} 

				if(keyListener.hastBeenReleased==true){

					centrepixel = robot.getPixelColor(512,384);//get pixel at centre
					System.out.println("Centre Pixel Captured.");
					keyListener.hastBeenReleased=false;
				}



				if (keyListener.isePressed==true){
					//scan screen
					System.out.println("Scanning Screen and moving.");
					scanScreenAndMove();
					System.out.println("Screen Scanned and moved.");

					//int r1 = randGen.nextInt(3) - 1;
					//int r2 = randGen.nextInt(3) - 1;

					//imageData = getData(image);					
					
					

					keyListener.isePressed=false;
				}

			}
		}catch(AWTException e){ 
			System.err.println("AWTException: " + e.getMessage());
		}
		

	}



}

/* OLD SCREENSHOT SAVING CODE

image=robot.createScreenCapture(new Rectangle(0,0,1024,768));

try{
	ImageIO.write(image, "png", outputfile);
	System.out.println("file written");
}catch(IOException e){
	System.err.println("IOException: " + e.getMessage());
}

*/
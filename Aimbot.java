import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.Robot;
import java.io.*;
import java.util.Random;


public class Aimbot{



	public static void main(String[] args){

		KeyListener keyListener = new KeyListener();
		MouseListener mouseListener = new MouseListener();
		//Random randGen = new Random();
		
		try{
			Robot robot = new Robot();

			while(true){
				
				//pListener.haspBeenReleased = true;
				if (keyListener.getHaspBeenReleased()==true){
					//System.out.println("got here!");
					keyListener.setHaspBeenReleased(false);
					BufferedImage image=robot.createScreenCapture(new Rectangle(0,0,1024,768));
				} 

				if (keyListener.isePressed==true){
					//int r1 = randGen.nextInt(3) - 1;
					//int r2 = randGen.nextInt(3) - 1;
					robot.mouseMove(512, 384);
					robot.mouseMove(712, 384);
					keyListener.isePressed=false;
				}

			}
		}catch(AWTException e){ 
			System.err.println("AWTException: " + e.getMessage());
		}
		

	}



}

/* OLD SCREENSHOT SAVING CODE
					File outputfile = new File("saved.png");
					try{
						ImageIO.write(image, "png", outputfile);
						System.out.println("file written");
					}catch(IOException e){
						System.err.println("IOException: " + e.getMessage());
					}
					*/
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

public class MouseListener implements NativeMouseInputListener {
		//volatile public 

        public void nativeMouseClicked(NativeMouseEvent e) {
                System.out.println("Mouse Clicked: " + e.getX() + ", " + e.getY());
        }

        public void nativeMousePressed(NativeMouseEvent e) {
                //System.out.println("Mouse Pressed: " + e.getButton());
        }

        public void nativeMouseReleased(NativeMouseEvent e) {
               // System.out.println("Mouse Released: " + e.getButton());
        }

        public void nativeMouseMoved(NativeMouseEvent e) {
               // System.out.println("Mouse Moved: " + e.getX() + ", " + e.getY());
        }

        public void nativeMouseDragged(NativeMouseEvent e) {
               // System.out.println("Mouse Dragged: " + e.getX() + ", " + e.getY());
        }


        public MouseListener(){
        	 try {
                        GlobalScreen.registerNativeHook();
                }
                catch (NativeHookException ex) {
                        System.err.println("There was a problem registering the native hook.");
                        System.err.println(ex.getMessage());

                        System.exit(1);
                }

                

                //Add the appropriate listeners for the example object.
                GlobalScreen.getInstance().addNativeMouseListener(this);
                GlobalScreen.getInstance().addNativeMouseMotionListener(this);

        }

}
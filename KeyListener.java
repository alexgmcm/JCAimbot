import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class KeyListener implements NativeKeyListener{
	volatile private boolean haspBeenReleased = false;
    volatile public boolean hastBeenReleased = false;
    volatile public boolean isePressed = false;

    final public boolean getHaspBeenReleased(){
        return haspBeenReleased;
    }

    public void setHaspBeenReleased(boolean bool){
        haspBeenReleased = bool;
    }

	public void nativeKeyPressed(NativeKeyEvent e) {
                //System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

                /*if (e.getKeyCode() == NativeKeyEvent.VK_ESCAPE) {
                        GlobalScreen.unregisterNativeHook();
                }*/

                if (e.getKeyCode() == NativeKeyEvent.VK_E) {
                        isePressed = true;
                        //System.out.println("boolean set");
                }


        }

        public void nativeKeyReleased(NativeKeyEvent e) {
               //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

                if (e.getKeyCode() == NativeKeyEvent.VK_P) {
                        haspBeenReleased = true;
                        //System.out.println("boolean set");
                }

                if (e.getKeyCode() == NativeKeyEvent.VK_T) {
                        hastBeenReleased = true;
                        //System.out.println("boolean set");
                }
        }

        public void nativeKeyTyped(NativeKeyEvent e) {
                //System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
        }

        public KeyListener(){

        	 try {
                        GlobalScreen.registerNativeHook();
                }
                catch (NativeHookException ex) {
                        System.err.println("There was a problem registering the native hook.");
                        System.err.println(ex.getMessage());

                        System.exit(1);
                }

                //initialze native hook.
                GlobalScreen.getInstance().addNativeKeyListener(this);
        }



}
JCAimbot - Java Colour Aimbot
========

To do
--------
* Implement mouse movement and test it moves as expected
* Get default pixel values ~~from skins~~ (not possible), get from centre of screen when a certain key is pressed
* Implement scanning bufferedimage and getting pixel values - need to use getRGB on bufferedimage, getpixel from screen is too slow
* Calculate offset - see known issues - to get expected motion to desired pixel
* Implement mouse click with toggle button (autoshoot)
* Aim-assist activated by keypressed (i.e. hold button)
* Implement button to redefine searched pixel values with pixel at centre to allow adjustment
* Only capture small area around centre for better efficiency?
* Pixel values may change due to lighting etc. - work out what brightness should be, put in tolerances?



Known Issues
--------------
* Mouse position is locked once moved, so it won't move.
	* ~~therefore move to a pixel ±a few pixels near the actual desired location to allow for an approximate aim assist (i.e. 'fuzz' the movement). Will implement soon.~~ Doesn't work - just moves mouse once, and then jitters mouse by a few pixels so it must be setting it from the new position.
	* ~~Moving mouse back to centre, and then to target very rapidly also doesn't seem to work????~~
	* Delay using Sleep seems to make it work, can move mouse beyond window bounds and it works fine, so just need to take current offset into account
	* could try implementing a crude algorithm to simulate actual mouse motion rather than instantaneous motion: see http://stackoverflow.com/questions/12131427/java-robot-class-simulating-human-mouse-movement
	* Or could use Bresenham's line algorithm to move the mouse: http://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm

* getPixel is too slow to use in main loop - try using array approach from screenshot

* ~~Fails to detect keypress despite boolean flag being set, unless boolean flag is first printed to terminal, then it works because magic.~~ - Fixed by use of volatile keyword as it prevents local the variable being thread-locally cached, see: http://www.javamex.com/tutorials/synchronization_volatile.shtml (03/02/2013)

Notes
-------
* Mouse position always begins held at the centre by the game (i.e. for 1024x768 res it's held at 512, 384)
* Mouse position then moves to being held at the last position it was updated to via Robot. (therefore must deal with offset)
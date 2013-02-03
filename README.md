JCAimbot - Java Colour Aimbot
========

Known Issues
--------------



* ~~Fails to detect keypress despite boolean flag being set, unless boolean flag is first printed to terminal, then it works because magic.~~ - Fixed by use of volatile keyword as it prevents local the variable being thread-locally cached, see: http://www.javamex.com/tutorials/synchronization_volatile.shtml (03/02/2013)




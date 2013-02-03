#!/bin/sh

javac -classpath `pwd`/JNativeHook.jar GlobalKeyListenerExample.java

java -classpath `pwd`/JNativeHook.jar:`pwd` GlobalKeyListenerExample

javac -classpath ./JNativeHook.jar Aimbot.java KeyListener.java 

java -classpath .:./JNativeHook.jar Aimbot

javac -classpath ./JNativeHook.jar GlobalMouseListenerExample.java

java -classpath .:./JNativeHook.jar GlobalMouseListenerExample

#Mouse Clicked: 512, 384


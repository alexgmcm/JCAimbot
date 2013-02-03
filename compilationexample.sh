#!/bin/sh

javac -classpath `pwd`/JNativeHook.jar GlobalKeyListenerExample.java

java -classpath `pwd`/JNativeHook.jar:`pwd` GlobalKeyListenerExample
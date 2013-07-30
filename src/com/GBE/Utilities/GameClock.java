package com.GBE.Utilities;

import org.lwjgl.Sys;

public class GameClock
{
	private static int delta = 0;
	private static long currentTime = 0;
	private static long lastFrame = 0;
	private static long lastSecond = 0;
	private static int currentFps = 0;
	private static int lastFps = 0;
	
	public static long getTime()
	{ return (Sys.getTime() * 1000) / Sys.getTimerResolution(); }
	
	public static int getDelta()
	{ return delta; }
	
	public static int getFPS()
	{ return lastFps; }
	
	public static void update()
	{
		currentTime = GameClock.getTime();
		
		delta = (int) (currentTime - lastFrame);
		lastFrame = currentTime;
		
		if(currentTime - lastSecond >= 1000)
		{
			lastSecond	= currentTime;
			lastFps		= currentFps;
			currentFps	= 0;
		}	
		currentFps++;
	}
}

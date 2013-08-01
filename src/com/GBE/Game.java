package com.GBE;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.GBE.Utilities.GameClock;
import com.GBE.Utilities.Input;

public abstract class Game
{
	private final int width;
	private final int height;
	private final String title;
	
	private boolean isRunning = false;
	
	public Game(int width, int height, String title)
	{
		this.width	= width;
		this.height	= height;
		this.title	= title;
		
		// Setup Display //
		try
		{
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setVSyncEnabled(true);
			Display.setTitle(title);
			Display.create();
			
			Keyboard.create();
			Mouse.create();
			
			isRunning = true;
		}
		catch(LWJGLException err)
		{
			err.printStackTrace();
			isRunning = false;
		}
		
		// Initialize OpenGL //
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(70f, (float) Display.getWidth() / (float) Display.getHeight(), 0.001f, 1000f);
		glMatrixMode(GL_MODELVIEW);
		
		glClearColor(0.9f, 0.9f, 0.9f, 1);
		glEnable(GL_DEPTH_TEST);

		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		// User Initialization //
		this.init();
		
		// Game Loop //
		while(isRunning)
		{
			if(Display.isCloseRequested()) isRunning = false;
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLoadIdentity();
			
			this.loop();
			
			GameClock.update();
			Input.update();
			
			Display.update();
			Display.sync(60);
		}
		
		// User Close //
		this.close();
		
		// Close //
		Display.destroy();
		Keyboard.destroy();
		Mouse.destroy();
		
		System.exit(0);
	}	
	
	public abstract void init();
	
	public abstract void loop();
	
	public abstract void close();
	
	/*			*
	 *	Getters	*
	 *			*/	
	public int getDisplayWidth()
	{ return width; }
	
	public int getDisplayHeight()
	{ return height; }
	
	public String getDisplayTitle()
	{ return title; }
	
	public boolean isRunning()
	{ return isRunning; }
	
	public void stopRunning()
	{ isRunning = false; }
	
	/*				*
	 *	Utilities	*
	 *				*/
	private static final float gravity = 0.01f;
	
	public static float getGravity()
	{ return gravity; }
}

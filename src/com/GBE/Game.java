package com.GBE;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.gluPerspective;

import com.GBE.Input.KeyManager;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.GBE.Utilities.GameClock;

public abstract class Game
{
	private final int width;
	private final int height;
	private final String title;
	private float gravity;

	private final KeyManager keyManager;
	
	private boolean isRunning = false;

	public Game(int width, int height, String title)
	{ this(width, height, title, 0.01f); }

	public Game(int width, int height, String title, float gravity)
	{
		this.width		= width;
		this.height		= height;
		this.title		= title;
		this.gravity	= gravity;

		keyManager = new KeyManager();

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
			System.exit(1);
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
			keyManager.update();

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
	
	protected abstract void init();
	
	protected abstract void loop();
	
	protected abstract void close();
	
	/*			*
	 *	Getters	*
	 *			*/	
	public int getDisplayWidth()
	{ return width; }
	
	public int getDisplayHeight()
	{ return height; }
	
	public String getDisplayTitle()
	{ return title; }

	public float getGravity()
	{ return gravity; }

	public void setGravity(float gravity)
	{ this.gravity = gravity; }

	public KeyManager getKeyManager()
	{ return keyManager; }

	public boolean isRunning()
	{ return isRunning; }
	
	public void stopRunning()
	{ isRunning = false; }
}

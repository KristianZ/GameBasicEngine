package com.GBE.Utilities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.GBE.Positions.Vector2f;

public class Input
{
	private static boolean[] pressedKeys = new boolean[256];
	private static boolean[] pressedMouse = new boolean[5];
	
	public static void update()
	{
		for(int i = 0; i < 256; i++)
		{
			if(Input.isKeyPressed(i)) pressedKeys[i] = true;
			else pressedKeys[i] = false;
		}
		
		for(int i = 0; i < 5; i++)
		{
			if(Input.isMousePressed(i)) pressedMouse[i] = true;
			else pressedMouse[i] = false;
		}
	}
	
	/*						*
	 *	Keyboard Methods	*
	 *						*/
	public static boolean isKeyPressed(int key)
	{ return Keyboard.isKeyDown(key) && !(pressedKeys[key]); }
	
	public static boolean isKeyHeld(int key)
	{ return Keyboard.isKeyDown(key) && pressedKeys[key]; }
	
	public static boolean isKeyUp(int key)
	{ return !(Keyboard.isKeyDown(key)) && pressedKeys[key]; }
	
	/*					*
	 *	Mouse Methods	*
	 *					*/
	public static boolean isMousePressed(int button)
	{ return Mouse.isButtonDown(button) && !(pressedMouse[button]); }
	
	public static boolean isMouseHeld(int button)
	{ return Mouse.isButtonDown(button) && pressedMouse[button]; }
	
	public static boolean isMouseUp(int button)
	{ return !(Mouse.isButtonDown(button)) && pressedMouse[button]; }
	
	public static Vector2f getMousePos()
	{ return new Vector2f(Mouse.getX(), Mouse.getY()); }
	
	public static void setMousePos(Vector2f loc)
	{ Mouse.setCursorPosition((int) loc.getX(), (int) loc.getY()); }
	
	public static Vector2f getDMouse()
	{ return new Vector2f(Mouse.getDX(), Mouse.getDY()); }
	
	public static boolean isGrabbedMouse()
	{ return Mouse.isGrabbed(); }
	
	public static void grabMouse(boolean grab)
	{ Mouse.setGrabbed(grab); }
}

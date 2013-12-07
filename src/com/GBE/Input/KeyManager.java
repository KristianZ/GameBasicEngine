package com.GBE.Input;

import com.GBE.Positions.Vector2f;
import com.GBE.Positions.Vector3f;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class KeyManager
{
	private final List<KeyListener> keyListeners;

	public KeyManager()
	{ this.keyListeners = new ArrayList<KeyListener>(); }

	public void registerKeyListener(KeyListener keyListener)
	{ this.keyListeners.add(keyListener); }

	public void update()
	{
		for(int i = 0; i < 256; i++)
		{
			if(Keyboard.isKeyDown(i))
			{
				this.executeKey(i, KeyPriority.LOW);
				this.executeKey(i, KeyPriority.NORMAL);
				this.executeKey(i, KeyPriority.HIGH);
			}
		}

		for(int i = 256; i < 264; i++)
		{
			if(Mouse.isButtonDown(i - 256))
			{
				this.executeKey(i, KeyPriority.LOW);
				this.executeKey(i, KeyPriority.NORMAL);
				this.executeKey(i, KeyPriority.HIGH);
			}
		}

		this.executeKey(264, KeyPriority.LOW);
		this.executeKey(264, KeyPriority.NORMAL);
		this.executeKey(264, KeyPriority.HIGH);
	}

	private void executeKey(int key, KeyPriority keyPriority)
	{
		for(KeyListener keyListener : keyListeners)
		{
			for(Method method : keyListener.getClass().getMethods())
			{
				Annotation annotation = method.getAnnotation(Input.class);
				if(annotation != null && annotation instanceof Input)
				{
					if(((Input) annotation).key() == key && ((Input) annotation).priority() == keyPriority)
					{
						try
						{ method.invoke(keyListener, null); }
						catch (InvocationTargetException err)
						{ err.printStackTrace(); }
						catch (IllegalAccessException err)
						{ err.printStackTrace(); }
					}
				}
			}
		}
	}

	public static Vector2f getMousePos()
	{ return new Vector2f(Mouse.getX(), Mouse.getY()); }

	public static void setMousePos(Vector2f loc)
	{ Mouse.setCursorPosition((int) loc.getX(), (int) loc.getY()); }

	public static float getDX()
	{ return Mouse.getDX(); }

	public static float getDY()
	{ return Mouse.getDY(); }

	public static Vector3f getDMouse()
	{ return new Vector3f(Mouse.getDX(), Mouse.getDY(), Mouse.getDWheel()); }

	public static boolean isGrabbedMouse()
	{ return Mouse.isGrabbed(); }

	public static void grabMouse(boolean grab)
	{ Mouse.setGrabbed(grab); }
}

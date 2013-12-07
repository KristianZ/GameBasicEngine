package com.GBE;

import com.GBE.Entity.Camera;
import com.GBE.Input.Input;
import com.GBE.Input.KeyListener;
import com.GBE.Input.KeyManager;

public class Listener implements KeyListener
{
	private final Camera camera;

	public Listener(Camera camera)
	{ this.camera = camera; }

	@Input(key = Input.W)
	public void onKeyW()
	{ this.camera.moveForward(); }

	@Input(key = Input.S)
	public void onKeyS()
	{ this.camera.moveBackward(); }

	@Input(key = Input.A)
	public void onKeyA()
	{ this.camera.moveLeft(); }

	@Input(key = Input.D)
	public void onKeyD()
	{ this.camera.moveRight(); }

	@Input(key = Input.SPACE)
	public void onKeySpace()
	{ this.camera.jump(); }

	@Input(key = Input.MOUSE_LEFT)
	public void onMouseLeftClick()
	{ KeyManager.grabMouse(true); }

	@Input(key = Input.MOUSE_RIGHT)
	public void onMouseRightClick()
	{ KeyManager.grabMouse(false); }

	@Input(key = Input.MOUSE_MOVE)
	public void onMouseMove()
	{ if(KeyManager.isGrabbedMouse()) this.camera.rotate(KeyManager.getDMouse().getX() / 4, -KeyManager.getDMouse().getY() / 4); }
}

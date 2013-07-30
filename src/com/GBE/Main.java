package com.GBE;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.GBE.Entity.Camera;
import com.GBE.Entity.Cube;
import com.GBE.Entity.Floor;
import com.GBE.Utilities.Input;
import com.GBE.Utilities.Vector3f;

public class Main extends Game
{
	public Main(int width, int height, String title)
	{ super(width, height, title); }

	public static void main(String[] args)
	{ new Main(850, 480, "Game Engine"); }
	
	private Camera camera;
	private Cube cube;
	private Floor floor;

	@Override
	public void init()
	{
		camera = new Camera(3, 3, 5, new Vector3f(0, 0, 0), 0, 0, 0.01f, 10);
		cube = new Cube(10, 10, 10, new Vector3f(0, 3, 0), 0, 0);
		floor = new Floor(50, 0, 50, new Vector3f(0, 0, 0), 0, 0);
	}

	@Override
	public void loop()
	{	
		if(Input.isKeyHeld(Keyboard.KEY_W)) camera.moveForward();
		if(Input.isKeyHeld(Keyboard.KEY_S)) camera.moveBackward();
		if(Input.isKeyHeld(Keyboard.KEY_A)) camera.moveLeft();
		if(Input.isKeyHeld(Keyboard.KEY_D)) camera.moveRight();
		if(Input.isKeyHeld(Keyboard.KEY_SPACE)) camera.jump();

		if(Input.isMousePressed(0)) Input.grabMouse(true);
		else if(Input.isMousePressed(1)) Input.grabMouse(false);

		if(Input.isGrabbedMouse())
		{
			float newPitch = camera.getPitch() + -Mouse.getDY() / 4;
			if(newPitch < 90 && newPitch > -90) camera.setPitch(newPitch);
			camera.setYaw(camera.getYaw() + Input.getDMouse().getX() / 4);
		}

		camera.render();	
		cube.render();
		floor.render();

		glBegin(GL_LINES);
		glColor3f(1, 0, 0);
		glVertex3f(0, 0, 0);
		glVertex3f(1, 0, 0);

		glColor3f(0, 1, 0);
		glVertex3f(0, 0, 0);
		glVertex3f(0, 1, 0);

		glColor3f(0, 0, 1);
		glVertex3f(0, 0, 0);
		glVertex3f(0, 0, 1);

		//glColor3f(1, 0, 0);
		//glVertex3f();
		glEnd();
	}

	@Override
	public void close() {}
}

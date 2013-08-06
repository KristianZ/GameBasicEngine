package com.GBE;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.GBE.Entity.Camera;
import com.GBE.Entity.Cube;
import com.GBE.Entity.Floor;
import com.GBE.Positions.Position;
import com.GBE.Positions.Vector3f;
import com.GBE.Utilities.Input;
import com.GBE.Utilities.Shape;

public class Main extends Game
{
	public Main(int width, int height, String title)
	{ super(width, height, title); }

	public static void main(String[] args)
	{ new Main(850, 480, "Game Engine");}
	
	private Camera camera;
	private Cube cube;
	private Floor floor;
	
	@Override
	protected void init()
	{
		camera = new Camera(2, 6, 1);
		cube = new Cube(10, 10, 10, new Position(0, 3, 0));
		floor = new Floor(50, 0, 50);
		
		Shape pointer	= new Shape(Shape.POINT, new Vector3f(0, 0, -1));
		Shape point1	= new Shape(Shape.POINT, new Vector3f(10, -5, -10));
		Shape point2	= new Shape(Shape.POINT, new Vector3f(-10, -5, -10));
		camera.addShapeToScreen(pointer);
		camera.addShapeToScreen(point1);
		camera.addShapeToScreen(point2);
	}

	@Override
	protected void loop()
	{	
		if(Input.isKeyHeld(Keyboard.KEY_W)) camera.moveForward();
		if(Input.isKeyHeld(Keyboard.KEY_S)) camera.moveBackward();
		if(Input.isKeyHeld(Keyboard.KEY_A)) camera.moveLeft();
		if(Input.isKeyHeld(Keyboard.KEY_D)) camera.moveRight();
		if(Input.isKeyHeld(Keyboard.KEY_SPACE)) camera.jump();

		if(Input.isMousePressed(0)) Input.grabMouse(true);
		else if(Input.isMousePressed(1)) Input.grabMouse(false);

		if(Input.isGrabbedMouse()) camera.rotate(Mouse.getDX() / 4, -Mouse.getDY() / 4);
		
		if(Input.isKeyPressed(Keyboard.KEY_UP)) camera.setVelocityX(0.5f);
		if(Input.isKeyPressed(Keyboard.KEY_DOWN)) camera.setVelocityX(-0.5f);
		if(Input.isKeyPressed(Keyboard.KEY_RIGHT)) camera.setVelocityZ(0.5f);
		if(Input.isKeyPressed(Keyboard.KEY_LEFT)) camera.setVelocityZ(-0.5f);
		camera.update();
		
		camera.render();
		
		cube.getPos().setX(cube.getPos().getX() + 1);
		cube.getPos().setY(0);
		cube.render();
		floor.render();
	}

	@Override
	protected void close() {}
}

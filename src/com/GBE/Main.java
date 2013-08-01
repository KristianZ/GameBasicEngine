package com.GBE;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.GBE.Entity.Camera;
import com.GBE.Entity.Cube;
import com.GBE.Entity.Floor;
import com.GBE.Positions.Position;
import com.GBE.Positions.Vector3f;
import com.GBE.Positions.Vertex;
import com.GBE.Utilities.Input;
import com.GBE.Utilities.Shape;

public class Main extends Game
{
	public Main(int width, int height, String title)
	{ super(width, height, title); }

	public static void main(String[] args)
	{ new Main(850, 480, "Game Engine"); }
	
	private Camera camera;
	private Cube cube;
	private Floor floor;
	private Shape shape;
	
	@Override
	public void init()
	{
		camera = new Camera(3, 3, 5);
		cube = new Cube(10, 10, 10, new Position(0, 3, 0));
		floor = new Floor(50, 0, 50);
		Vertex[] vertices = new Vertex[]
				{
					new Vertex(new Vector3f(-5, -5, 0)),
					new Vertex(new Vector3f(-5, -3, 0)),
					new Vertex(new Vector3f(-3, -3, 0)),
					new Vertex(new Vector3f(-3, -5, 0))
				};
		shape = new Shape(Shape.QUAD, vertices);
		
		Vertex[] rPoint = new Vertex[]
				{
					new Vertex(new Vector3f(10, -5, -10))
				};
		Vertex[] lPoint = new Vertex[]
				{
					new Vertex(new Vector3f(-10, -5, -10))
				};
		
		Shape point1 = new Shape(Shape.POINT, rPoint);
		Shape point2 = new Shape(Shape.POINT, lPoint);
		camera.addShapeToScreen(point1);
		camera.addShapeToScreen(point2);
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

		if(Input.isGrabbedMouse()) camera.rotate(Mouse.getDX() / 4, -Mouse.getDY() / 4);
		
		if(Input.isKeyPressed(Keyboard.KEY_UP)) camera.setVelocityX(0.5f);
		if(Input.isKeyPressed(Keyboard.KEY_DOWN)) camera.setVelocityX(-0.5f);
		if(Input.isKeyPressed(Keyboard.KEY_RIGHT)) camera.setVelocityZ(0.5f);
		if(Input.isKeyPressed(Keyboard.KEY_LEFT)) camera.setVelocityZ(-0.5f);
		camera.update();
		
		camera.render();
		
		cube.render();
		floor.render();
		
		shape.draw();

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

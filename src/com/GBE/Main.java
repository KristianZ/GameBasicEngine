package com.GBE;

import com.GBE.Entity.Camera;
import com.GBE.Entity.Cube;
import com.GBE.Entity.Floor;
import com.GBE.Positions.Position;
import com.GBE.Positions.Vector3f;
import com.GBE.Utilities.Shape;

public class Main extends Game
{
	public static void main(String[] args)
	{ new Main(850, 480, "Game Engine");}

	public Main(int width, int height, String title)
	{ super(width, height, title); }

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

		this.getKeyManager().registerKeyListener(new Listener(camera));
	}

	@Override
	protected void loop()
	{
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

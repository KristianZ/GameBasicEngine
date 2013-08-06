package com.GBE.Entity;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;

import com.GBE.Positions.Position;
import com.GBE.Utilities.Shape;

public class Camera extends MoveableEntity
{
	public Camera(float width, float height, float length)
	{ super(width, height, length, new Position(0, 2, 0)); }
	
	public Camera(float width, float height, float length, Position pos)
	{ super(width, height, length, pos); }

	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	
	public void addShapeToScreen(Shape shape)
	{ shapes.add(shape); }
	
	@Override
	public void render()
	{		
		glPushMatrix();
			glPointSize(10);
			for(Shape shape : shapes) shape.draw();
		glPopMatrix();
		
		glRotatef(pos.getPitch(), 1, 0, 0);
		glRotatef(pos.getYaw(), 0, 1, 0);
		
		glTranslatef(-pos.getX(), -pos.getY() - 2, -pos.getZ());
	}
}

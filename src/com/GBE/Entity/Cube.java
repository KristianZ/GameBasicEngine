package com.GBE.Entity;

import com.GBE.Positions.Position;
import com.GBE.Positions.Vector3f;
import com.GBE.Utilities.Shape;

public class Cube extends StillEntity
{
	private Shape shape;
	
	public Cube(float width, float height, float length, Position pos)
	{
		super(width, height, length, pos);
		
		float x = pos.getX();
		float y = pos.getY();
		float z = pos.getZ();
		
		Vector3f[] vertices = new Vector3f[]
			{
				// Left //
				new Vector3f(x, y, z),
				new Vector3f(x, y, z + length),
				new Vector3f(x, y + height, z + length),
				new Vector3f(x, y + height, z),
		
				// Right //
				new Vector3f(x + width, y, z),
				new Vector3f(x + width, y, z + length),
				new Vector3f(x + width, y + height, z + length),
				new Vector3f(x + width, y + height, z),
		
				// Top //
				new Vector3f(x, y, z),
				new Vector3f(x + width, y, z),
				new Vector3f(x + width, y, z + length),
				new Vector3f(x, y, z + length),
		
				// Bottom //
				new Vector3f(x, y + height, z),
				new Vector3f(x + width, y + height, z),
				new Vector3f(x + width, y + height, z + length),
				new Vector3f(x, y + height, z + length),
		
				// Front //
				new Vector3f(x, y, z),
				new Vector3f(x + width, y, z),
				new Vector3f(x + width, y + height, z),
				new Vector3f(x, y + height, z),
		
				// Back //
				new Vector3f(x, y, z + length),
				new Vector3f(x + width, y, z + length),
				new Vector3f(x + width, y + height, z + length),
				new Vector3f(x, y + height, z + length)
			};
		
		shape = new Shape(Shape.QUAD, vertices);
	}

	private boolean change = true;
	private int i = 0;
	
	@Override
	public void render()
	{
		
		if(i <= 40)
		{
			i++;
			shape.getColor().clear();
			if(change) shape.getColor().setRed(1);
			else shape.getColor().setBlue(1);
		}
		else
		{
			change = !(change);
			i = 0;
		}
		
		//shape.translate(pos.toVector3f());
		shape.rotate(shape.getRotation() + 1);
		shape.draw();
	}
}

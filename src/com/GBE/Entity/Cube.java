package com.GBE.Entity;

import com.GBE.Positions.Position;
import com.GBE.Positions.Vector3f;
import com.GBE.Positions.Vertex;
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
		
		Vertex[] vertices = new Vertex[]
			{
				// Left //
				new Vertex(new Vector3f(x, y, z)),
				new Vertex(new Vector3f(x, y, z + length)),
				new Vertex(new Vector3f(x, y + height, z + length)),
				new Vertex(new Vector3f(x, y + height, z)),
		
				// Right //
				new Vertex(new Vector3f(x + width, y, z)),
				new Vertex(new Vector3f(x + width, y, z + length)),
				new Vertex(new Vector3f(x + width, y + height, z + length)),
				new Vertex(new Vector3f(x + width, y + height, z)),
		
				// Top //
				new Vertex(new Vector3f(x, y, z)),
				new Vertex(new Vector3f(x + width, y, z)),
				new Vertex(new Vector3f(x + width, y, z + length)),
				new Vertex(new Vector3f(x, y, z + length)),
		
				// Bottom //
				new Vertex(new Vector3f(x, y + height, z)),
				new Vertex(new Vector3f(x + width, y + height, z)),
				new Vertex(new Vector3f(x + width, y + height, z + length)),
				new Vertex(new Vector3f(x, y + height, z + length)),
		
				// Front //
				new Vertex(new Vector3f(x, y, z)),
				new Vertex(new Vector3f(x + width, y, z)),
				new Vertex(new Vector3f(x + width, y + height, z)),
				new Vertex(new Vector3f(x, y + height, z)),
		
				// Back //
				new Vertex(new Vector3f(x, y, z + length)),
				new Vertex(new Vector3f(x + width, y, z + length)),
				new Vertex(new Vector3f(x + width, y + height, z + length)),
				new Vertex(new Vector3f(x, y + height, z + length))
			};
		
		shape = new Shape(Shape.QUAD, vertices);
	}

	@Override
	public void render()
	{ shape.draw(); }
}

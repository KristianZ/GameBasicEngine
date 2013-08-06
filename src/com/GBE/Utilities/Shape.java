package com.GBE.Utilities;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

import com.GBE.Positions.Vector3f;

public class Shape
{
	public static final int POINT = 0;
	public static final int LINE = 1;
	public static final int TRIANGLE = 4;
	public static final int QUAD = 7;
	public static final int POLYGON = 9;
	
	private int shape;
	private int vbo;
	private int size;
	private Color color;
	
	public Shape(int shape, Vector3f... vertices)
	{ this(shape, new Color(), vertices); }
	
	public Shape(int shape, Color color, Vector3f... vertices)
	{
		this.shape = shape;
		vbo = glGenBuffers();
		size = vertices.length;
		this.color = color;
		
		FloatBuffer buffer = BufferUtils.createFloatBuffer(vertices.length * 3);
		for(int i = 0; i < vertices.length; i++)
		{
			buffer.put(vertices[i].getX());
			buffer.put(vertices[i].getY());
			buffer.put(vertices[i].getZ());
		}	
		buffer.flip();
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, buffer, GL_STATIC_DRAW);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
	}
	
	public Shape(int shape, Texture texture, Vector3f... vertices)
	{
		
	}
	
	public Shape(int shape, Color color, Texture texture, Vector3f... vectices)
	{
		
	}
	
	public Color getColor()
	{ return color; }
	
	private int rotate;
	
	public int getRotation()
	{ return rotate; }
	
	public void rotate(int rotate)
	{ this.rotate = rotate; }
	
	private Vector3f pos = new Vector3f();
	
	public void translate(Vector3f pos)
	{ this.pos = pos; }
	
	public void draw()
	{
		glPushMatrix();
		
		color.bind();
		
		glRotatef(rotate, 1, 1, 1);
		
		glTranslatef(pos.getX(), pos.getY(), pos.getZ());
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glVertexPointer(3, GL_FLOAT, 0, 0L);
		
		glEnableClientState(GL_VERTEX_ARRAY);
		glDrawArrays(shape, 0, size);
		glDisableClientState(GL_VERTEX_ARRAY);
		
		glPopMatrix();
	}
}

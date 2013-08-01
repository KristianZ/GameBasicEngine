package com.GBE.Entity;

import static org.lwjgl.opengl.GL11.*;

import com.GBE.Positions.Position;

public class Floor extends StillEntity
{
	public Floor(float width, float height, float length)
	{ super(width, height, length); }
	
	public Floor(float width, float height, float length, Position pos)
	{ super(width, height, length, pos); }

	@Override
	public void render()
	{
		float x = pos.getX();
		float y = pos.getY();
		float z = pos.getZ();
		
		glColor3f(0.7f, 0, 0);
		glBegin(GL_LINES);
		
			for(int i = 0; i <= width; i++)
			{
				glVertex3f(x, y, z);
				glVertex3f(x, y, z + length);
				
				glVertex3f(x, y, z + length);
				glVertex3f(x + i, y, z + length);
				
				glVertex3f(x + i, y, z + length);
				glVertex3f(x + i, y, z);
				
				glVertex3f(x + i, y, z);
				glVertex3f(x, y, z);
			}
			
			for(int i = 0; i <= width; i++)
			{
				glVertex3f(x, y, z);
				glVertex3f(x, y, z + i);
				
				glVertex3f(x, y, z + i);
				glVertex3f(x + width, y, z + i);
				
				glVertex3f(x + width, y, z + i);
				glVertex3f(x + width, y, z);
				
				glVertex3f(x + width, y, z);
				glVertex3f(x, y, z);
			}
			
		glEnd();
	}
}	

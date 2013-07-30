package com.GBE.Entity;

import static org.lwjgl.opengl.GL11.*;

import com.GBE.Utilities.Vector3f;

public class Floor extends StillEntity
{
	public Floor(float width, float height, float length, Vector3f loc, float pitch, float yaw)
	{ super(width, height, length, loc, pitch, yaw); }

	@Override
	public void render()
	{
		float x = loc.getX();
		float y = loc.getY();
		float z = loc.getZ();
		
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

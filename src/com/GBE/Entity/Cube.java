package com.GBE.Entity;

import static org.lwjgl.opengl.GL11.*;

import com.GBE.Utilities.Vector3f;

public class Cube extends StillEntity
{
	public Cube(float width, float height, float length, Vector3f loc, float pitch, float yaw)
	{ super(width, height, length, loc, pitch, yaw); }

	@Override
	public void render()
	{
		float x = loc.getX();
		float y = loc.getY();
		float z = loc.getZ();
		
		glColor3f(0f, 0f, 1f);
		glBegin(GL_QUADS);

			// Left //
			glVertex3f(x, y, z);
			glVertex3f(x, y, z + length);
			glVertex3f(x, y + height, z + length);
			glVertex3f(x, y + height, z);
	
			// Right //
			glVertex3f(x + width, y, z);
			glVertex3f(x + width, y, z + length);
			glVertex3f(x + width, y + height, z + length);
			glVertex3f(x + width, y + height, z);
	
			// Top //
			glVertex3f(x, y, z);
			glVertex3f(x + width, y, z);
			glVertex3f(x + width, y, z + length);
			glVertex3f(x, y, z + length);
	
			// Bottom //
			glVertex3f(x, y + height, z);
			glVertex3f(x + width, y + height, z);
			glVertex3f(x + width, y + height, z + length);
			glVertex3f(x, y + height, z + length);
	
			// Front //
			glVertex3f(x, y, z);
			glVertex3f(x + width, y, z);
			glVertex3f(x + width, y + height, z);
			glVertex3f(x, y + height, z);
	
			// Back //
			glVertex3f(x, y, z + length);
			glVertex3f(x + width, y, z + length);
			glVertex3f(x + width, y + height, z + length);
			glVertex3f(x, y + height, z + length);

		glEnd();
	}
}

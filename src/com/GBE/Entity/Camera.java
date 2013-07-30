package com.GBE.Entity;

import static org.lwjgl.opengl.GL11.*;

import com.GBE.Game;
import com.GBE.Utilities.Vector3f;

public class Camera extends MoveableEntity
{
	public Camera(float widthX, float height,float widthZ, Vector3f loc, float pitch, float yaw, float speed,
			float jumpHeight)
	{ super(widthX, height, widthZ, loc, pitch, yaw, speed); }

	@Override
	public void render()
	{
		if(jumping)
		{
			velocityY -= Game.getGravity();
			loc.yPlusEquals(velocityY);
			if(velocityY <= 0)
			{
				jumping = false;
				falling = true;
			}
		}
		else if(falling)
		{
			velocityY -= Game.getGravity();
			loc.yPlusEquals(velocityY);
			if(loc.getY() <= groundHeight)
			{
				falling = false;
				velocityY = 0;
			}
		}
		
		glPushMatrix();
			glPointSize(10);
			glBegin(GL_POINTS);
				glVertex3f(10, -5, -10);
			glEnd();
		glPopMatrix();
		
		glRotatef(pitch, 1, 0, 0);
		glRotatef(yaw, 0, 1, 0);
		
		glTranslatef(-loc.getX(), -loc.getY() - 2, -loc.getZ());
	}
}

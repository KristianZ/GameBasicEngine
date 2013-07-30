package com.GBE.Entity;

import com.GBE.Utilities.GameClock;
import com.GBE.Utilities.Vector3f;

public abstract class MoveableEntity extends StillEntity
{
	protected float speed, groundHeight, velocityX, velocityY, velocityZ;
	protected boolean jumping, falling;
	
	public MoveableEntity(float width, float height, float length, Vector3f loc, float pitch, float yaw, float speed)
    {
		super(width, height, length, loc, pitch, yaw);
		this.speed = speed;
		groundHeight = loc.getY();
		velocityX = 0;
		velocityY = 0;
		velocityZ = 0;
		jumping = false;
		falling = false;
	}
	
	/*			*
	 *	Getters	*
	 *			*/
	public float getSpeed()
	{ return speed;  }
	
	public float getGroundHeight()
	{ return groundHeight; }
	
	public boolean isJumping()
	{ return jumping; }
	
	public boolean isFalling()
	{ return falling; }
	
	/*			*
	 *	Setters	*
	 *			*/
	public void setPitch(float pitch)
	{ this.pitch = pitch; }
	
	public void setYaw(float yaw)
	{ this.yaw = yaw; }
	
	public void setSpeed(float speed)
	{ this.speed = speed; }
	
	public void setGroundHeight(float groundHeight)
	{ this.groundHeight = groundHeight; }
	
	public void setJumping(boolean jumping)
	{ this.jumping = jumping; }
	
	public void setFalling(boolean falling)
	{ this.falling = falling; }
	
	/*				*
	 *	Utilities	*
	 *				*/
	public void moveForward()
	{	
		float speed = GameClock.getDelta() * this.speed;
		loc.xPlusEquals((float) Math.sin(Math.toRadians(yaw)) * speed);
		loc.zPlusEquals((float) -Math.cos(Math.toRadians(yaw)) * speed);
	}
	
	public void moveBackward()
	{
		float speed = GameClock.getDelta() * this.speed;
		loc.xMinusEquals((float) Math.sin(Math.toRadians(yaw)) * speed);
		loc.zMinusEquals((float) -Math.cos(Math.toRadians(yaw)) * speed);
	}
	
	public void moveRight()
	{
		float speed = GameClock.getDelta() * this.speed;
		loc.xPlusEquals((float) Math.sin(Math.toRadians(yaw + 90)) * speed);
		loc.zPlusEquals((float) -Math.cos(Math.toRadians(yaw + 90)) * speed);
	}
	
	public void moveLeft()
	{
		float speed = GameClock.getDelta() * this.speed;
		loc.xPlusEquals((float) Math.sin(Math.toRadians(yaw - 90)) * speed);
		loc.zPlusEquals((float) -Math.cos(Math.toRadians(yaw - 90)) * speed);
	}
	
	public void jump()
	{
		if(!(falling && jumping) && loc.getY() <= groundHeight)
		{
			jumping = true;
			velocityY = 0.2f;
		}
	}
	
	@Override
	public abstract void render();
}

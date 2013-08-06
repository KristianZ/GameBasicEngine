package com.GBE.Entity;

import com.GBE.Game;
import com.GBE.Positions.Position;
import com.GBE.Utilities.GameClock;

public abstract class MoveableEntity extends StillEntity
{
	protected float speed, groundHeight, velocityX, velocityY, velocityZ;
	protected boolean jumping, falling;
	
	public MoveableEntity(float width, float height, float length)
	{
		super(width, height, length);
		this.speed = 0.01f;
		groundHeight = pos.getY();
		velocityX = 0;
		velocityY = 0;
		velocityZ = 0;
		jumping = false;
		falling = false;
	}

	public MoveableEntity(float width, float height, float length, Position pos)
    {
		super(width, height, length, pos);
		this.speed = 0.01f;
		groundHeight = pos.getY();
		velocityX = 0;
		velocityY = 0;
		velocityZ = 0;
		jumping = false;
		falling = false;
	}
	
	public float getVelocityX()
	{ return velocityX; }

	public float getVelocityY()
	{ return velocityY; }

	public float getVelocityZ()
	{ return velocityZ; }
	
	public void setVelocityX(float velocityX)
	{ this.velocityX = velocityX; }

	public void setVelocityY(float velocityY)
	{ this.velocityY = velocityY; }

	public void setVelocityZ(float velocityZ)
	{ this.velocityZ = velocityZ; }

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
		pos.add((float) Math.sin(Math.toRadians(pos.getYaw())) * speed, 0, 0);
		pos.add(0, 0, (float) -Math.cos(Math.toRadians(pos.getYaw())) * speed);
	}
	
	public void moveBackward()
	{
		float speed = GameClock.getDelta() * this.speed;
		pos.subtract((float) Math.sin(Math.toRadians(pos.getYaw())) * speed, 0, 0);
		pos.subtract(0, 0, (float) -Math.cos(Math.toRadians(pos.getYaw())) * speed);
	}
	
	public void moveRight()
	{
		float speed = GameClock.getDelta() * this.speed;
		pos.add((float) Math.sin(Math.toRadians(pos.getYaw() + 90)) * speed, 0, 0);
		pos.add(0, 0, (float) -Math.cos(Math.toRadians(pos.getYaw() + 90)) * speed);
	}
	
	public void moveLeft()
	{
		float speed = GameClock.getDelta() * this.speed;
		pos.add((float) Math.sin(Math.toRadians(pos.getYaw() - 90)) * speed, 0, 0);
		pos.add(0, 0, (float) -Math.cos(Math.toRadians(pos.getYaw() - 90)) * speed);
	}
	
	public void rotate(float yaw, float pitch)
	{
		pos.setYaw(pos.getYaw() + yaw);
		float newPitch = pos.getPitch() + pitch;
		if(newPitch < 90 && newPitch > -90) pos.setPitch(newPitch);
	}
	
	public void jump()
	{
		if(!(falling && jumping) && pos.getY() <= groundHeight)
		{
			jumping = true;
			velocityY = 0.2f;
		}
	}
	
	public void update()
	{
		if(Math.abs(velocityX) >= 0.1)
		{
			if(velocityX < 0) velocityX += Game.getGravity();
			else velocityX -= Game.getGravity();
		}
		else velocityX = 0;
		
		if(jumping)
		{
			velocityY -= Game.getGravity();
			if(velocityY <= groundHeight)
			{
				jumping = false;
				falling = true;
			}
		}
		else if(falling)
		{
			velocityY -= Game.getGravity();
			if(pos.getY() <= groundHeight)
			{
				falling = false;
				velocityY = 0;
			}
		}
		
		if(Math.abs(velocityZ) >= 0.1)
		{
			if(velocityZ < 0) velocityZ += Game.getGravity();
			else velocityZ -= Game.getGravity();
		}
		else velocityZ = 0;
		
		pos.add(velocityX, velocityY, velocityZ);
	}
	
	@Override
	public abstract void render();
}

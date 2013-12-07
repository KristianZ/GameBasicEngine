package com.GBE.Entity;

import com.GBE.Game;
import com.GBE.Positions.Position;
import com.GBE.Positions.Vector3f;
import com.GBE.Utilities.GameClock;

public abstract class MoveableEntity extends StillEntity
{
	protected Vector3f velocity;
	protected float speed, groundHeight;
	protected boolean jumping, falling;
	
	public MoveableEntity(float width, float height, float length)
	{ this(width, height, length, new Position()); }

	public MoveableEntity(float width, float height, float length, Position pos)
    {
		super(width, height, length, pos);
		this.speed = 0.01f;
		groundHeight = pos.getY();
		velocity = new Vector3f();
		jumping = false;
		falling = false;
	}
	
	public float getVelocityX()
	{ return velocity.getX(); }

	public float getVelocityY()
	{ return velocity.getY(); }

	public float getVelocityZ()
	{ return velocity.getZ(); }
	
	public void setVelocityX(float x)
	{ this.velocity.setX(x); }

	public void setVelocityY(float y)
	{ this.velocity.setY(y); }

	public void setVelocityZ(float z)
	{ this.velocity.setZ(z); }

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
			velocity.setY(0.2f);
		}
	}
	
	public void update()
	{
		if(Math.abs(velocity.getX()) >= 0.1)
		{
			if(velocity.getX() < 0) velocity.setX(velocity.getX() + Game.getGravity());
			else velocity.setX(velocity.getX() - Game.getGravity());
		}
		else velocity.setX(0);
		
		if(jumping)
		{
			velocity.setY(velocity.getY() - Game.getGravity());
			if(velocity.getY() <= groundHeight)
			{
				jumping = false;
				falling = true;
			}
		}
		else if(falling)
		{
			velocity.setY(velocity.getY() - Game.getGravity());
			if(pos.getY() <= groundHeight)
			{
				falling = false;
				velocity.setY(0);
			}
		}

		if(Math.abs(velocity.getZ()) >= 0.1)
		{
			if(velocity.getZ() < 0) velocity.setZ(velocity.getZ() + Game.getGravity());
			else velocity.setZ(velocity.getZ() - Game.getGravity());
		}
		else velocity.setZ(0);
	}
	
	@Override
	public abstract void render();
}

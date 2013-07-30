package com.GBE.Entity;

import com.GBE.Utilities.Vector3f;

public abstract class StillEntity implements Entity
{
	protected Vector3f loc;
	protected float width, height, length, pitch, yaw;
	
	public StillEntity(float width, float height, float length, Vector3f loc, float pitch, float yaw)
	{
		this.width	= width;
		this.length	= length;
		this.height	= height;
		this.loc	= loc;
		this.pitch	= pitch;
		this.yaw	= yaw;
	}
	
	/*			*
	 *	Getters	*
	 *			*/
	@Override
	public float getWidth()
	{ return width; }
	
	@Override
	public float getHeight()
	{ return height; }
	
	@Override
	public float getLength()
	{ return length; }
	
	@Override
	public Vector3f getLoc()
	{ return loc; }
	
	@Override
	public float getPitch()
	{ return pitch; }
	
	@Override
	public float getYaw()
	{ return yaw; }
	
	/*				*
	 *	Utilities	*
	 *				*/
	@Override
	public abstract void render();
}

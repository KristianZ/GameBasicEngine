package com.GBE.Entity;

import com.GBE.Positions.Position;

public abstract class StillEntity implements Entity
{
	protected Position pos;
	protected float width, height, length;
	
	public StillEntity(float width, float height, float length)
	{
		this.width	= width;
		this.height	= height;
		this.length	= length;
		this.pos	= new Position();
	}
	
	public StillEntity(float width, float height, float length, Position pos)
	{
		this.width	= width;
		this.length	= length;
		this.height	= height;
		this.pos	= pos;
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
	public Position getPos()
	{ return pos; }
	
	/*				*
	 *	Utilities	*
	 *				*/
	@Override
	public abstract void render();
}

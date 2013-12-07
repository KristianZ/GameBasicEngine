package com.GBE.Entity;

import com.GBE.Positions.Position;
import com.GBE.Positions.Vector3f;

public abstract class StillEntity implements Entity
{
	protected Vector3f size;
	protected Position pos;
	
	public StillEntity(float width, float height, float length)
	{ this(width, height, length, new Position()); }
	
	public StillEntity(float width, float height, float length, Position pos)
	{
		this.size	= new Vector3f(width, height, length);
		this.pos	= pos;
	}
	
	/*			*
	 *	Getters	*
	 *			*/
	@Override
	public float getWidth()
	{ return size.getX(); }
	
	@Override
	public float getHeight()
	{ return size.getY(); }
	
	@Override
	public float getLength()
	{ return size.getZ(); }
	
	@Override
	public Position getPos()
	{ return pos; }
	
	/*				*
	 *	Utilities	*
	 *				*/
	@Override
	public abstract void render();
}

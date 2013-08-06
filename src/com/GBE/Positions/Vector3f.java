package com.GBE.Positions;

public class Vector3f
{
	private float x, y, z;
	
	public Vector3f()
	{ x = y = z = 0; }
	
	public Vector3f(float x, float y, float z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/*			*
	 *	Getters	*
	 *			*/
	public float getX()
	{ return x; }
	
	public float getY()
	{ return y; }
	
	public float getZ()
	{ return z; }
	
	/*			*
	 *	Setters	*
	 *			*/
	public void setX(float x)
	{ this.x = x; }
	
	public void setY(float y)
	{ this.y = y; }
	
	public void setZ(float z)
	{ this.z = z; }
	
	/*				*
	 *	Operations	*
	 *				*/
	public Vector3f add(float value)
	{
		x += value;
		y += value;
		z += value;
		return this;
	}
	
	public Vector3f add(Vector3f vec)
	{
		if(vec == null) throw new IllegalArgumentException("Cannot add by null Vector3f!");
		
		x += vec.getX();
		y += vec.getY();
		z += vec.getZ();
		return this;
	}
	
	public Vector3f add(Position pos)
	{
		if(pos == null) throw new IllegalArgumentException("Cannot add by null Position!");
		
		x += pos.getX();
		y += pos.getY();
		z += pos.getZ();
		return this;
	}
	
	public Vector3f subtract(float value)
	{
		x -= value;
		y -= value;
		z -= value;
		return this;
	}
	
	public Vector3f subtract(Vector3f vec)
	{
		if(vec == null) throw new IllegalArgumentException("Cannot subtract by null Vector3f!");
		
		x -= vec.getX();
		y -= vec.getY();
		z -= vec.getZ();
		return this;
	}
	
	public Vector3f subtract(Position pos)
	{
		if(pos == null) throw new IllegalArgumentException("Cannot subtract by null Position!");
		
		x -= pos.getX();
		y -= pos.getY();
		z -= pos.getZ();
		return this;
	}
	
	public Vector3f multiply(float value)
	{
		x *= value;
		y *= value;
		z *= value;
		return this;
	}
	
	public void multiply(Vector3f vec)
	{
		if(vec == null) throw new IllegalArgumentException("Cannot multiply by null Vector3f!");
		
		x *= vec.getX();
		y *= vec.getY();
		z *= vec.getZ();
	}
	
	public Vector3f multiply(Position pos)
	{
		if(pos == null) throw new IllegalArgumentException("Cannot multiply by null Position!");
		
		x *= pos.getX();
		y *= pos.getY();
		z *= pos.getZ();
		return this;
	}
	
	public Vector3f divide(float value)
	{
		x /= value;
		y /= value;
		z /= value;
		return this;
	}
	
	public Vector3f divide(Vector3f vec)
	{
		if(vec == null) throw new IllegalArgumentException("Cannot divide by null Vector3f!");
		
		x /= vec.getX();
		y /= vec.getY();
		z /= vec.getZ();
		return this;
	}
	
	public Vector3f divide(Position pos)
	{
		if(pos == null) throw new IllegalArgumentException("Cannot divide by null Position!");
		
		x /= pos.getX();
		y /= pos.getY();
		z /= pos.getZ();
		return this;
	}
	
	/*				*
	 *	Utilities	*
	 *				*/
	public float length()
	{ return (float) Math.sqrt(this.lengthSquared()); }
	
	public float lengthSquared()
	{ return (float) (Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2)); }
	
	public float distance(Vector3f vec)
	{
		if(vec == null) throw new IllegalArgumentException("Cannot compare distance to a null Vector3f!");
		
		return (float) Math.sqrt(this.distanceSquared(vec));
	}
	
	public float distanceSquared(Vector3f vec)
	{
		if(vec == null) throw new IllegalArgumentException("Cannot compare distance to a null Vector3f!");
		
		return (float) (Math.pow(x - vec.getX(), 2) + Math.pow(y - vec.getY(), 2) + Math.pow(z - vec.getZ(), 2));
	}
	
	public Vector3f normalize()
	{
		float length = this.length();
		return new Vector3f(x / length, y / length, z / length);
	}
	
	public void zero()
	{ x = y = z = 0; }
	
	@Override
	public String toString()
	{ return x + " " + y + " " + z; }
	
	public Position toPosition()
	{ return new Position(x, y, z); }
}

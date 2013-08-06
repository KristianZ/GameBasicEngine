package com.GBE.Positions;

public class Position
{
	private float x, y, z, yaw, pitch;
	
	public Position()
	{ x = y = z = yaw = pitch = 0; }
	
	public Position(float x, float y, float z)
	{
		this.x 		= x;
		this.y		= y;
		this.z		= z;
		yaw = pitch = 0;
	}
	
	public Position(float x, float y, float z, float yaw, float pitch)
	{
		this.x		= x;
		this.y		= y;
		this.z		= z;
		this.yaw	= yaw;
		this.pitch	= pitch;
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
	
	public float getYaw()
	{ return yaw; }
	
	public float getPitch()
	{ return pitch; }
	
	/*			*
	 *	Setters	*
	 *			*/
	public void setX(float x)
	{ this.x = x; }
	
	public void setY(float y)
	{ this.y = y; }
	
	public void setZ(float z)
	{ this.z = z; }
	
	public void setYaw(float yaw)
	{ this.yaw = yaw; }
	
	public void setPitch(float pitch)
	{ this.pitch = pitch; }
	
	/*				*
	 *	Operations	*
	 *				*/
	public Position add(float x, float y, float z)
	{
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}
	
	public Position add(Vector3f vec)
	{
		if(vec == null) throw new IllegalArgumentException("Cannot add null Vector3f!");
		
		x += vec.getX();
		y += vec.getY();
		z += vec.getZ();
		return this;
	}
	
	public Position add(Position pos)
	{
		if(pos == null) throw new IllegalArgumentException("Cannot add null Position!");
		
		x += pos.getX();
		y += pos.getY();
		z += pos.getZ();
		return this;
	}

	public Position subtract(float x, float y, float z)
	{
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}
	
	public Position subtract(Vector3f vec)
	{
		if(vec == null) throw new IllegalArgumentException("Cannot subtract null Vector3f!");
		
		x -= vec.getX();
		y -= vec.getY();
		z -= vec.getZ();
		return this;
	}
	
	public Position subtract(Position pos)
	{
		if(pos == null) throw new IllegalArgumentException("Cannot subtract null Position!");
		
		x -= pos.getX();
		y -= pos.getY();
		z -= pos.getZ();
		return this;
	}

	public Position multiply(float x, float y, float z)
	{
		this.x *= x;
		this.y *= y;
		this.z *= z;
		return this;
	}
	
	public Position multiply(Vector3f vec)
	{
		if(vec == null) throw new IllegalArgumentException("Cannot multiply null Vector3f!");
		
		x *= vec.getX();
		y *= vec.getY();
		z *= vec.getZ();
		return this;
	}
	
	public Position multiply(Position pos)
	{
		if(pos == null) throw new IllegalArgumentException("Cannot multiply null Position!");
		
		x *= pos.getX();
		y *= pos.getY();
		z *= pos.getZ();
		return this;
	}
	
	public Position divide(float x, float y, float z)
	{
		this.x /= x;
		this.y /= y;
		this.z /= z;
		return this;
	}
	
	public Position divide(Vector3f vec)
	{
		if(vec == null) throw new IllegalArgumentException("Cannot divide null Vector3f!");
		
		x /= vec.getX();
		y /= vec.getY();
		z /= vec.getZ();
		return this;
	}
	
	public Position divide(Position pos)
	{
		if(pos == null) throw new IllegalArgumentException("Cannot divide null Position!");
		
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
	
	public float distance(Position pos)
	{
		if(pos == null) throw new IllegalArgumentException("Cannot compare distance to a null Position!");
		
		return (float) Math.sqrt(this.distanceSquared(pos));
	}
	
	public float distanceSquared(Position pos)
	{
		if(pos == null) throw new IllegalArgumentException("Cannot compare distance to a null Position!");
		
		return (float) (Math.pow(x - pos.getX(), 2) + Math.pow(y - pos.getY(), 2) + Math.pow(z - pos.getZ(), 2));
	}
	
	public Position normalize()
	{
		float length = this.length();
		return new Position(x / length, y / length, z / length);
	}
	
	public void zero()
	{ x = y = z = yaw = pitch = 0; }
	
	@Override
	public String toString()
	{ return x + " " + y + " " + z + " " + yaw + " " + pitch; }
	
	public Vector3f toVector3f()
	{ return new Vector3f(x, y, z); }
}

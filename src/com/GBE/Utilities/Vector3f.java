package com.GBE.Utilities;

public class Vector3f
{
	private float x, y, z;
	
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
	public void add(float value)
	{
		x += value;
		y += value;
		z += value;
	}
	
	public void add(Vector3f vector)
	{
		x += vector.getX();
		y += vector.getY();
		z += vector.getZ();
	}
	
	public void sub(float value)
	{
		x -= value;
		y -= value;
		z -= value;
	}
	
	public void sub(Vector3f vector)
	{
		x -= vector.getX();
		y -= vector.getY();
		z -= vector.getZ();
	}
	
	public void mul(float value)
	{
		x *= value;
		y *= value;
		z *= value;
	}
	
	public void mul(Vector3f vector)
	{
		x *= vector.getX();
		y *= vector.getY();
		z *= vector.getZ();
	}
	
	public void div(float value)
	{
		x /= value;
		y /= value;
		z /= value;
	}
	
	public void div(Vector3f vector)
	{
		x /= vector.getX();
		y /= vector.getY();
		z /= vector.getZ();
	}
	
	/*						*
	 *	Plus / Minus Equals	*
	 *						*/
	public void xPlusEquals(float value)
	{ this.x += value; }
	
	public void xMinusEquals(float value)
	{ this.x -= value; }
	
	public void yPlusEquals(float value)
	{ this.y += value; }
	
	public void yMinusEquals(float value)
	{ this.y -= value; }
	
	public void zPlusEquals(float value)
	{ this.z += value; }
	
	public void zMinusEquals(float value)
	{ this.z -= value; }
	
	/*				*
	 *	Utilities	*
	 *				*/
	public float length()
	{ return (float) Math.sqrt(x * x + y * y + z * z); }
	
	public Vector3f normalize()
	{
		float length = this.length();
		return new Vector3f(x / length, y / length, z / length);
	}
}

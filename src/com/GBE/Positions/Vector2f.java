package com.GBE.Positions;

public class Vector2f
{
	private float x, y;
	
	public Vector2f(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	/*			*
	 *	Getters	*
	 *			*/
	public float getX()
	{ return x; }
	
	public float getY()
	{ return y; }
	
	/*			*
	 *	Setters	*
	 *			*/
	public void setX(float x)
	{ this.x = x; }
	
	public void setY(float y)
	{ this.y = y; }
	
	/*				*
	 *	Operations	*
	 *				*/
	public void add(float value)
	{
		x += value;
		y += value;
	}
	
	public void add(Vector2f vector)
	{
		x += vector.getX();
		y += vector.getY();
	}
	
	public void sub(float value)
	{
		x -= value;
		y -= value;
	}
	
	public void sub(Vector2f vector)
	{
		x -= vector.getX();
		y -= vector.getY();
	}
	
	public void mul(float value)
	{
		x *= value;
		y *= value;
	}
	
	public void mul(Vector2f vector)
	{
		x *= vector.getX();
		y *= vector.getY();
	}
	
	public void div(float value)
	{
		x /= value;
		y /= value;
	}
	
	public void div(Vector2f vector)
	{
		x /= vector.getX();
		y /= vector.getY();
	}
	
	/*				*
	 *	Utilities	*
	 *				*/
	public float length()
	{ return (float) Math.sqrt(x * x + y * y); }
	
	public Vector2f normalize()
	{
		float length = this.length();
		return new Vector2f(x / length, y / length);
	}
}

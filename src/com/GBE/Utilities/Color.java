package com.GBE.Utilities;

import static org.lwjgl.opengl.GL11.*;

import com.GBE.Positions.Vector3f;

public class Color
{
	private Vector3f color;
	
	public Color()
	{ color = new Vector3f(); }
	
	public Color(int r, int g, int b)
	{ this.color = new Vector3f(r, g, b); }
	
	public Color(Vector3f color)
	{ this.color = color; }
	
	/*			*
	 *	Getters	*
	 *			*/
	public float getRed()
	{ return color.getX(); }
	
	public float getGreen()
	{ return color.getY(); }
	
	public float getBlue()
	{ return color.getZ(); }
	
	public Vector3f getRGB()
	{ return color; }
	
	/*			*
	 *	Setters	*
	 *			*/
	public void setRed(float r)
	{ color.setX(r); }
	
	public void setGreen(float g)
	{ color.setY(g); }
	
	public void setBlue(float b)
	{ color.setZ(b); }
	
	public void setRGB(Vector3f color)
	{ this.color = color; }
	
	/*				*
	 *	Utilities	*
	 *				*/
	public void bind()
	{ glColor3f(color.getX(), color.getY(), color.getZ()); }
	
	public void clear()
	{ color.zero(); }
}

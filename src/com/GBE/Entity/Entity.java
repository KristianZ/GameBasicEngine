package com.GBE.Entity;

import com.GBE.Utilities.Vector3f;

public interface Entity
{
	public float getWidth();
	
	public float getHeight();
	
	public float getLength();
	
	public Vector3f getLoc();
	
	public float getPitch();
	
	public float getYaw();
	
	public void render();
}

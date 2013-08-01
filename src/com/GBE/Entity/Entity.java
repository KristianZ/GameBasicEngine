package com.GBE.Entity;

import com.GBE.Positions.Position;

public interface Entity
{
	public float getWidth();
	
	public float getHeight();
	
	public float getLength();
	
	public Position getPos();
	
	public void render();
}

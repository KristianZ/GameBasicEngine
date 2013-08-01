package com.GBE.Utilities;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.TextureLoader;

public class Texture
{
	private int id;
	
	public Texture(String imagePath)
	{
		String[] split = imagePath.split("\\.");
		String ext = split[split.length - 1];
		
		try
		{ id = TextureLoader.getTexture(ext, new FileInputStream(new File(imagePath))).getTextureID(); }
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			id = 0;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			id = 0;
		}
	}
	
	public void bind()
	{ glBindTexture(GL_TEXTURE_2D, id); }
	
	public int getId()
	{ return id; }
	
	/*					*
	 *	Static Methods	*
	 *					*/
	public static void clear()
	{
		glBindTexture(GL_TEXTURE_2D, 0);
		glColor3f(0, 0, 0);
	}
	
	public static void enable(boolean enabled)
	{
		if(enabled) glEnable(GL_TEXTURE_2D);
		else glDisable(GL_TEXTURE_2D);
	}
}

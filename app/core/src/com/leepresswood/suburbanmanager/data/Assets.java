package com.leepresswood.suburbanmanager.data;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets extends AssetManager
{
	
	public Assets()
	{
		
		//Textures
		load("hold.png", Texture.class);
	}
	
	public void destroy()
	{
		dispose();
	}
}

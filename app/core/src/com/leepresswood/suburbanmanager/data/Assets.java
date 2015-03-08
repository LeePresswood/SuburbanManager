package com.leepresswood.suburbanmanager.data;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Assets extends AssetManager
{	
	public static final int MAP_TEST = 0;
	
	public Assets()
	{
		//Maps
		setLoader(TiledMap.class, new TmxMapLoader(new InternalFileHandleResolver()));
		load("maps/map.tmx", TiledMap.class);
		
		//Textures
		load("person/textures/hold.png", Texture.class);
	}
	
	public TiledMap getMap(int map)
	{
		switch(map)
		{
			case MAP_TEST:
				return get("maps/map.tmx", TiledMap.class);
			default:
				return null;
		}
	}
	
	public void destroy()
	{
		dispose();
	}
}

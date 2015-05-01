package com.leepresswood.suburbanmanager.data;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class Assets extends AssetManager
{
	
	public Assets()
	{		
		//Textures
		for(int i = 0; i < NUMBER_ROAD; i++)
			load(PATH_ROAD + "(0" + i + ").png", Texture.class);
		for(int i = 0; i < NUMBER_TERRAIN; i++)
			load(PATH_TERRAIN + "(" + i + ").png", Texture.class);
		for(int i = 0; i < NUMBER_WATER; i++)
			load(PATH_WATER + "(" + i + ").png", Texture.class);
	}
	
	public void destroy()
	{
		dispose();
	}
	
	//Easy-to-call filenames.
	//Tiles
	//Roads
	public final int NUMBER_ROAD = 19;
	public final String PATH_ROAD = "tiles/road/";
	public final String ROAD_CORNER_BOT_RIGHT = PATH_ROAD + "(07).png";
	public final String ROAD_CORNER_LEFT_BOT = PATH_ROAD + "(08).png";
	public final String ROAD_VERT_RIGHT = PATH_ROAD + "(01).png";
	public final String ROAD_VERT_LEFT = PATH_ROAD + "(02).png";
	public final String ROAD_CROSS = PATH_ROAD + "(00).png";
	public final String ROAD_CORNER_TOP_RIGHT = PATH_ROAD + "(05).png";
	public final String ROAD_CORNER_LEFT_TOP = PATH_ROAD + "(06).png";
	public final String ROAD_HORI_TOP = PATH_ROAD + "(03).png";
	public final String ROAD_HORI_BOT = PATH_ROAD + "(04).png";
	public final String ROAD_END_TOP = PATH_ROAD + "(016).png";
	public final String ROAD_END_BOT = PATH_ROAD + "(015).png";
	public final String ROAD_END_RIGHT = PATH_ROAD + "(017).png";
	public final String ROAD_END_LEFT = PATH_ROAD + "(018).png";
	public final String ROAD_VERT = PATH_ROAD + "(09).png";
	public final String ROAD_HORI_WATER_FULL = PATH_ROAD + "(013).png";
	public final String ROAD_HORI_WATER_PARTIAL = PATH_ROAD + "(014).png";
	public final String ROAD_VERT_WATER_FULL = PATH_ROAD + "(011).png";
	public final String ROAD_VERT_WATER_PARTIAL = PATH_ROAD + "(012).png";
	public final String ROAD_HORI = PATH_ROAD + "(010).png";
	
	//Terrain
	public final int NUMBER_TERRAIN = 6;
	public final String PATH_TERRAIN = "tiles/terrain/";
	public final String TERRAIN_GRASS = PATH_TERRAIN + "(0).png";
	public final String TERRAIN_DIRT = PATH_TERRAIN + "(1).png";
	public final String TERRAIN_SAND = PATH_TERRAIN + "(2).png";
	public final String TERRAIN_WATER = PATH_TERRAIN + "(3).png";
	public final String TERRAIN_SIDEWALK = PATH_TERRAIN + "(4).png";
	public final String TERRAIN_ROAD = PATH_TERRAIN + "(5).png";
	
	//Water
	public final int NUMBER_WATER = 18;
	public final String PATH_WATER = "tiles/water/";
	public final String WATER_CORNER_LEFT_BOT_NO = PATH_WATER + "(0).png";
	public final String WATER_CORNER_BOT_RIGHT_YES = PATH_WATER + "(1).png";
	public final String WATER_CORNER_LEFT_BOT_YES = PATH_WATER + "(2).png";
	public final String WATER_LAND_CORNER_BOT_RIGHT = PATH_WATER + "(3).png";
	public final String WATER_LAND_CORNER_LEFT_BOT = PATH_WATER + "(4).png";
	public final String WATER_HORI = PATH_WATER + "(5).png";
	public final String WATER_CORNER_TOP_RIGHT_NO = PATH_WATER + "(6).png";
	public final String WATER_CORNER_LEFT_TOP_NO = PATH_WATER + "(7).png";
	public final String WATER_CORNER_TOP_RIGHT_YES = PATH_WATER + "(8).png";
	public final String WATER_CORNER_LEFT_TOP_YES = PATH_WATER + "(9).png";
	public final String WATER_LAND_CORNER_TOP_RIGHT = PATH_WATER + "(10).png";
	public final String WATER_LAND_CORNER_LEFT_TOP = PATH_WATER + "(11).png";
	public final String WATER_SIDE_LEFT = PATH_WATER + "(12).png";
	public final String WATER_SIDE_RIGHT = PATH_WATER + "(13).png";
	public final String WATER_SIDE_TOP = PATH_WATER + "(14).png";
	public final String WATER_SIDE_BOT = PATH_WATER + "(15).png";
	public final String WATER_VERT = PATH_WATER + "(16).png";
	public final String WATER_CORNER_BOT_RIGHT_NO = PATH_WATER + "(17).png";
}

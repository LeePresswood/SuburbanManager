package com.leepresswood.suburbanmanager.screens.game.objects.road;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.leepresswood.suburbanmanager.data.Assets;
import com.leepresswood.suburbanmanager.screens.game.objects.grid.GridManager;


public class RoadAdjust
{
	/**
	 * We must adjust the roads so that they work graphically. That happens here.
	 * @param manager Reference to grid manager that holds game items.
	 * @param index Index of road that will be examined.
	 * @return Texture to use for the given road.
	 */
	public static Texture adjust(GridManager manager, int index)
	{		
		//Get AssetManager.
		Assets assets = manager.world.screen.game.assets;
		
		//Get an array of possible textures depending upon what is around the road tile.
		ArrayList<String> array = new ArrayList<String>();		
		
		//Get all road textures.
		for(int i = 0; i < assets.NUMBER_ROAD; i++)
			array.add(assets.PATH_ROAD + "(0" + i + ").png");
		
		//Prune textures.
		prune(manager, index, array);
		
		//Get lowest index road remaining. This will be the road that connects to the fewest sides while still hitting everyone.
		if(!array.isEmpty())
			return assets.get(array.get(0), Texture.class);
		
		//No surrounding roads. Return cross.
		return assets.get(assets.ROAD_CROSS, Texture.class);
	}
	
	/**
	 * Remove road segments that can't be the attaching segment. This is done by checking the squares around this tile and seeing if they are
	 * road tiles. If they aren't, remove every tile segment that attaches to that direction.
	 * @param manager
	 * @param index
	 * @param array
	 */
	private static void prune(GridManager manager, int index, ArrayList<String> array)
	{
		Assets assets = manager.world.screen.game.assets;
		
		//Get coordinates of the tile. 0 -> X and 1 -> Y.
		int[] coord = manager.fromGridID(index);
		
		//Check side. If not a road, remove all array roads that connect to that side.
		//Top
		if(coord[1] + 1 < manager.world.world_total_vertical)
			if(manager.game_objects.get(manager.toGridID(coord[0], coord[1] + 1)) == null)
				pruneTop(array, assets);
		
		//Bottom
		if(coord[1] - 1 >= 0)
			if(manager.game_objects.get(manager.toGridID(coord[0], coord[1] - 1)) == null)
				pruneBottom(array, assets);
		
		//Left
		if(coord[0] - 1 >= 0)
			if(manager.game_objects.get(manager.toGridID(coord[0] - 1, coord[1])) == null)
				pruneLeft(array, assets);
		
		//Right
		if(coord[0] + 1 < manager.world.world_total_horizontal)
			if(manager.game_objects.get(manager.toGridID(coord[0] + 1, coord[1])) == null)
				pruneRight(array, assets);
	}
	
	private static void pruneTop(ArrayList<String> array, Assets assets)
	{
		array.remove(assets.ROAD_CROSS);
		
		array.remove(assets.ROAD_CORNER_LEFT_TOP);
		array.remove(assets.ROAD_CORNER_TOP_RIGHT);
		
		array.remove(assets.ROAD_END_TOP);
		
		array.remove(assets.ROAD_HORI_TOP);
		
		array.remove(assets.ROAD_VERT);
		array.remove(assets.ROAD_VERT_LEFT);
		array.remove(assets.ROAD_VERT_RIGHT);
		
		array.remove(assets.ROAD_VERT_WATER_FULL);
		array.remove(assets.ROAD_VERT_WATER_PARTIAL);
	}
	
	private static void pruneBottom(ArrayList<String> array, Assets assets)
	{
		array.remove(assets.ROAD_CROSS);
		
		array.remove(assets.ROAD_CORNER_LEFT_BOT);
		array.remove(assets.ROAD_CORNER_BOT_RIGHT);
		
		array.remove(assets.ROAD_END_BOT);
		
		array.remove(assets.ROAD_HORI_BOT);
		
		array.remove(assets.ROAD_VERT);
		array.remove(assets.ROAD_VERT_LEFT);
		array.remove(assets.ROAD_VERT_RIGHT);
		
		array.remove(assets.ROAD_VERT_WATER_FULL);
		array.remove(assets.ROAD_VERT_WATER_PARTIAL);
	}
	
	private static void pruneLeft(ArrayList<String> array, Assets assets)
	{
		array.remove(assets.ROAD_CROSS);
		
		array.remove(assets.ROAD_CORNER_LEFT_TOP);
		array.remove(assets.ROAD_CORNER_LEFT_BOT);
		
		array.remove(assets.ROAD_END_LEFT);
		
		array.remove(assets.ROAD_HORI);
		array.remove(assets.ROAD_HORI_TOP);
		array.remove(assets.ROAD_HORI_BOT);
		
		array.remove(assets.ROAD_VERT_LEFT);
		
		array.remove(assets.ROAD_HORI_WATER_FULL);
		array.remove(assets.ROAD_HORI_WATER_PARTIAL);
	}
	
	private static void pruneRight(ArrayList<String> array, Assets assets)
	{
		array.remove(assets.ROAD_CROSS);
		
		array.remove(assets.ROAD_CORNER_TOP_RIGHT);
		array.remove(assets.ROAD_CORNER_BOT_RIGHT);
		      
		array.remove(assets.ROAD_END_RIGHT);
		      
		array.remove(assets.ROAD_HORI);
		array.remove(assets.ROAD_HORI_TOP);
		array.remove(assets.ROAD_HORI_BOT);
		      
		array.remove(assets.ROAD_VERT_RIGHT);
		
		array.remove(assets.ROAD_HORI_WATER_FULL);
		array.remove(assets.ROAD_HORI_WATER_PARTIAL);
	}
}

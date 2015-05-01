package com.leepresswood.suburbanmanager.screens.game.objects.road;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
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
		//Get coordinates of the tile. 0 = X and 1 = Y.
		int[] coord = manager.fromGridID(index);
		
		int min_x = 0;
		int min_y = 0;
		int max_x = manager.world.world_total_horizontal;
		int max_y = manager.world.world_total_vertical;
		
		//Get an array of possible textures depending upon what is around the road tile.
		ArrayList<Texture> top = new ArrayList<Texture>();
		ArrayList<Texture> bottom = new ArrayList<Texture>();
		ArrayList<Texture> left = new ArrayList<Texture>();
		ArrayList<Texture> right = new ArrayList<Texture>();
		
		
		
		return null;
	}
}

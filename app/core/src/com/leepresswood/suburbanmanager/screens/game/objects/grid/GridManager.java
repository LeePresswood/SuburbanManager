package com.leepresswood.suburbanmanager.screens.game.objects.grid;

import java.util.HashMap;
import com.leepresswood.suburbanmanager.screens.game.GameWorld;
import com.leepresswood.suburbanmanager.screens.game.objects.road.Road;

/**
 * Manages the multiple grids of the world. Manages grid objects as well.
 * @author Lee
 *
 */
public class GridManager
{
	public GameWorld world;											//Instance of world.
	
	public HashMap<Integer, GridObject> game_objects;		//Objects of the grid. Call them through their IDs received by their indices.
	public GridObjectEnum current_object;						//Current object being added.
	
	public GridManager(GameWorld world)	
	{
		this.world = world;
		
		game_objects = new HashMap<Integer, GridObject>();
	}
	
	/**
	 * In the process of setting up the world, we want to fill the world with grass.
	 */
	public void init()
	{
		for(int y = 0; y < world.world_total_vertical; y++)
		{
			for(int x = 0; x < world.world_total_horizontal; x++)
			{
				game_objects.put(toGridID(x, y), GridObjectFactory.get(GridObjectEnum.GRASS, x, y, this));
			}
		}	
		
		current_object = GridObjectEnum.ROAD;
	}
	
	/**
	 * Update all tiles and objects.
	 * @param delta Change in time.
	 */
	public void update(float delta)
	{
		for(int y = 0; y < world.world_total_vertical; y++)
		{
			for(int x = 0; x < world.world_total_horizontal; x++)
			{
				game_objects.get(toGridID(x, y)).update(delta);
			}
		}			
	}
	
	/**
	 * Draw all tiles.
	 */
	public void draw()
	{
		for(int y = 0; y < world.world_total_vertical; y++)
		{
			for(int x = 0; x < world.world_total_horizontal; x++)
			{
				game_objects.get(toGridID(x, y)).draw();
			}
		}
	}
	
	/**
	 * Turn world coordinates into a grid ID.
	 * @param x X position on the grid.
	 * @param y Y position on the grid.
	 * @return Single-dimension coordinate to use as ID.
	 */
	public Integer toGridID(int x, int y)
	{
		return x + y * world.world_total_horizontal;
	}
	
	/**
	 * Turn grid ID back into world coordinates.
	 * @param id Grid ID to transform.
	 * @return 
	 */
	public int[] fromGridID(int id)
	{
		return new int[]{id % world.world_total_horizontal, id / world.world_total_horizontal};
	}
	
	/**
	 * Player requested to click object on the grid. Work on grid as necessary.
	 * @param x X location of click. Translated to grid click.
	 * @param y Y location of click. Translated to grid click.
	 */
	public void clickAt(int x, int y)
	{
		//Click must be within world bounds.
		if(world.isWithin(x, y))
		{
			//Calling for the world object at x,y will give the item (or nothing if empty).
			if(game_objects.get(toGridID(x, y)).active)
			{//Game object found. Do correct action on object.
				
			}
			else
			{//No object found. Do correct action on tile.
				//Add and adjust roads.
				game_objects.put(toGridID(x, y), GridObjectFactory.get(current_object, x, y, this));
				adjustRoads();
			}
		}		
	}

	public void deleteAt(int x, int y)
	{
		//Click must be within world bounds.
		if(world.isWithin(x, y))
		{
			//Calling for the world object at x,y will give the item (or nothing if empty).
			if(game_objects.get(toGridID(x, y)).active)
			{//Game object found. Do correct action on object.
				//Delete and adjust roads.
				game_objects.put(toGridID(x, y), GridObjectFactory.get(GridObjectEnum.GRASS, x, y, this));
				adjustRoads();
			}			
			else
			{//No object found. Do correct action on tile.
				
			}
		}
	}
	
	/**
	 * Go through every tile and find the roads. Adjust the roads to represent the new state of the map.
	 */
	private void adjustRoads()
	{
		for(int j = 0; j < world.world_total_vertical; j++)
		{
			for(int i = 0; i < world.world_total_horizontal; i++)
			{
				GridObject o = game_objects.get(toGridID(i, j));
				if(o instanceof Road)
					((Road) o).updateTexture();
			}
		}
	}
}

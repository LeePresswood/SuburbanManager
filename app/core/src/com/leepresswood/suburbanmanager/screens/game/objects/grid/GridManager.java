package com.leepresswood.suburbanmanager.screens.game.objects.grid;

import java.util.HashMap;

import com.badlogic.gdx.math.Vector3;
import com.leepresswood.suburbanmanager.screens.game.GameWorld;
import com.leepresswood.suburbanmanager.screens.game.objects.road.Road;

/**
 * Manages the multiple grids of the world. Manages grid objects as well.
 * @author Lee
 *
 */
public class GridManager
{
	public GameWorld world;
	public HashMap<Integer, GridObject> game_objects;		//Objects of the grid. Call them through their IDs received by their indices.
	public GridObjectEnum current_object;
	
	public GridManager(GameWorld world)	
	{
		this.world = world;
		
		game_objects = new HashMap<Integer, GridObject>();
		current_object = GridObjectEnum.ROAD;
	}
	
	/**
	 * Update all tiles and objects.
	 * @param delta Change in time.
	 */
	public void update(float delta)
	{
		for(GridObject o : game_objects.values())
			o.update(delta);
	}
	
	/**
	 * Draw all tiles.
	 */
	public void draw()
	{
		for(GridObject o : game_objects.values())
			o.draw();
	}
	
	/**
	 * Return the object that was touched.
	 * @param touch
	 * @return
	 */
	public GridObject getTouchedTile(Vector3 touch)
	{
		for(GridObject o : game_objects.values())
			if(o.sprite.getBoundingRectangle().contains(touch.x, touch.y))
				return o;
		
		return null;
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
		//Calling for the world object at x,y will give the item (or nothing if empty).
		GridObject o = game_objects.get(toGridID(x, y));
		if(o != null)
		{//Game object found. Do correct action on object.
			
		}
		else
		{//No object found. Do correct action on tile.
			//Add
			game_objects.put(toGridID(x, y), GridObjectFactory.get(current_object, x, y, this));
			for(GridObject object : game_objects.values())
				if(object instanceof Road)
					((Road) object).updateTexture();
		}
	}
}

package com.leepresswood.suburbanmanager.screens.game.objects.grid;

import java.util.ArrayList;
import com.leepresswood.suburbanmanager.screens.game.GameWorld;

/**
 * Manages the multiple grids of the world. Manages grid objects as well.
 * @author Lee
 *
 */
public class GridManager
{
	public Tile[][] ground;						//Ground-level grid. No objects may be built here. Includes any grass or water. Levels build over this. Render first.
	public Tile[][] lower;						//Lower-level building grid. Level of roads and bridges. Overpasses may go over these.
	public Tile[][] upper;						//Upper-level building grid. Tall buildings, trees, and overpasses enter this level.
	public Tile[][] UI;							//UI-level grid. No objects may be built here. Solely used for highlighting mouse-over tiles and creating a black outline around each tile. Render last.
	
	public ArrayList<GridObject> objects;	//Objects of the map. Call them through their indices. TileGrids will store the correct index over every tile the GridObject covers.
	
	public GridManager(GameWorld world)
	{
		int width = world.world_total_horizontal;
		int height = world.world_total_vertical;
		
		ground = new Tile[height][width];
		lower = new Tile[height][width];
		upper = new Tile[height][width];
		UI = new Tile[height][width];
		
		objects = new ArrayList<GridObject>();
	}
	
	public void update(float delta)
	{
		for(int y = 0; y < ground.length; y++)
		{
			for(int x = 0; x < ground[0].length; x++)
			{
				ground[y][x].update(delta);
				lower[y][x].update(delta);
				upper[y][x].update(delta);
				UI[y][x].update(delta);
			}
		}
		
		for(GridObject o : objects)
			o.update(delta);
	}
	
	public void draw()
	{
		for(int y = 0; y < ground.length; y++)
		{
			for(int x = 0; x < ground[0].length; x++)
			{
				ground[y][x].draw();
				lower[y][x].draw();
				upper[y][x].draw();
				UI[y][x].draw();
			}
		}
		
		for(GridObject o : objects)
			o.draw();
	}
}

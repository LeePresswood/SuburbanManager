package com.leepresswood.suburbanmanager.screens.game.objects.grid;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.Texture;
import com.leepresswood.suburbanmanager.screens.game.GameWorld;

/**
 * Manages the multiple grids of the world. Manages grid objects as well.
 * @author Lee
 *
 */
public class GridManager
{
	public GameWorld world;
	
	public Tile[][] ground;						//Ground-level grid. No objects may be built here. Includes any grass or water. Levels build over this. Render first.
	public Tile[][] UI;							//UI-level grid. No objects may be built here. Solely used for highlighting mouse-over tiles and creating a black outline around each tile. Render last.
	
	public ArrayList<GridObject> objects;	//Objects of the map. Call them through their indices. TileGrids will store the correct index over every tile the GridObject covers.
	
	public GridManager(GameWorld world)
	{
		this.world = world;
		
		int width = world.world_total_horizontal;
		int height = world.world_total_vertical;
		
		ground = new Tile[height][];
		UI = new Tile[height][];
		
		//Initialize the ground with the beginning tiles.
		for(int y = 0; y < height; y++)
		{
			ground[y] = new Tile[width];
			UI[y] = new Tile[width];
			
			for(int x = 0; x < width; x++)
			{
				//Find the correct position for this tile. Count from the bottom-left as (0,0).
				ground[y][x] = new Tile(this, x, y);
				UI[y][x] = new Tile(this, x, y);
				
				//Set the ground tiles to their initial values.
				ground[y][x].setTileTexture(world.screen.game.assets.get(world.screen.game.assets.TERRAIN_GRASS, Texture.class));
			}
		}	
		
		objects = new ArrayList<GridObject>();
	}
	
	public void update(float delta)
	{
		for(int y = 0; y < ground.length; y++)
		{
			for(int x = 0; x < ground[0].length; x++)
			{
				ground[y][x].update(delta);
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
				UI[y][x].draw();
			}
		}
		
		for(GridObject o : objects)
			o.draw();
	}
}

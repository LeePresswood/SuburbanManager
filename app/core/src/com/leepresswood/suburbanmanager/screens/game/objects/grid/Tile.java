package com.leepresswood.suburbanmanager.screens.game.objects.grid;

/**
 * The individual parts of the game map. Objects sit on AxB tiles, where A is the vertical height and B is the horizontal height.
 * The sizes are integer values in reference to the bottom-left tile of the game object. Put another way, the game's objects have an integer position
 * of the bottom-left square. The object will automatically take up the remaining tiles in response to the width and height.
 * @author Lee
 *
 */
public class Tile
{
	private GridManager manager;
	
	//Position of the tile.
	public int x, y;
	
	//Object information. 
	//Number is the position in the GameObject array in GridManager.
	//X and Y are the 0-based tiles within the GameObject. So for example, the
	//bottom-middle tile of a 2x3 GameObject will have the following data:
	//object_x = 1
	//object_y = 0
	//Counting starts at bottom-left tile.
	public int object_number, object_x, object_y;
	
	public Tile(GridManager manager, int x, int y)
	{
		this.manager = manager;
		this.x = x;
		this.y = y;
		
		clearObject();
	}
	
	public boolean isFree()
	{
		return object_number == -1;
	}
	
	public void setObject(int num, int x, int y)
	{
		object_number = num;
		object_x = x;
		object_y = y;
	}
	
	/**
	 * Remove tile data and make free.
	 */
	public void clearObject()
	{
		object_number = -1;
		object_x = -1;
		object_y = -1;
	}
	
	public void update(float delta)
	{
		if(!isFree())
		{
			
		}
	}
	
	public void draw()
	{
		if(!isFree())
		{
			
		}
	}
}

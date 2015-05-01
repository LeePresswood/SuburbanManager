package com.leepresswood.suburbanmanager.screens.game.objects.grid;

/**
 * An object placed on top of tiles in a grid.
 * @author Lee
 *
 */
public class GridObject
{
	public GridManager manager;
	public int x, y, width, height;
	public boolean active;
	
	public GridObject(GridManager manager)
	{
		this.manager = manager;
		
		active = true;
	}

	public void update(float delta)
	{
	}

	public void draw()
	{
	}	
}

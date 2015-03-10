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
	
	public GridObject(GridManager manager)
	{
		this.manager = manager;
	}

	public void update(float delta)
	{
	}

	public void draw()
	{
	}	
}

package com.leepresswood.suburbanmanager.screens.game.objects.grid;

import com.leepresswood.suburbanmanager.screens.game.objects.road.Road;

/**
 * Player seeks to add a new object to the grid. Given the selected object, produce a new instance of this object at (x, y).
 * @author Lee
 *
 */
public class GridObjectFactory
{
	public static GridObject get(GridObjectEnum type, int x, int y, GridManager manager)
	{		
		switch(type)
		{
			case ROAD:
				return new Road(manager, x, y);
			default:
				return null;
		}
	}
}

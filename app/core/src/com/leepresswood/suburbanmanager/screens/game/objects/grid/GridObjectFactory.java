package com.leepresswood.suburbanmanager.screens.game.objects.grid;

import com.leepresswood.suburbanmanager.screens.game.objects.road.Road;

public class GridObjectFactory
{
	public static GridObject get(GridObjectEnum type, int x, int y, GridManager manager)
	{
		GridObject o = null;
		
		switch(type)
		{
			case ROAD:
				o = new Road(manager, x, y);
				break;			
		}
		
		return o;
	}
}

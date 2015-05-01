package com.leepresswood.suburbanmanager.screens.game.objects.road;

import com.leepresswood.suburbanmanager.screens.game.objects.grid.GridManager;
import com.leepresswood.suburbanmanager.screens.game.objects.grid.GridObject;

public class Road extends GridObject
{
	public Road(GridManager manager, int x, int y)
	{
		super(manager, x, y);
	}

	@Override
	protected void makeSprite()
	{		
		width = 1;
		height = 1;
		
		sprite.setBounds(x, y, width, height);
	}
}

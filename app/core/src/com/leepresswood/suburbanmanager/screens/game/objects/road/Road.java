package com.leepresswood.suburbanmanager.screens.game.objects.road;

import com.leepresswood.suburbanmanager.screens.game.objects.grid.GridManager;
import com.leepresswood.suburbanmanager.screens.game.objects.grid.GridObject;
import com.leepresswood.suburbanmanager.screens.game.objects.grid.GridObjectEnum;

public class Road extends GridObject
{
	public Road(GridManager manager, int x, int y)
	{
		super(manager, x, y);
		
		type = GridObjectEnum.ROAD;
	}

	@Override
	protected void makeSprite()
	{		
		width = 1;
		height = 1;
		
		sprite.setBounds(x, y, width, height);
	}

	@Override
	public void update(float delta)
	{
		
	}
	
	public void updateTexture()
	{
		//Road will change depending upon the presence of surrounding road tiles.
		sprite.setRegion(RoadAdjust.adjust(manager, index));
	}
}

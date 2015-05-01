package com.leepresswood.suburbanmanager.screens.game.objects.road;

import com.badlogic.gdx.graphics.Texture;
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
		sprite.setRegion(manager.world.screen.game.assets.get(manager.world.screen.game.assets.ROAD_CROSS, Texture.class));
		
		width = 1;
		height = 1;
		
		sprite.setBounds(x, y, width, height);
	}

	@Override
	public void update(float delta)
	{
		//Road will change depending upon the presence of surrounding road tiles.
		sprite.setRegion(RoadAdjust.adjust(manager, index));
	}
}

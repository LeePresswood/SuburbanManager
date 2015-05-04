package com.leepresswood.suburbanmanager.screens.game.objects.grid.tiles;

import com.badlogic.gdx.graphics.Texture;
import com.leepresswood.suburbanmanager.screens.game.objects.grid.GridManager;
import com.leepresswood.suburbanmanager.screens.game.objects.grid.GridObject;
import com.leepresswood.suburbanmanager.screens.game.objects.grid.GridObjectEnum;

public class GrassTile extends GridObject
{	
	public GrassTile(GridManager manager, int x, int y)
	{
		super(manager, x, y);
		
		type = GridObjectEnum.GRASS;
		
		//Terrain tiles are not active. This allows us to place on them.
		active = false;
	}

	@Override
	protected void makeSprite()
	{
		width = 1;
		height = 1;
		
		sprite.setRegion(manager.world.screen.game.assets.get(manager.world.screen.game.assets.TERRAIN_GRASS, Texture.class));
		sprite.setBounds(x, y, width, height);
	}
	
	@Override
	public void update(float delta)
	{
	}	
}

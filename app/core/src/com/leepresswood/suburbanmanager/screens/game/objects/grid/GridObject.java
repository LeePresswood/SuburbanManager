package com.leepresswood.suburbanmanager.screens.game.objects.grid;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * An object placed on top of tiles in a grid.
 * @author Lee
 *
 */
public abstract class GridObject
{
	public GridManager manager;
	public int x, y, width, height;
	public boolean active;
	public Sprite sprite;
	
	public int index;
	
	public GridObject(GridManager manager, int x, int y)
	{
		this.manager = manager;
		
		this.x = x;
		this.y = y;
		
		//Set the sprite.
		sprite = new Sprite();
		makeSprite();	
		
		//Block these locations from future storage.
		index = manager.toGridID(x, y);
		for(int j = this.y; j < this.y + height; j++)
			for(int i = this.x; i < this.x + width; i++)
				manager.game_objects.put(manager.toGridID(i, j), this);
		
		active = true;
	}
	
	public void clear()
	{
		for(int j = this.y; j < this.y + height; j++)
			for(int i = this.x; i < this.x + width; i++)
				manager.game_objects.put(manager.toGridID(i, j), null);
	}
	
	protected abstract void makeSprite();

	public void update(float delta)
	{
	}

	public void draw()
	{
	}	
}

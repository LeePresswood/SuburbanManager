package com.leepresswood.suburbanmanager.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.leepresswood.suburbanmanager.GameSM;

/**
 * Handles draw and update order and screen clearing. Extend from this rather than from ScreenAdapter.
 * 
 * @author Lee
 *
 */
public abstract class ScreenParent extends ScreenAdapter
{
	public GameSM game;	
	public SpriteBatch batch;
	public ShapeRenderer renderer;
	
	protected Color color_background;
	
	public ScreenParent(GameSM game)
	{
		this.game = game;
		this.batch = new SpriteBatch();
		this.renderer = new ShapeRenderer();
		
		setUpBackgroundColor();
		setUpInput();
	}
	
	/**
	 * This will be called automatically by the screen. Rather than doing all the drawing here,
	 * just set up the update/draw stack that the extended screens will implement.
	 */
	@Override
	public void render(float delta)
	{
		//Update
		update(delta);
		
		//Draw
		Gdx.gl.glClearColor(color_background.r, color_background.g, color_background.b, color_background.a);
      Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		draw();
	}
	
	public abstract void setUpBackgroundColor();
	public abstract void setUpInput();
	public abstract void update(float delta);
	public abstract void draw();
}

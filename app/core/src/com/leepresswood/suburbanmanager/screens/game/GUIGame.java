package com.leepresswood.suburbanmanager.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GUIGame
{
	private ScreenGame screen;
	public OrthographicCamera camera;
	
	public GUIGame(ScreenGame screen)
	{
		this.screen = screen;
				
		makeCamera();
	}
	
	/**
	 * Set up camera. It will never move, so no need to update it again after initialization.
	 */
	private void makeCamera()
	{
		camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
		camera.update();
	}

	/**
	 * Update required things.
	 * @param delta Change in time.
	 */
	public void update(float delta)
	{
	}
	
	/**
	 * Draw all parts of the GUI.
	 */
	public void draw()
	{
		
	}
}

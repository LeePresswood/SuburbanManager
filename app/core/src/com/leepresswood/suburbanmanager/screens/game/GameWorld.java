package com.leepresswood.suburbanmanager.screens.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.leepresswood.suburbanmanager.screens.game.objects.grid.GridManager;

/**
 * Holds information about the game world. Sets up camera based upon this world.
 * @author Lee
 *
 */
public class GameWorld
{
	public ScreenGame screen;
	public OrthographicCamera camera;
	
	//Bounds of the camera. These are in relation to the camera's center. Said another way, these are the extreme positions of the camera's movement. You may not move farther left than WORLD_LEFT.
	public int world_total_horizontal, world_total_vertical;
	private int GRID_SIZE = 50;
	private float world_view = GRID_SIZE / 2f;
	private float world_left, world_right, world_top, world_bottom;	
	
	//Camera zoom variables.
	public boolean camera_zoom_has_changed;									//Determines if zoom has changed.
	private float camera_zoom = 0.1f;											//Amount added to the world camera's zoom.
	private float camera_zoom_jump = 0.25f;									//Amount zoom changes by with each zoom request.
	private float camera_zoom_max = 1.0f;										//Max amount the player can zoom out.
	private float camera_zoom_min = camera_zoom_jump;						//Min amount the player can zoom out. In other words, max zoom in.
	
	//Game Objects
	public GridManager manager;
	
	public GameWorld(ScreenGame screen)
	{
		this.screen = screen;
		
		setUpWorld();
		populateWorld();
	}
	
	/**
	 * Set up the world bounds.
	 */
	private void setUpWorld()
	{		
		//Set the bounds of the whole world.
		world_total_horizontal = GRID_SIZE;
		world_total_vertical = GRID_SIZE;
		//Set the camera.
		camera = new OrthographicCamera(Gdx.graphics.getWidth() / world_view, Gdx.graphics.getHeight() / world_view);
		
		//Calculate the position of the camera.
		camera.position.x = world_total_horizontal / 2f;
		camera.position.y = world_total_vertical / 2f;
		camera_zoom_has_changed = true;
		setCameraBounds();
		camera.update();
		
		//Display information.
		System.out.println("Camera:\n\tPosition: " + camera.position + "\n\tWidth: " + camera.viewportWidth + "\n\tHeight: " + camera.viewportHeight + "\n\tZoom: " + camera.zoom);
	}
	
	/**
	 * Add the initial entities to the game world.
	 */
	private void populateWorld()
	{
		//Load tile manager.
		manager = new GridManager(this);
		
		//Populate whole world with grass tiles.
		manager.init();
		
		//Set up highway.
		
	}
	
	public void update(float delta)
	{
		manager.update(delta);
		
		//Manage the other forces in the world.
		setCameraBounds();
		deleteOldObjects();
	}
	
	/**
	 * Check the camera's position for correctness. It should not go off the world's bounds.
	 */
	private void setCameraBounds()
	{
		//Any zooming will have an effect on the bounds. Recalculate them if necessary.
		/*if(camera_zoom_has_changed)
		{
			//Change the camera's zoom to the new value.
			camera.zoom = camera_zoom;
			camera_zoom_has_changed = false;
			camera.update();
			
			//Update bounds.
			world_bottom = camera.zoom * camera.viewportHeight / 2f;
			world_top = world_total_vertical - world_bottom;
			world_left = camera.zoom * camera.viewportWidth / 2f;
			world_right = world_total_horizontal - world_left;
		}
		
		//If this moves off the world's bounds, correct it.
		//X
		if(camera.position.x < world_left)
			camera.position.x = world_left;
		else if(camera.position.x > world_right)
			camera.position.x = world_right;
		
		//Y
		if(camera.position.y < world_bottom)
			camera.position.y = world_bottom;
		else if(camera.position.y > world_top)
			camera.position.y = world_top;
		
		camera.update();*/
	}
	
	/**
	 * Zoom by the zoom amount.
	 * @param zoom_in True if going in. False if going out.
	 */
	public void cameraZoom(boolean zoom_in)
	{
		if(zoom_in)
		{
			camera_zoom -= camera_zoom_jump;
			if(camera_zoom < camera_zoom_min)
				camera_zoom = camera_zoom_min;
		}
		else
		{
			camera_zoom += camera_zoom_jump;
			if(camera_zoom > camera_zoom_max)
				camera_zoom = camera_zoom_max;
		}
		
		camera.zoom = camera_zoom;
		camera.update();
		camera_zoom_has_changed = true;
	}
	
	/**
	 * Delete old objects.
	 */
	private void deleteOldObjects()
	{		
		
	}
	
	public void draw()
	{
		//Game objects
		screen.batch.setProjectionMatrix(camera.combined);
		screen.batch.begin();
			manager.draw();
		screen.batch.end();
	}
	
	public boolean isWithin(int x, int y)
	{
		return x < world_total_horizontal && x >= 0 && y < world_total_vertical && y >= 0;
	}
}

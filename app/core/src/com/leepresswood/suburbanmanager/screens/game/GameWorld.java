package com.leepresswood.suburbanmanager.screens.game;

import java.util.ArrayList;
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
	
	//Bounds of the camera. These are in relation to the camera's center. Said another way, these are the extreme positions of the camera's movement. You may not move further left than WORLD_LEFT.
	public int world_total_horizontal, world_total_vertical;
	private float world_view = 15f;
	private float world_left, world_right, world_top, world_bottom;	
	
	//Camera zoom variables.
	private boolean camera_zoom_has_changed;							//Determines if zoom has changed.
	private float camera_zoom = 0.5f;									//Amount added to the world camera's zoom.
	private float camera_zoom_jump = 0.25f;							//Amount zoom changes by with each zoom request.
	private float camera_zoom_max = 20.0f;								//Max amount the player can zoom out.
	private float camera_zoom_min = camera_zoom_jump;				//Min amount the player can zoom out. In other words, max zoom in.
	
	//Game Objects
	public GridManager manager;
	public ArrayList<Object> remove;
	
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
		world_total_horizontal = 50;
		world_total_vertical = 50;
		
		//Set the bounds of the camera.
		camera = new OrthographicCamera(Gdx.graphics.getWidth() / world_view, Gdx.graphics.getHeight() / world_view);
		
		
		
		//Calculate the position of the camera.
		camera.position.x = world_total_horizontal / 2f;
		camera.position.y = world_total_vertical / 2f;
		camera_zoom_has_changed = true;
		setCameraBounds();
		
		//Display information.
		System.out.println("Camera:\n\tPosition: " + camera.position + "\n\tWidth: " + camera.viewportWidth + "\n\tHeight: " + camera.viewportHeight + "\n\tZoom: " + camera.zoom);
	}
	
	/**
	 * Add the initial entities to the game world.
	 */
	private void populateWorld()
	{
		//Load tiles.
		manager = new GridManager(this);
		
		//Set up highway.
		
		
		remove = new ArrayList<Object>();
	}
	
	public void update(float delta)
	{
		
		
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
		if(camera_zoom_has_changed)
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
		if(camera.position.x > world_left)
			camera.position.x = world_left;
		if(camera.position.x < world_right)
			camera.position.x = world_right;
		
		//Y
		if(camera.position.y > world_bottom)
			camera.position.y = world_bottom;
		if(camera.position.y < world_top)
			camera.position.y = world_top;
		
		camera.update();
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
		
		camera_zoom_has_changed = true;
	}
	
	/**
	 * Delete old objects.
	 */
	private void deleteOldObjects()
	{
		/*remove = null;
		
		//Find old items..
		for(Spell s : spells)
			if(!s.active)
			{
				if(remove == null)
					remove = new ArrayList<Object>();				
				remove.add(s);
			}
		
		
		//Do the actual removal.
		if(remove != null)
			for(Object o : remove)
				;
				//if(o instanceof Spell)
				//	spells.remove(o);*/
	}
	
	public void draw()
	{System.out.println(camera.position);
		//Game objects
		screen.batch.setProjectionMatrix(camera.combined);
		screen.batch.begin();
			manager.draw();
		screen.batch.end();
	}
}

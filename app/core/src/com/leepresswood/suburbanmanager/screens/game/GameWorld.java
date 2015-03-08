package com.leepresswood.suburbanmanager.screens.game;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

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
	public int WORLD_TOTAL_HORIZONTAL, WORLD_TOTAL_VERTICAL;
	public float WORLD_VIEW = 15f;
	public float WORLD_LEFT, WORLD_RIGHT, WORLD_TOP, WORLD_BOTTOM;	
	
	private boolean CAMERA_ZOOM_CHANGED;								//Determines if zoom has changed.
	private float CAMERA_ZOOM = 0.0f;									//Amount added to the world camera's zoom.
	private float CAMERA_ZOOM_JUMP = 0.5f;								//Amount zoom changes by with each zoom request.
	private float CAMERA_ZOOM_MAX = 2.0f;								//Max amount the player can zoom in.
	private float CAMERA_ZOOM_MIN = -CAMERA_ZOOM_MAX;				//Min amount the player can zoom in. In other words, max zoom out.
	
	//Game Objects
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
		//Set the bounds of the camera.
		camera = new OrthographicCamera(Gdx.graphics.getWidth() / WORLD_VIEW, Gdx.graphics.getHeight() / WORLD_VIEW);
		
		//Set the bounds of the whole world.
		WORLD_TOTAL_HORIZONTAL = 20;
		WORLD_TOTAL_VERTICAL = 20;
		
		//Calculate the position of the camera.
		CAMERA_ZOOM_CHANGED = true;
		setCameraBounds();
		
		//Display information.
		System.out.println("Camera:\n\tPosition: " + camera.position + "\n\tWidth: " + camera.viewportWidth + "\n\tHeight: " + camera.viewportHeight + "\n\tZoom: " + camera.zoom);
	}
	
	/**
	 * Add the initial entities to the game world.
	 */
	private void populateWorld()
	{
		//Set up highway.
		
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
		if(CAMERA_ZOOM_CHANGED)
		{
			//Change the camera's zoom to the new value.
			camera.zoom = CAMERA_ZOOM;
			CAMERA_ZOOM_CHANGED = false;
			camera.update();
			
			//Update bounds.
			WORLD_BOTTOM = camera.zoom * camera.viewportHeight / 2f;
			WORLD_TOP = WORLD_TOTAL_VERTICAL - WORLD_BOTTOM;
			WORLD_LEFT = camera.zoom * camera.viewportWidth / 2f;
			WORLD_RIGHT = WORLD_TOTAL_HORIZONTAL - WORLD_LEFT;
		}
		
		//If this moves off the world's bounds, correct it.
		//X
		if(camera.position.x < WORLD_LEFT)
			camera.position.x = WORLD_LEFT;
		else if(camera.position.x > WORLD_RIGHT)
			camera.position.x = WORLD_RIGHT;
		
		//Y
		if(camera.position.y < WORLD_BOTTOM)
			camera.position.y = WORLD_BOTTOM;
		else if(camera.position.y > WORLD_TOP)
			camera.position.y = WORLD_TOP;
		
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
			CAMERA_ZOOM -= CAMERA_ZOOM_JUMP;
			if(CAMERA_ZOOM < CAMERA_ZOOM_MIN)
				CAMERA_ZOOM = CAMERA_ZOOM_MIN;
		}
		else
		{
			CAMERA_ZOOM += CAMERA_ZOOM_JUMP;
			if(CAMERA_ZOOM > CAMERA_ZOOM_MAX)
				CAMERA_ZOOM = CAMERA_ZOOM_MAX;
		}
		
		CAMERA_ZOOM_CHANGED = true;
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
	{		
		//Game objects
		screen.batch.setProjectionMatrix(camera.combined);
		screen.batch.begin();
			
		screen.batch.end();
	}
}

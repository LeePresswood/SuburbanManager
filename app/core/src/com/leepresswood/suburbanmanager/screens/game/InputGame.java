package com.leepresswood.suburbanmanager.screens.game;

import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class InputGame implements InputProcessor
{
	private ScreenGame screen;
	
	private Vector2 lastTouch = new Vector2(-1, -1);
	
	public InputGame(ScreenGame screenGame)
	{
		this.screen = screenGame;
	}

	@Override
	public boolean keyDown(int keycode)
	{
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		return false;
	}
	
	@Override
	public boolean keyTyped(char character)
	{
		return false;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		if(button == Buttons.LEFT)
		{
			//Must determine if it's on the GUI or the game world.
			//GUI
			
			
			//Game world
			//Translate the clicked location to a world x and y. Send click to GridManager.
			Vector3 touch = screen.world.camera.unproject(new Vector3(screenX, screenY, 0));
			screen.world.manager.clickAt((int) Math.floor(touch.x), (int) Math.floor(touch.y));
		}	
		else if(button == Buttons.MIDDLE)
		{
			lastTouch.set(screenX, screenY);
		}
		else if(button == Buttons.RIGHT)
		{
			//Delete tile.
			//Translate the clicked location to a world x and y. Send click to GridManager.
			Vector3 touch = screen.world.camera.unproject(new Vector3(screenX, screenY, 0));
			screen.world.manager.deleteAt((int) Math.floor(touch.x), (int) Math.floor(touch.y));
		}
		
		return true;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		if(button == Buttons.MIDDLE)
			lastTouch.set(-1, -1);
		
		return true;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		if(lastTouch.x != -1)
		{
			Vector2 diff = new Vector2(screenX, screenY).sub(lastTouch).scl(0.05f);
			screen.world.camera.position.add(diff.x, -diff.y, 0);
			
			lastTouch.set(screenX, screenY);
		}
		
		return true;
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		
		
		return true;
	}
	
	@Override
	public boolean scrolled(int amount)
	{
		//screen.world.cameraZoom(amount == -1);
		return true;
	}
	
}

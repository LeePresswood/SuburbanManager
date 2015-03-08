package com.leepresswood.suburbanmanager;

import com.badlogic.gdx.Game;
import com.leepresswood.suburbanmanager.data.Assets;
import com.leepresswood.suburbanmanager.screens.splash.ScreenSplash;

public class GameSM extends Game 
{
	public Assets assets;

	@Override
	public void create()
	{
		//Assets loaded here. Also loads the main menu.
		this.setScreen(new ScreenSplash(this));		
	}
}

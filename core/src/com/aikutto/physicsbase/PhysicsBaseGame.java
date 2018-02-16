package com.aikutto.physicsbase;

import com.badlogic.gdx.Game;

public class PhysicsBaseGame extends Game {

	@Override
	public void create() {
		GameScreen gameScreen = new GameScreen();
		setScreen(gameScreen);
	}
}

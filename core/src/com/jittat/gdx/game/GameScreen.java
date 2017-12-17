package com.jittat.gdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class GameScreen extends ScreenAdapter{
	World world;
	WorldRenderer worldrenderer;
	private PwlGame pwlGame;
	public GameScreen(PwlGame pwlGame) {
		this.pwlGame = pwlGame;
		world = new World(pwlGame);
		worldrenderer = new WorldRenderer(pwlGame,world);
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    worldrenderer.render(delta);
	}
}

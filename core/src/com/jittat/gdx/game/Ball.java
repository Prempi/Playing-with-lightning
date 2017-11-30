package com.jittat.gdx.game;

import com.badlogic.gdx.math.Vector2;

public class Ball {
	 private Vector2 position;
	 
	 public Ball(int x,int y) {
		 position = new Vector2(x,y);
	 }
	 
	 public Vector2 getPosition() {
	        return position;    
	 }
	 
}

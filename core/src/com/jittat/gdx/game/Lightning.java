package com.jittat.gdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class Lightning {
		 private Vector2 position;
		 public boolean isPress;
		 private int[] posx = new int[] {0,80,160,240,320,400,480,560,640,720};
		 
		 public Lightning(int x,int y) {
			 position = new Vector2(x,y);
			 isPress = false;
		 }
		 
		 public Vector2 getPosition() {
		        return position;    
		 }
		 public void move() {
			 if(!isPress) {
				 if(Gdx.input.isKeyPressed(Keys.A)) {
			            position.x = posx[0];
			            isPress = true;
			        }
				 else if(Gdx.input.isKeyPressed(Keys.S)) {
			            position.x = posx[1];
			            isPress = true;
			        }
				 else if(Gdx.input.isKeyPressed(Keys.D)) {
			            position.x = posx[2];
			            isPress = true;
			        }
				 else if(Gdx.input.isKeyPressed(Keys.F)) {
			            position.x = posx[3];
			            isPress = true;
			        }
				 else if(Gdx.input.isKeyPressed(Keys.G)) {
			            position.x = posx[4];
			            isPress = true;
			        }
				 else if(Gdx.input.isKeyPressed(Keys.H)) {
			            position.x = posx[5];
			            isPress = true;
			        }
				 else if(Gdx.input.isKeyPressed(Keys.J)) {
			            position.x = posx[6];
			            isPress = true;
			        }
				 else if(Gdx.input.isKeyPressed(Keys.K)) {
			            position.x = posx[7];
			            isPress = true;
			        }
				 else if(Gdx.input.isKeyPressed(Keys.L)) {
			            position.x = posx[8];
			            isPress = true;
			        }
				 else if(Gdx.input.isKeyPressed(Keys.SEMICOLON)) {
			            position.x = posx[9];
			            isPress = true;
			        }
				 }
			 else {
				 position.y -= 10;
			 }
			 if(position.y <=40) {
				 position.y = 610;
				 isPress = false;
			 }
		 }
}

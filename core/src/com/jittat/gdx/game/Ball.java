package com.jittat.gdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Ball {
	 private Vector2 position;
	 public boolean isLaunch;
	 public boolean isTouch;
	 private int[] type = new int[] {1,2,3,4,5};
	 private int currentType;
	 public boolean isBottom;
	 private int[] posx = new int[] {0,80,160,240,320,400,480,560,640,720};
	 World world;
	 public int touch;
	 
	 public Ball(int x,int y,World world) {
		 position = new Vector2(x,y);
		 isLaunch = false;
		 isTouch = false;
		 isBottom = false;
		 currentType = type[0];
		 touch = 0;
		 this.world = world;
	 }
	 
	 public Vector2 getPosition() {
	        return position;    
	 }
	 
	 public int getType(){
		 return currentType;
	 }
	 public void move() {
		 if(!isLaunch) {
			 if(position.y==40) {
				 Random rn2 = new Random();
				 int j = Math.abs((rn2.nextInt() % 100)%4);
				 currentType = type[j];
			 }
			 position.y+=1;
			 if(position.y>=140) {
				 isLaunch = true;
			 }
		 }
		 else {
			 position.y-=1;
			 if(position.y<=39) {
				 isLaunch = false;
				 Random rn = new Random();
				 int i = Math.abs((rn.nextInt() % 10));
				 position.x = posx[i];
			}
		 }
		 if(isTouch==true) {
			 touch+=1;
			 Random rn = new Random();
			 int i = Math.abs((rn.nextInt() % 10));
			 Random rn2 = new Random();
			 if(touch%10==0) {
				 currentType = type[4];
			 }
			 else {
				 int j = Math.abs((rn2.nextInt() % 100)%4);
				 currentType = type[j];
			 }
			 isLaunch = false;
			 position.y = 41;
			 position.x = posx[i];
			 isTouch = false;
		 }
	 }
	 
}

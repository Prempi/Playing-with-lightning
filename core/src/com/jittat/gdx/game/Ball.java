package com.jittat.gdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Ball {
	 private Vector2 position;
	 private boolean isLaunch;
	 public boolean isTouch;
	 private int[] type = new int[] {1,2,3,4};
	 private int currentType;
	 public boolean isBottom;
	 private int[] posx = new int[] {0,80,160,240,320,400,480,560,640,720};
	 World world;
	 private int touch;
	 
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
				 /*int j = Math.abs((rn2.nextInt() % 4));
				 //currentType = type[j];
				 System.out.println("t: "+touch);
				 if(touch%15==0&&touch!=0) {
					 currentType = type[3];
					 System.out.println("ct: "+currentType);
				 }*/
				 int j = Math.abs((rn2.nextInt() % 20)%3);
				 currentType = type[j];
				 //System.out.println("ct: "+currentType);
				 
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
			 //System.out.println("t: "+touch);
			 if(touch%5==0) {
				 currentType = type[3];
				 //System.out.println("ct: "+currentType);
			 }
			 else {
				 int j = Math.abs((rn2.nextInt() % 3));
				 currentType = type[j];
				 //System.out.println("ct: "+currentType);
			 }
			 isLaunch = false;
			 position.y = 41;
			 position.x = posx[i];
			 isTouch = false;
		 }
	 }
	 
}

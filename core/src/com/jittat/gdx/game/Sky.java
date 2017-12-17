package com.jittat.gdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Sky {
	private int time;
	public static final int DAYTIME = 1000;
	public static final int NIGHTTIME = DAYTIME*2;
	public static final int RESETTIME = DAYTIME*3;
	private Texture skyNight;
	private Texture skyDay;
	private Texture sky;
	public Sky() {
		 time = 0;
		 skyNight = new Texture("bg_night.jpg");
		 skyDay = new Texture("bg_day.jpg");
		 sky = skyNight;
	 }
	
	public int getTime() {
		return time;
	}
	
	public Texture getBg() {
		return sky;
	}
	
	public void update() {
		//System.out.println(time);
		time+=1;
		//System.out.println(time);
		if(time>=DAYTIME&&time<NIGHTTIME) {
			sky = skyDay;
		}
		else if(time>=NIGHTTIME) {
			sky = skyNight;
		}
		if(time==RESETTIME) {
			time = 0;
		}
		
	}
	
}

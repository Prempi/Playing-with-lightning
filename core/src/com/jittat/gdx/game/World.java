package com.jittat.gdx.game;

import java.util.Random;

public class World {
	private Ball ball;
	private Ball ball2;
	private Lightning lightning;
	public String status;
	//private Lightning lightning2;
	public int score;
	private int life;
	private int right;
	private int[] posx = new int[] {0,80,160,240,320,400,480,560,640,720};
	private PwlGame pwlgame;
	private Sky sky;
	
	World(PwlGame pwlgame) {
        this.pwlgame = pwlgame;
		Random rn2 = new Random();
		int j = Math.abs((rn2.nextInt() % 10));
        ball = new Ball(0,40,this);
        ball2 = new Ball(posx[j],0,this);
        lightning = new Lightning(0,610);
        //lightning2 = new Lightning(0,610);
        score = 0;
        life = 1;
        sky = new Sky();
        status = "running";
    }
 
    Ball getBall() {
        return ball;
    }
    
    Ball getBall2() {
        return ball2;
    }
    
    Lightning getLightning() {
    	return lightning;
    }
    
    Sky getSky() {
    	return sky;
    }
    
    public int getScore() {
    	return score;
    }
    
    public void increaseScore() {
    	score+=1;
    }
    
    public void increaseScore2() {
    	score+=5;
    }
    
    public int getLife() {
    	return life;
    }
    
    public void decreaseLife() {
    	life-=1;
    }
    
    public void decreaseLife2() {
    	life-=100;
    }
    
    public void increaseLife() {
    	if(life<2) {
    		life+=1;
    	}
    }
    
    public int getRight() {
    	return right;
    }
    
    public void increaseRight() {
    	if(right==0) {
    		right+=1;
    	}
    }
    
    public void decreaseRight() {
    	if(right==1) {
    		right-=1;
    	}
    }
    
    public void reset() {
        score = 0;
        life = 1;
        right = 0;
        status = "running";
    }
}

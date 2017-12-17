package com.jittat.gdx.game;

public class World {
	private Ball ball;
	private Ball ball2;
	private Lightning lightning;
	//private Lightning lightning2;
	public int score;
	private int life;
	private PwlGame pwlgame;
	
	World(PwlGame pwlgame) {
        this.pwlgame = pwlgame;
        ball = new Ball(0,40,this);
        ball2 = new Ball(0,80,this);
        lightning = new Lightning(0,610);
        //lightning2 = new Lightning(0,610);
        score = 0;
        life = 1;
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
    	if(life<3) {
    		life+=1;
    	}
    }
}

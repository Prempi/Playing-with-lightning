package com.jittat.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private PwlGame pwlgame;
	private Texture ballImg;
	private Texture mchImg;
	private Texture blockImg;
	private Texture gameOver;
	Ball ball;
	Ball ball2;
	Lightning lightning;
	private String[] a = new String [] {"#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#"};
	World world;
	SpriteBatch batch;
	private BitmapFont font;
	
	public WorldRenderer(PwlGame pwlgame, World world) {
        this.pwlgame = pwlgame;
        batch = pwlgame.batch;
        this.world = world;
        mchImg = new Texture("pacman.png");
        ballImg = new Texture("dot.png");
        blockImg = new Texture("wall.png");
        gameOver = new Texture("badlogic.jpg");
        ball = world.getBall();
        ball2 = world.getBall2();
        lightning = world.getLightning();
        font = new BitmapFont();
    }
	
	public void render(float delta) {
		batch.begin();
	    update();
	    Vector2 pos = ball.getPosition();
	    Vector2 pos3 = ball2.getPosition();
	    Vector2 pos2 = lightning.getPosition();
	    if(Math.abs(pos.y-pos2.y)<=5&&Math.abs(pos.x-pos2.x)<=5) {
	    	if(ball.getType()==1) {
	    		world.increaseScore();
	    	}
	    	else if(ball.getType()==2){
	    		world.increaseScore2();
	    	}
	    	else if(ball.getType()==4) {
	    		world.increaseLife();
	    	}
	    	else {
	    		world.decreaseLife2();
	    	}
	    	lightning.isPress = false;
	    	ball.isTouch = true;
	    	pos2.y = 610;
	    }
	    if(Math.abs(pos2.y-pos3.y)<=5&&Math.abs(pos2.x-pos3.x)<=5) {
	    	world.decreaseLife();
	    }
	    if(pos.y<=39) {
	    	if(ball.getType()==1||ball.getType()==2) {
	    	world.decreaseLife();
	    	}
	    }
	    if(world.getLife()>=0) {
	    	batch.draw(mchImg, 380, 300);
	    	switch(ball.getType()) {
	    	case 1:
	    		batch.draw(ballImg,pos.x,pos.y);
	    		break;
	    	case 2:
	    		batch.draw(mchImg,pos.x,pos.y);
	    		break;
	    	case 3:
	    		batch.draw(gameOver,pos.x,pos.y);
	    		break;
	    	case 4:
	    		batch.draw(blockImg,pos.x,pos.y);
	    		break;
	    	}
    		batch.draw(ballImg,pos3.x,pos3.y);
	    	batch.draw(ballImg,pos2.x,pos2.y);
	    	font.draw(batch, "Score: " + world.getScore(), 650, 580);
	    	font.draw(batch, "Life: " + world.getLife(), 650, 560);
	    	for(int i = 0;i<a.length;i++) {
	    		if(a[i]=="#") {
	    			batch.draw(blockImg,i*40,0);
	    		}
	    	}
	    }
	    else {
	    	font.getData().setScale(5, 5);
	    	font.draw(batch, "Game Over",200, 310);
	    }
	    batch.end();
	}
	
	public void update() {
		ball.move();
		ball2.move();
		lightning.move();
		
	}
	
}

package com.jittat.gdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private PwlGame pwlgame;
	private Texture ordiballImg;
	private Texture bonusballImg;
	private Texture heartballImg;
	private Texture ggballImg;
	private Texture eyeballImg;
	private Texture mchoneImg;
	private Texture mchtwoImg;
	private Texture boltImg;
	private Texture blockImg;
	private Texture bgImg;
	private Texture gameOver;
	private int[] posx = new int[] {0,80,160,240,320,400,480,560,640,720};
	private int time;
	Ball ball;
	Ball ball2;
	Sky sky;
	Lightning lightning;
	private String[] a = new String [] {"#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#"};
	World world;
	SpriteBatch batch;
	private BitmapFont font;
	
	public WorldRenderer(PwlGame pwlgame, World world) {
        this.pwlgame = pwlgame;
        batch = pwlgame.batch;
        this.world = world;
        bgImg = new Texture("bg_night.jpg");
        mchoneImg = new Texture("mch1.png");
        mchtwoImg = new Texture("mch2.png");
        ordiballImg = new Texture("ordiBall.png");
        bonusballImg = new Texture("bonusBall.png");
        eyeballImg = new Texture("eyeBall.png");
        heartballImg = new Texture("heartBall.png");
        ggballImg = new Texture("ggBall.png");
        blockImg = new Texture("pipe.png");
        boltImg = new Texture("bolt.png");
        gameOver = new Texture("badlogic.jpg");
        ball = world.getBall();
        ball2 = world.getBall2();
        lightning = world.getLightning();
        sky = world.getSky();
        font = new BitmapFont();
        time = 0;
    }
	
	public void render(float delta) {
		batch.begin();
		
		batch.draw(bgImg,0,0);
		if(world.status=="running") {
			update();
		}
	    Vector2 pos = ball.getPosition();
	    Vector2 pos3 = ball2.getPosition();
	    Vector2 pos2 = lightning.getPosition();
	    checkStatus(pos,pos2,pos3);
	    if(world.status=="running") {
	    	bgImg = sky.getBg();
	    	//update();
	    }
	    if(world.getLife()>=0) {
	    	if(lightning.isPress==true) {
	    		batch.draw(mchtwoImg, 320, 150);
	    	}
	    	else {
	    		batch.draw(mchoneImg, 320, 150);
	    	}
	    	switch(ball.getType()) {
	    	case 1:
	    		batch.draw(ordiballImg,pos.x,pos.y);
	    		break;
	    	case 2:
	    		batch.draw(bonusballImg,pos.x,pos.y);
	    		break;
	    	case 3:
	    		batch.draw(ggballImg,pos.x,pos.y);
	    		break;
	    	case 4:
	    		batch.draw(eyeballImg,pos.x,pos.y);
	    		break;
	    	case 5:
	    		batch.draw(heartballImg,pos.x,pos.y);
	    		break;
	    	}
	    	if(sky.getBg()==sky.skyNight) {
	    		if(!(world.getRight()==1&&Gdx.input.isKeyPressed(Keys.SPACE))) {
	    			switch(ball2.getType()) {
	    			case 1:
	    				batch.draw(ordiballImg,pos3.x,pos3.y);
	    				break;
	    			case 2:
	    				batch.draw(bonusballImg,pos3.x,pos3.y);
	    				break;
	    			case 3:
	    				batch.draw(ggballImg,pos3.x,pos3.y);
	    				break;
	    			case 4:
	    				batch.draw(eyeballImg,pos3.x,pos3.y);
	    				break;	
	    			case 5:
	    				batch.draw(heartballImg,pos3.x,pos3.y);
	    				break;
	    			}
	    		}
	    		else {
	    			time+=1;
	    			if(time==20) {
	    				world.decreaseRight();
	    				time = 0;
	    			}
	    		}
	    	}
	    	batch.draw(boltImg,pos2.x,pos2.y);
	    	font.draw(batch, "Life: " + world.getLife(), 650, 560);
	    	font.draw(batch, "Right: " + world.getRight(),650, 540);
	    	for(int i = 0;i<a.length;i++) {
	    		if(a[i]=="#") {
	    			batch.draw(blockImg,i*40,0);
	    		}
	    	}
	    }
	    else {
	    	world.status = "gg";
	    	font.getData().setScale(5, 5);
	    	font.draw(batch, "Game Over",200, 310);
	    	font.getData().setScale(1, 1);
	    	font.draw(batch, "Life: " + 0, 650, 560);
	    	font.draw(batch, "Right: " + world.getRight(),650, 540);
	    	if(Gdx.input.isKeyPressed(Keys.ENTER)) {
	    		time = 0;
	    		lightning.isPress = false;
	    		pos2.y = 610;
	    		Random rn2 = new Random();
	    		int j = Math.abs((rn2.nextInt() % 10));
	    		pos.x = posx[0];
	    		ball.isLaunch = false;
	    		pos.y = 41;
	    		ball.touch = 0;
	    		pos3.x = posx[j];
	    		pos3.y = 0;
	    		world.reset();
	    		sky.reset();
	    	}
	    }
	    font.getData().setScale(1, 1);
	    font.draw(batch, "Score: " + world.getScore(), 650, 580);
	    batch.end();
	}
	
	public void update() {
		ball.move();
		ball2.move();
		lightning.move();
		sky.update();
		
	}
	
	public void checkStatus(Vector2 a,Vector2 b,Vector2 c) {
		if(Math.abs(a.y-b.y)<=5&&Math.abs(a.x-b.x)<=5) {
	    	if(ball.getType()==1) {
	    		world.increaseScore();
	    	}
	    	else if(ball.getType()==2){
	    		world.increaseScore2();
	    	}
	    	else if(ball.getType()==4){
	    		world.increaseRight();
	    		world.increaseScore();
	    	}
	    	else if(ball.getType()==5) {
	    		world.increaseLife();
	    	}
	    	else {
	    		world.decreaseLife2();
	    	}
	    	lightning.isPress = false;
	    	ball.isTouch = true;
	    	b.y = 610;
	    }
		if(Math.abs(b.y-c.y)<=5&&Math.abs(b.x-c.x)<=5) {
	    	world.decreaseLife();
	    }
		if(a.y<=39) {
	    	if(ball.getType()==1||ball.getType()==2) {
	    	world.decreaseLife();
	    	}
	    }
	    
	}
	
}

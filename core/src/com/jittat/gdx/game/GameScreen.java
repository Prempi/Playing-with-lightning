package com.jittat.gdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class GameScreen extends ScreenAdapter{
	private PwlGame pwlGame;
	private Texture mchImg;
	private Texture blockImg;
	private Texture ballImg;
	private int[] x = new int[] {0,80,160,240,320,400,480,560,640,720};
	private int xpos;
	private int xpos2;
	private int y;
	private int y2;
	private int mode;
	private int press;
	private boolean launch;
	private String[] a = new String [] {"#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#",".","#"};
	public GameScreen(PwlGame pwlGame) {
		this.pwlGame = pwlGame;
		mchImg = new Texture("pacman.png");
		blockImg = new Texture("wall.png");
		ballImg = new Texture("dot.png");
		xpos = x[0];
		y = 40;
		y2 = 800;
		xpos2 = -1;
		mode = 0;
		press = 0;
		launch = false;
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    //lightning();
	    if(Gdx.input.isKeyPressed(Keys.NUM_0)) {
            xpos2 = x[0];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(Gdx.input.isKeyPressed(Keys.NUM_1)) {
            xpos2 = x[0];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(Gdx.input.isKeyPressed(Keys.NUM_2)) {
            xpos2 = x[1];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(Gdx.input.isKeyPressed(Keys.NUM_3)) {
            xpos2 = x[2];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(Gdx.input.isKeyPressed(Keys.NUM_4)) {
            xpos2 = x[3];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(Gdx.input.isKeyPressed(Keys.NUM_5)) {
            xpos2 = x[4];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(Gdx.input.isKeyPressed(Keys.NUM_6)) {
            xpos2 = x[5];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(Gdx.input.isKeyPressed(Keys.NUM_7)) {
            xpos2 = x[6];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(Gdx.input.isKeyPressed(Keys.NUM_8)) {
            xpos2 = x[7];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(Gdx.input.isKeyPressed(Keys.NUM_9)) {
            xpos2 = x[8];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(Gdx.input.isKeyPressed(Keys.NUM_0)) {
            xpos2 = x[9];
            if(press==0) {
            	y2=700;
            }
            press = 1;
        }
	    if(press==1) {
	    	y2-=7;
	    }
	    if(y2==0) {
	    	press=0;
	    }
	    if(Math.abs(y-y2)<5&&xpos==xpos2) {
	    	y = -1;
	    	y = 40;
	    	y2 = -1;
	    	press=0;
	    }
	    if(!launch) {
	    	y+=1;
	    	if(y>=140) {
	    		launch=true;
	    	}
	    }
	    else{
	    	y-=1;
	    	if(y<=40) {
	    		launch=false;
	    		Random rn = new Random();
	    		int i = Math.abs((rn.nextInt() % 10));
	    		System.out.println(i);
	    		xpos = x[i];
	    	}
	    }
	    SpriteBatch batch = pwlGame.batch;
	    batch.begin();
	    batch.draw(mchImg, 380, 300);
	    batch.draw(ballImg,xpos,y);
	    batch.draw(ballImg,xpos2,y2);
	    for(int i = 0;i<a.length;i++) {
	    	if(a[i]=="#") {
	    		batch.draw(blockImg,i*40,0);
	    	}
	    }
	    batch.end();
	}
}

package com.mygdx.game;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.GL20;

import java.awt.*;

public class game1 extends ApplicationAdapter {
	ShapeRenderer shape;
	Ball ball;
	Paddle paddle = new Paddle();
	List<Block> blocks = new ArrayList<>();
	@Override
	public void create() {
		shape = new ShapeRenderer();
		ball = new Ball(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 10, 5, 5);
		int blockWidth = 63;
		int blockHeight = 20;
		for (int y = Gdx.graphics.getHeight()/2;y < Gdx.graphics.getHeight();y += blockHeight+10){
			for (int x = 0; x < Gdx.graphics.getWidth();x += blockWidth+10){
				blocks.add(new Block(x,y,blockWidth,blockHeight));
			}
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		paddle.update();
		paddle.draw(shape);
		ball.checkCollision(paddle);
		ball.update();
		ball.draw(shape);
		for (Block block:blocks){
			block.draw(shape);
			ball.checkCollision(block);
		}
		for (int i = 0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			if (b.destroyed) {
				blocks.remove(b);
				i--;
			}
		}
		shape.end();
	}

}

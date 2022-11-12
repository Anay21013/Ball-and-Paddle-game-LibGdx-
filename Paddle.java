package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y;
    int width;
    int height;
    public Paddle(){
        this.y = 20;
        this.width = 80;
        this.height = 8;
    }
    public void update(){
        x = Gdx.input.getX() - width/2;
    }
    public void draw(ShapeRenderer shape){
        shape.rect(x ,y , width,height);
    }
}

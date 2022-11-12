package com.mygdx.game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
public class Ball {
    int x;
    int y;
    int size;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

    public Ball(int x, int y, int size, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void update() {
        x += xSpeed;
        y += ySpeed;
        if (x - size < 0 || x + size > Gdx.graphics.getWidth()) {
            xSpeed = -xSpeed;
        }
        if (y - size < 0 || y + size > Gdx.graphics.getHeight()) {
            ySpeed = -ySpeed;
        }
    }
    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, size);
    }
    private boolean collidesWith(Paddle paddle){
        if (x+size<paddle.x||x-size>paddle.x+paddle.width||y+size<paddle.y||y-size>paddle.y+paddle.height){
            return false;
        }
        return true;
    }
    public void checkCollision(Paddle paddle){
        if(collidesWith(paddle)){
            color = Color.GREEN;
            ySpeed = -ySpeed;
        }
        else{
            color = Color.WHITE;
        }
    }
    private boolean collidesWith(Block block){
        if (x + size < block.x || x - size > block.x + block.width || y + size < block.y || y - size > block.y + block.height) {
            return false;
        }
        return true;
    }
    public void checkCollision(Block block){
        if (collidesWith(block)){
            ySpeed = -ySpeed;
            block.destroyed = true;
        }
    }
}

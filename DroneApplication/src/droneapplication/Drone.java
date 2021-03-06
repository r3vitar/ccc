/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package droneapplication;

import java.time.Duration;

/**
 *
 * @author Julian
 */
public class Drone {
    private Thread t;
    private int id = 0;
    private int startX;
    private int targetX;
    private int startY;
    private int targetY;
    private int speed = 0;
    private int x;
    private int y;
    private Duration tick;
    private enum Direction{
        N, NE, E, SE, S, SW, W, NW
    }
    private Direction direction = Direction.N;

    public Drone(int id, int startX, int startY, int targetX, int targetY, int speed, Duration tick, Direction direction) {
        this.id = id;
        this.startX = startX;
        this.targetX = targetX;
        this.startY = startY;
        this.targetY = targetY;
        this.speed = speed;
        this.tick = tick;
        this.direction = direction;
        this.x = this.startX;
        this.y = this.startY;
    }

    public Drone(int startX, int startY, int targetX, int targetY) {
        this.startX = startX;
        this.targetX = targetX;
        this.startY = startY;
        this.targetY = targetY;
        this.x = this.startX;
        this.y = this.startY;
    }
    
    

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getTargetX() {
        return targetX;
    }

    public void setTargetX(int targetX) {
        this.targetX = targetX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getTargetY() {
        return targetY;
    }

    public void setTargetY(int targetY) {
        this.targetY = targetY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if(this.speed>=0 && this.speed<=5){
            this.speed = speed;
        } else {
            throw new IllegalArgumentException("Not a valid number!");
        }
    }

    public Duration getTick() {
        return tick;
    }

    public void setTick(Duration tick) {
        this.tick = tick;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void startMoveByTick(){
        t= new Thread(new Runnable() {
            @Override
            public void run() {
                
            }
        });
        t.start();
    }
    
    public void move(){
        int test = this.speed;
        switch(this.direction){
            case N:
                this.y += this.speed;
                break;
            case E:
                this.x += this.speed;
                break;
            case S:
                this.y -= this.speed;
                break;
            case W:
                this.x -= this.speed;
                break;
            case NE:
                for (int i = 0; i < test; i++) {
                    this.y += this.speed;
                    this.x += this.speed;
                }
                break;
            case NW:
                for (int i = 0; i < test; i++) {
                    this.y += this.speed;
                    this.x -= this.speed;
                }
                break;
            case SE:
                for (int i = 0; i < test; i++) {
                    this.y -= this.speed;
                    this.x += this.speed;
                }
                break;
            case SW:
                for (int i = 0; i < test; i++) {
                    this.y -= this.speed;
                    this.x -= this.speed;
                }
                break;
        }
    }
}

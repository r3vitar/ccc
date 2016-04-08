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
    
    private int id = 0;
    private int startX;
    private int targetX;
    private int startY;
    private int targetY;
    private int speed = 0;
    private int x;
    private int y;
    private Duration tick;
    public changeListener ch;
    private enum Direction{
        N, NE, E, SE, S, SW, W, NW
    }
    private Direction direction = Direction.N;



    public Drone(int startX, int startY, int targetX, int targetY, Object o) {
        this.startX = startX;
        this.targetX = targetX;
        this.startY = startY;
        this.targetY = targetY;
        this.x = this.startX;
        this.y = this.startY;
        ch = (changeListener) o;
        moveToTarget(targetX, targetY);
    }
    public Drone(int startX, int startY, Object o) {
        this.startX = startX;
        this.targetX = targetX;
        this.startY = startY;
        this.targetY = targetY;
        this.x = this.startX;
        this.y = this.startY;
        ch = (changeListener) o;
        
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
    
    
    public void moveToTarget(int targetX, int targetY){
        this.targetX = targetX;
        this.targetY = targetY;
        if(this.startX == this.targetX){
            if(this.startY == this.targetY){
                
            }else if(this.startY > this.targetY){
                move(Direction.S, this.targetY-this.startY);
            
            }else if(this.startY < this.targetY){
                move(Direction.N, this.targetY-this.startY);
            }
                
        }else if(this.startX > this.targetX){
                if(this.startY == this.targetY){

                }else if(this.startY > this.targetY){
                    move(Direction.S, this.targetY-this.startY);

                }else if(this.startY < this.targetY){
                    move(Direction.N, this.targetY-this.startY);
                }
            move(Direction.E, this.targetX-this.startX);
        
        
        }else if(this.startX > this.targetX){
                if(this.startY == this.targetY){

                }else if(this.startY > this.targetY){
                    move(Direction.S, this.targetY-this.startY);

                }else if(this.startY < this.targetY){
                    move(Direction.N, this.targetY-this.startY);
                }
            move(Direction.W, this.targetX-this.startX);
        }
        
    }
    
    public void move(Direction dir, int speed){
        
        switch(dir){
            case N:
                this.y += speed;
                break;
            case E:
                this.x += speed;
                break;
            case S:
                this.y -= speed;
                break;
            case W:
                this.x -= speed;
                break;
            case NE:
                for (int i = 0; i < speed; i++) {
                    this.y += speed;
                    this.x += speed;
                }
                break;
            case NW:
                for (int i = 0; i < speed; i++) {
                    this.y += speed;
                    this.x -= speed;
                }
                break;
            case SE:
                for (int i = 0; i < speed; i++) {
                    this.y -= speed;
                    this.x += speed;
                }
                break;
            case SW:
                for (int i = 0; i < speed; i++) {
                    this.y -= speed;
                    this.x -= speed;
                }
                break;
                
                
        }
        ch.statusChange("");
        System.out.println(String.format(
                
                "DIRECTION \t %d %s\n"
                        + "Speed \t %d %s\n\n", 
                
                
                this.id, dir.toString(), this.id, speed));
    }
}

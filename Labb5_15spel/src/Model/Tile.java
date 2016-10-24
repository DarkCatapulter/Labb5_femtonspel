/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Faddy
 */
public class Tile {
    private final int number;
    private final int height;
    private final int width;
    private double posX;
    private double posY;
    
    Tile(int number,double posX, double posY){
        this.number = number;
        this.height = 15;
        this.width = this.height;
        this.posX = posX;
        this.posY = posY;
    }
    
    Tile(int number, int height, int width, double posX, double posY){
        this.number = number;
        this.height = height;
        this.width = width;
        this.posX = posX;
        this.posY = posY;
    }
    
    public int getNumber(){
        return number;
    }
    
    public int getHeight(){
        return height;
    }
    
    public int getWidth(){
        return width;
    }
    
    public double getX(){
        return posX;
    }
    
    public double getY(){
        return posY;
    }
    
    public void setX(double x){
        posX = x;
    }
    
    public void setY(double y){
        posY = y;
    }
}

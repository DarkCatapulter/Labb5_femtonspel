/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author Faddy
 */
public class Tile{
    private final int number;
    private final int size = 75;
    private int column;
    private int row;
    
    Tile(int number, int column, int row){
        this.number = number;
        this.column = column;
        this.row = row;
    }
    
    public int getNumber(){
        return number;
    }
    
    public int getSize(){
        return size;
    }
    
    public int getColumn(){
        return column;
    }
    
    public int getRow(){
        return row;
    }
    
    public void setColumn(int column){
        this.column = column;
    }
    
    public void setRow(int row){
        this.row = row;
    }
}

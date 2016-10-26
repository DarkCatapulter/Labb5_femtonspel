/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Faddy & Hampus
 */
public class Model {
    private Board board;
    
    public Model(){
        board = new Board();
    }
    
    public Board returnBoard(){
        return board;
    }
    
    public void moveTiles(){
        
    }
    
    public boolean isDone(){
        return false;
    }
    
    private boolean checkMoveOk(Tile other){
        return false;
    }

}

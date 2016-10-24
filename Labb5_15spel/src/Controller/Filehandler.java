/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;

/**
 *
 * @author Faddy
 */
public class Filehandler {
    private ArrayList<Object> board;
    
    Filehandler(){
        board = new ArrayList<>();
    }
    
    public ArrayList<Object> load(){
        return board;
    }
    
    public void save(ArrayList<Object> newBoard){
        board = newBoard;
    }
}

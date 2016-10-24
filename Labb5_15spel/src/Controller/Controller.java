/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Model;
import View.UI;

/**
 *
 * @author Faddy & Hampus
 */
public class Controller {

    private final Model model;
    private final UI ui;

    Controller() {
        model = new Model();
        ui = new UI(model);
    }
    
    public void resetBoard(){
        
    }
    
    public void saveToFile(){
        
    }
    
    public void loadFromFile(){
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import Controller.*;
import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Faddy & Hampus
 */
public class UI extends Application {

    private int colIndex;
    private int rowIndex;

    private Model model;
    Tile tile;
    
    public UI(){
        model = new Model();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller controller = new Controller(model, this);
        primaryStage.setTitle("15-Puzzle Game");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        for (int i = 1; i < 16; i++) {

            Rectangle rect = new Rectangle(model.returnBoard().getTile(i).getSize(), model.returnBoard().getTile(i).getSize());
            rect.setStroke(Color.BLACK);
            if (i == 0) {
                rect.setFill(null);
            } else {
                rect.setFill(Color.WHITE);
            }

            Text text = new Text("\t" + model.returnBoard().getTile(i).getNumber());
            text.setFont(Font.font(20));
            grid.add(rect, model.returnBoard().getTile(i).getColumn(), model.returnBoard().getTile(i).getRow());
            if (i != 0) {
                grid.add(text, model.returnBoard().getTile(i).getColumn(), model.returnBoard().getTile(i).getRow());
            }
            // EVENTHANDLER FOR MOUSE ON RECT
            rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    handlePosID(event);
                    controller.handleClick(event, rect, text, grid,colIndex,rowIndex);
                }
            });
            //  EVENTHANDLER FOR MOUSE ON TEXT
            text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    handlePosID(event);
                    controller.handleClick(event, rect, text, grid,colIndex,rowIndex);
                }
            });
        }

        Scene scene = new Scene(grid, 350, 350);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void setRowIndex(int RowIndex) {
        this.rowIndex = RowIndex;
    }

    public void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }
    public void setIndex(int colIndex,int rowIndex){
        this.colIndex = colIndex;
        this.rowIndex = rowIndex;
    }




    private void handlePosID(MouseEvent event) {
        Node source = (Node) event.getSource();
        setColIndex(GridPane.getColumnIndex(source));
        setRowIndex(GridPane.getRowIndex(source));
        System.out.println(colIndex);
        System.out.println(rowIndex);

    }
}

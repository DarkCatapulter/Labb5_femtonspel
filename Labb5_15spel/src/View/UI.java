/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
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

    private Model model;
    Board board = new Board();
    Tile tile;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("15-Puzzle Game");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Button
        Button btn = new Button("reset");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 3, 4);

        for (int i = 0; i < 16; i++) {
            creater(grid, board, i);
        }
        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        
        
                grid.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                Node source = (Node) event.getSource();
                System.out.println(GridPane.getColumnIndex(source));
                int colIndex = GridPane.getColumnIndex( source);
                int rowIndex = GridPane.getRowIndex( source);

            }

        });
    

    }

    private void creater(GridPane grid, Board board, int index) {
        Tile tmptile = new Tile();
        tmptile = board.getTile(index);
        Rectangle rect = new Rectangle(tmptile.getSize(), tmptile.getSize());
        rect.setStroke(Color.BLACK);
        if (index == 0) {
            rect.setFill(Color.GREY);
        } else {
            rect.setFill(null);
        }

        Text text = new Text("\t" + tmptile.getNumber());
        text.setFont(Font.font(20));

        grid.add(text, tmptile.getColumn(), tmptile.getRow());
        grid.add(rect, tmptile.getColumn(), tmptile.getRow());

    }



}

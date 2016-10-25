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

    private int colIndex;
    private int rowIndex;
    private Model model;
    Board board = new Board();
    Tile tile;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("15-Puzzle Game");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));

        Tile tmptile = new Tile();
        for (int i = 0; i < 16; i++) {
            tmptile = board.getTile(i);
            Rectangle rect = new Rectangle(tmptile.getSize(), tmptile.getSize());
            rect.setStroke(Color.BLACK);
            if (i == 0) {
                rect.setFill(Color.GREY);
            } else {
                rect.setFill(Color.WHITE);
            }

            Text text = new Text("\t" + tmptile.getNumber());
            text.setFont(Font.font(20));

            grid.add(rect, tmptile.getColumn(), tmptile.getRow());
            if (i != 0) {
                grid.add(text, tmptile.getColumn(), tmptile.getRow());
            }
            rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Node source = (Node) event.getSource();
                    setColIndex(GridPane.getColumnIndex(source));
                    setRowIndex(GridPane.getRowIndex(source));
                    System.out.println(colIndex);
                    System.out.println(rowIndex);

                }
            });
            text.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Node source = (Node) event.getSource();

                    setColIndex(GridPane.getColumnIndex(source));
                    setRowIndex(GridPane.getRowIndex(source));
                    System.out.println(colIndex);
                    System.out.println(rowIndex);

                }
            });
        }

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void setRowIndex(int RowIndex) {
        this.rowIndex = RowIndex;
    }

    private void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }

}

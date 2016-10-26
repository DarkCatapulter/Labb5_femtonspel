/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
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

    Model model = new Model();
    Tile tile;

    @Override
    public void start(Stage primaryStage) throws Exception {

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

            rect.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Node source = (Node) event.getSource();
                    setColIndex(GridPane.getColumnIndex(source));
                    setRowIndex(GridPane.getRowIndex(source));
                    System.out.println(colIndex);
                    System.out.println(rowIndex);
                    if (model.returnBoard().checkMoveOk(model.returnBoard().findTile(rowIndex, colIndex))) {
                        System.out.println("test" + model.returnBoard().findTile(rowIndex, colIndex));

                        System.out.println("ggggg " + model.returnBoard().findTile(rowIndex, colIndex));

                        grid.getChildren().remove(rect);
                        grid.getChildren().remove(text);
                        grid.add(rect, model.returnBoard().getTile(0).getColumn(), model.returnBoard().getTile(0).getRow());
                        grid.add(text, model.returnBoard().getTile(0).getColumn(), model.returnBoard().getTile(0).getRow());
                        model.returnBoard().findTile(rowIndex, colIndex).setPos(model.returnBoard().getTile(0).getRow(), model.returnBoard().getTile(0).getColumn());

                        model.returnBoard().getTile(0).setColumn(colIndex);
                        model.returnBoard().getTile(0).setRow(rowIndex);
                        System.out.println(model.returnBoard().isDone());
                    }
                    System.out.println(model.returnBoard().checkMoveOk(model.returnBoard().findTile(rowIndex, colIndex)));

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

                    if (model.returnBoard().checkMoveOk(model.returnBoard().findTile(rowIndex, colIndex))) {
                        System.out.println("hej" + model.returnBoard().findTile(rowIndex, colIndex));

                        grid.getChildren().remove(rect);
                        grid.getChildren().remove(text);
                        grid.add(rect, model.returnBoard().getTile(0).getColumn(), model.returnBoard().getTile(0).getRow());
                        grid.add(text, model.returnBoard().getTile(0).getColumn(), model.returnBoard().getTile(0).getRow());

                        model.returnBoard().findTile(rowIndex, colIndex).setPos(model.returnBoard().getTile(0).getRow(), model.returnBoard().getTile(0).getColumn());
                        model.returnBoard().getTile(0).setColumn(colIndex);
                        model.returnBoard().getTile(0).setRow(rowIndex);
                        System.out.println(model.returnBoard().isDone());
                    }
                    System.out.println(model.returnBoard().checkMoveOk(model.returnBoard().findTile(rowIndex, colIndex)));
                }
            });
        }



        Scene scene = new Scene(grid, 350, 350);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void setRowIndex(int RowIndex) {
        this.rowIndex = RowIndex;
    }

    private void setColIndex(int colIndex) {
        this.colIndex = colIndex;
    }

    private void paintGrayTile(int row, int Col, GridPane grid) {

        Rectangle rect = new Rectangle(model.returnBoard().getTile(0).getSize(), model.returnBoard().getTile(0).getSize());
        rect.setStroke(Color.BLACK);
        rect.setFill(Color.GREY);
        grid.setColumnIndex(rect, colIndex);
        grid.setRowIndex(rect, rowIndex);
    }
}

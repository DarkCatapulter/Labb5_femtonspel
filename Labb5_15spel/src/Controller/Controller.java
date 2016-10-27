package Controller;

import Model.*;
import View.UI;
import static javafx.application.Application.launch;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 *
 * @author Fatih Yalcin and Hampus Glantz
 */
public class Controller {

    private final Model model;
    private UI ui;
    private final Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public Controller(Model model, UI ui) {
        this.model = model;
        this.ui = ui;
    }

    public void resetBoard() {

    }

    public void saveToFile() {

    }

    public void loadFromFile() {

    }

    public void handleClick(MouseEvent event, Rectangle rect, Text text, GridPane grid, int colIndex, int rowIndex) {
        if (model.returnBoard().checkMoveOk(model.returnBoard().findTile(rowIndex, colIndex))) {
            grid.getChildren().remove(rect);
            grid.getChildren().remove(text);
            grid.add(rect, model.returnBoard().getTile(0).getColumn(), model.returnBoard().getTile(0).getRow());
            grid.add(text, model.returnBoard().getTile(0).getColumn(), model.returnBoard().getTile(0).getRow());
            model.returnBoard().findTile(rowIndex, colIndex).setPos(model.returnBoard().getTile(0).getRow(), model.returnBoard().getTile(0).getColumn());
            model.returnBoard().getTile(0).setColumn(colIndex);
            model.returnBoard().getTile(0).setRow(rowIndex);
            if (model.returnBoard().isDone()) {
                showAlert("You have Won!");
            }
        }

    }

    public void handleReset() {
        model.returnBoard().resetBoard();
    }

    public void handleQuit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();

    }

    private void showAlert(String message) {
        if (!alert.isShowing()) {
            alert.setHeaderText("");
            alert.setTitle("Alert!");
            alert.setContentText(message);
            alert.show();
        }
    }
}

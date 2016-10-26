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
 * @author Faddy
 */
public class Board {

    private final ArrayList<Tile> tiles;
    Tile tile;

    public Board() {
        tiles = new ArrayList<>();
        initBoard();
    }

    private void initBoard() {
        int column = 0, row = 0;
        tiles.add(new Tile(0, 3, 3));
        for (int i = 1; i < 16; i++) {
            Tile tile = new Tile(i, column, row);
            addTile(tile);
            if (!(column == 3)) {
                column++;
            } else {
                column = 0;
                row++;
            }
        }

    }

    public void resetBoard() {

    }

    public ArrayList<Tile> getBoard() {
        return tiles;
    }

    public void swapTiles(int index) {
        int tempColumn, tempRow;
        tempColumn = getGreyColumn();
        tempRow = getGreyRow();
        setGreyColumn(tiles.get(index).getColumn());
        setGreyRow(tiles.get(index).getRow());
        tiles.get(index).setColumn(tempColumn);
        tiles.get(index).setRow(tempRow);
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }

    private int getGreyColumn() {
        return tiles.get(0).getColumn();
    }

    private int getGreyRow() {
        return tiles.get(0).getRow();
    }

    private void setGreyColumn(int column) {
        tiles.get(0).setColumn(column);
    }

    private void setGreyRow(int row) {
        tiles.get(0).setRow(row);
    }

    public Tile getTile(int index) {
        return tiles.get(index);
    }

    public boolean isDone() {
        return false;
    }

    public boolean checkMoveOk(Tile other) {

                System.out.println(tiles.get(0).getColumn()+"   "+tiles.get(0).getRow());
                System.out.println(other);
        if (tiles.get(0).getColumn() == other.getColumn() || tiles.get(0).getRow() == other.getRow()) {
                    if (tiles.get(0).getColumn() == other.getColumn() + 1
                    || tiles.get(0).getColumn() == other.getColumn() - 1
                    || tiles.get(0).getRow() == other.getRow() + 1
                    || tiles.get(0).getRow() == other.getRow() - 1) {
                    return true;
            }
        }

        return false;
        
    }

    public Tile findTile(int row, int col) {
        Tile tmp = new Tile();
        for (Tile tile : tiles) {
            if (tile.getColumn() == col && tile.getRow() == row) {
                return tile;
         
            } else {
                tmp = null;
            }
        }
        return tmp;
    }

}

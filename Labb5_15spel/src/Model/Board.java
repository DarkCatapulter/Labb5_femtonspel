/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Faddy
 */
public class Board {

    private final ArrayList<Tile> tiles;
    private int height;
    private int width;

    Board() {
        tiles = new ArrayList<>();
        initBoard();
    }

    private void initBoard() {
        int column = 0, row = 0;
        for (int i = 1; i < 15; i++) {
            Tile tile = new Tile(i, column, row);
            addTile(tile);
            if (!(column == 4)) {
                column++;
            } else {
                column = 0;
                row += 16;
            }
        }
        tiles.add(new Tile(0, column, row));
    }
    
    public void resetBoard(){
        
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
    
    private void setGreyColumn(int column){
        tiles.get(0).setColumn(column);
    }
    
    private void setGreyRow(int row){
        tiles.get(0).setRow(row);
    }
}

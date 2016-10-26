
package Model;
/**
 *
 * @author Fatih Yalcin and Hampus Glantz
 */
public class Tile{
    private final int number;
    private final int size = 75;
    private int column;
    private int row;
    
    public Tile(int number, int column, int row){
        this.number = number;
        this.column = column;
        this.row = row;
    }
    public    Tile(){
        this.number = 0;
        this.column = 0;
        this.row = 0;
    }
    public int getNumber(){
        return number;
    }
    
    public int getSize(){
        return size;
    }
    
    public int getColumn(){
        return column;
    }
    
    public int getRow(){
        return row;
    }
    
    public void setColumn(int column){
        this.column = column;
    }
    
    public void setRow(int row){
        this.row = row;
    }
  public void setPos(int row, int col){
      this.row = row;
      this.column = col;
  }
    
}

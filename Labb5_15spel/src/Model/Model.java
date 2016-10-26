
package Model;

/**
 *
 * @author Fatih Yalcin and Hampus Glantz
 */
public class Model {
    private final Board board;
    
    public Model(){
        board = new Board();
    }
    
    public Board returnBoard(){
        return board;
    }
}

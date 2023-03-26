package goldfish.model.pieces;
import goldfish.model.Board;


public class Rook extends Piece{
    public Rook(String color, Board board) {
        super(color, "R", board);
    }

    
    /** 
     * @param x
     * @param y
     * @return boolean
     */
    @Override
    public boolean verifyMove(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'possibleMoves'");


        // new pos must have same x diff y, or same y diff x
    }
}
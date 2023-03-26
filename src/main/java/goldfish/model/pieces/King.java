package goldfish.model.pieces;

import goldfish.model.Board;

public class King extends Piece {
    public King(String color, Board board) {
        super(color, "K", board);
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
    }
}
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


    public boolean verifyCastle(boolean isLeft){
        // check if rook and king haven't moved
        // make sure no pieces between rook and king
        // not in check 

        return false;

    }
}
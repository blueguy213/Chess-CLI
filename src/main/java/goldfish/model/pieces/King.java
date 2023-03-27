package goldfish.model.pieces;

import goldfish.model.Board;

public class King extends Piece {
    public King(String color, Board board) {
        super(color, "K", board);
    }
    
    /** 
     * Verifies that x and y are within one square of the current position but not both identical
     * and that the new square is not under attack by the oppponent.
     * @param x
     * @param y
     * @return boolean
     */
    @Override
    public boolean verifyMove(int x, int y) {

        boolean stayingStill = (x == this.getX() && y == this.getY());
        boolean inRange = (Math.abs(x - this.getX()) <= 1 && Math.abs(y - this.getY()) <= 1);

        return inRange && !stayingStill && !this.isEnemyAttacking(x, y);
    }


    /**
     * Typically not called for the king, but if it is, it will return false.
     * 
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @return boolean
     */
    @Override
    public boolean putsKingInCheck(int x, int y) {
        return false;
    }

    /**
     * Checks if the king can castle with the rook on the left/right side of the board.
     * 
     * @param isLeft true if trying to castle with the rook on the left side of the board (a), false if castling with the rook on the right (h)
     * @return boolean
     */
    public boolean verifyCastle(boolean isLeft){
        // check if rook and king haven't moved
        // make sure no pieces between rook and king
        // not in check 

        return false;

    }
}
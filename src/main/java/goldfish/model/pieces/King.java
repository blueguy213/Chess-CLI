package goldfish.model.pieces;

import goldfish.model.Board;

/**
 * King class represents a king in the game of chess
 * @author Sree Kommalapati and Shreeti Patel
 */
public class King extends Piece {
    
    boolean hasMoved = false;
   
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

        if (inRange && !stayingStill && !this.isEnemyAttacking(x, y)) {
            return true;
        } else {
            return false;
        }
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
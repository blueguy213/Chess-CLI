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

        if (Math.abs(x - this.getX()) <= 1 && Math.abs(y - this.getY()) <= 1 && !stayingStill) {
            return !this.isEnemyAttacking(x, y);
        } else {
            return false;
        }
    }


    @Override
    public boolean putsKingInCheck(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putsKingInCheck'");
    }
}
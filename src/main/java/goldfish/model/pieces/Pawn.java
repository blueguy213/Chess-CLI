package goldfish.model.pieces;

import goldfish.model.Board;

public class Pawn extends Piece {
    
    boolean hasMoved = false;
    public Pawn(String color, Board board) {
        super(color, "p", board);
    }

    /** 
     * 
     * @param x
     * @param y
     * @return boolean
     */
    @Override
    public boolean verifyMove(int x, int y) {
        if (x != this.getX()) {
            return false;
        } else {
            if (this.getColor().equals("w")) {
                if (y == this.getY() + 1) {
                    return true;
                }
            } else {
                if (y == this.getY() - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     */
    @Override
    public boolean putsKingInCheck(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putsKingInCheck'");
    }
}
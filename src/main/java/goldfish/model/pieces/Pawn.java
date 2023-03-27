package goldfish.model.pieces;

import goldfish.model.Board;

/**
 * The Pawn class represents a pawn in the game of chess
 * @author Sree Kommalapati and Shreeti Patel
 */
public class Pawn extends Piece {
    
    /**
     * 
     * @param color color of the piece
     * @param board board the piece is on
     */
    public Pawn(String color, Board board) {
        super(color, "p", board);
    }

    /** 
     * Return true if the pawn can move to the given coordinates and false otherwise
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @return boolean
     */
    @Override
    public boolean verifyMove(int x, int y) {
        if (x != this.getX()) {
            return false;
        } else {
            if (this.getColor().equals("w")) {
                if (y == this.getY() - 1 || (y == this.getY() - 2 && !this.getHasMoved())) {
                    return getBoard().isOccupied(x, y) != 1;
                }
            } else {
                if (y == this.getY() + 1 || (y == this.getY() + 2 && !this.getHasMoved())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determines if the king is in check after the pawn has moved.
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @return boolean
     */
    @Override
    public boolean putsKingInCheck(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putsKingInCheck'");
    }
}
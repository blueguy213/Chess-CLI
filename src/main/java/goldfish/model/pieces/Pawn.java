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
     * Return true if the move is valid for a pawn
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @return boolean
     */
    @Override
    public boolean verifyMove(int x, int y) {
        if (Math.abs(this.getX() - x) > 1) {
            return false;
        } else if (this.getX() == x) {
            if (this.getColor().equals("w")) {
                if (y == this.getY() - 1 && getBoard().isOccupied(x, y) == 0) {
                    return true;
                } else if (y == this.getY() - 2 && this.getFirstMove() == -1 && getBoard().isOccupied(x, y + 1) == 0 && getBoard().isOccupied(x, y) == 0) {
                    return getBoard().isOccupied(x, y) != 1;
                }
            } else {
                if (y == this.getY() + 1 && getBoard().isOccupied(x, y) != 2) {
                    return true;
                } else if (y == this.getY() + 2 && this.getFirstMove() == -1 && getBoard().isOccupied(this.getX(), this.getY() + 1) == 0 && getBoard().isOccupied(x, y) != 2) {
                    return true;
                }
            }
        } else {
            if (this.getColor().equals("w")) {
                if (y == this.getY() - 1) {
                    if (getBoard().isOccupied(x, y) == 2) {
                        return true;
                    } else if (getBoard().getPiece(x, y + 1).toString().charAt(1) == 'p' && getBoard().getPiece(x, y + 1).getFirstMove() == getBoard().getTurn() - 1) {
                        return true;
                    }
                }
            } else {
                if (y == this.getY() + 1 && getBoard().isOccupied(x, y) == 1) {
                    return true;
                } else if (y < 7 && getBoard().getPiece(x, y + 1).toString().charAt(1) == 'p' && getBoard().getPiece(x, y + 1).getFirstMove() == getBoard().getTurn() - 1) {
                    
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
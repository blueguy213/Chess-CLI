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
     * Return true if the move is valid for a Pawn
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @param real checks if method is being called from the Game loop
     * @return boolean
     */
    @Override
    public boolean verifyMove(int destX, int destY, boolean real) {
        // Check if the X coordinate is the same or if it is one awadestY
        if (Math.abs(this.getX() - destX) > 1 || Math.abs(this.getY() - destY) > 2) {
            return false; // If it is more than one awadestY, it is not a valid move
        } else if (this.getX() == destX) {
            if (this.getColor().equals("w")) { // If the piece is white
                if (destY == this.getY() - 1 && getBoard().isOccupied(destX, destY) == 0) {
                    return true;
                } else if (destY == this.getY() - 2 && this.getFirstMove() == -1 && getBoard().isOccupied(destX, destY + 1) == 0 && getBoard().isOccupied(destX, destY) == 0) {
                    return getBoard().isOccupied(destX, destY) != 1;
                }
            } else { // If the piece is black
                if (destY == this.getY() + 1 && getBoard().isOccupied(destX, destY) != 2) {
                    return true;
                } else if (destY == this.getY() + 2 && this.getFirstMove() == -1 && getBoard().isOccupied(this.getX(), this.getY() + 1) == 0 && getBoard().isOccupied(destX, destY) != 2) {
                    return true;
                }
            }
        } else {
            if (this.getColor().equals("w")) { // If the piece is white
                if (destY == this.getY() - 1) {
                    if (getBoard().isOccupied(destX, destY) == 2) {
                        return true;
                    }
                    if (getBoard().getPiece(destX, destY + 1).toString().equals("bp") && getBoard().getPiece(destX, destY + 1).getFirstMove() == getBoard().getRealTurn() - 1) {
                        if (real) {
                            getBoard().getTiles()[destY+1][destX].setPiece(null);
                        } 
                        return true;
                    }
                }
            } else { // If the piece is black
                if (destY == this.getY() + 1) {
                    if (getBoard().isOccupied(destX, destY) == 1) {
                        return true;
                    }
                    if (getBoard().getPiece(destX, destY - 1).toString().equals("wp") && getBoard().getPiece(destX, destY - 1).getFirstMove() == getBoard().getRealTurn() - 1) {
                        if (real) {
                            getBoard().getTiles()[destY-1][destX].setPiece(null);
                        } 
                        return true;
                    }
                }
            }
        }
        
        if (real && this.putsKingInCheck(destX, destY)) {
            return false;
        }

        return true;
    }
}
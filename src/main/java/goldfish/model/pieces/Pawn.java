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
     * @param real checks if method is being called from the Game loop
     * @return boolean
     */
    @Override
    public boolean verifyMove(int x, int y, boolean real) {
        // Check if the X coordinate is the same or if it is one away
        if (Math.abs(this.getX() - x) > 1) {
            return false; // If it is more than one away, it is not a valid move
        } else if (this.getX() == x) {
            if (this.getColor().equals("w")) { // If the piece is white
                if (y == this.getY() - 1 && getBoard().isOccupied(x, y) == 0) {
                    return true;
                } else if (y == this.getY() - 2 && this.getFirstMove() == -1 && getBoard().isOccupied(x, y + 1) == 0 && getBoard().isOccupied(x, y) == 0) {
                    return getBoard().isOccupied(x, y) != 1;
                }
            } else { // If the piece is black
                if (y == this.getY() + 1 && getBoard().isOccupied(x, y) != 2) {
                    return true;
                } else if (y == this.getY() + 2 && this.getFirstMove() == -1 && getBoard().isOccupied(this.getX(), this.getY() + 1) == 0 && getBoard().isOccupied(x, y) != 2) {
                    return true;
                }
            }
        } else {
            if (this.getColor().equals("w")) { // If the piece is white
                if (y == this.getY() - 1) {
                    if (getBoard().isOccupied(x, y) == 2) {
                        return true;
                    }
                    // System.out.println("getBoard().getPiece(x, y + 1).toString().equals('bp'): " + getBoard().getPiece(x, y + 1).toString().equals("bp"));
                    // System.out.println("getBoard().getPiece(x, y + 1).getFirstMove(): " + getBoard().getPiece(x, y + 1).getFirstMove());
                    // System.out.println("getBoard().getTurn(): " + getBoard().getTurn());
                    if (getBoard().getPiece(x, y + 1).toString().equals("bp") && getBoard().getPiece(x, y + 1).getFirstMove() == getBoard().getRealTurn() - 1) {
                        if (real) {
                            getBoard().getTiles()[y+1][x].setPiece(null);
                        }
                        return true;
                    }
                }
            } else { // If the piece is black
                if (y == this.getY() + 1 && getBoard().isOccupied(x, y) == 1) {
                    return true;
                } else if (y < 7 && getBoard().getPiece(x, y + 1).toString().equals("wp") && getBoard().getPiece(x, y + 1).getFirstMove() == getBoard().getRealTurn() - 1) {
                    
                }
            }
        }
        return false;
    }
}
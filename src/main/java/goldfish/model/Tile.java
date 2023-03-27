package goldfish.model;

import goldfish.model.pieces.Piece;

/**
 * Tile class
 * @author Goldfish
 */
public class Tile {

    private Piece piece;
    private int x;
    private int y;

    /**
     * 
     * @param x x coordinate of the tile
     * @param y y coordinate of the tile
     */
    public Tile(int x, int y) {
        piece = null;
        this.x = x;
        this.y = y;
    }

    
    /** 
     * @return boolean
     */
    public boolean isOccupied() {
        return piece != null;
    }

    /**
     * Sets the piece on the tile to the input Piece and updates the piece's x and y coordinates if the piece is not null
     * @param piece piece to be set on the tile
     */
    public void setPiece(Piece piece) {
        if (piece != null) {
            piece.setX(x);
            piece.setY(y);
        }
        this.piece = piece;
    }

    /** 
     * Override toString method to return the piece on the tile
     * @return String
     */
    @Override
    public String toString() {
        return piece.toString();
    }

    /**
     * Gets the piece on the tile.
     * @return Piece
     */
    public Piece getPiece() {
        return piece;
    }
}

package goldfish.model;

import goldfish.model.pieces.Piece;

public class Tile {

    private Piece piece;

    public Tile() {
        piece = null;
    }

    
    /** 
     * @return boolean
     */
    public boolean isOccupied() {
        return piece != null;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    @Override
    public String toString() {
        return piece.toString();
    }
    public Piece getPiece() {
        return piece;
    }
}

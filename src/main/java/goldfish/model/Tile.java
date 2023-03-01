package goldfish.model;

import goldfish.model.pieces.Piece;

public class Tile {

    private boolean isOccupied;
    private Piece piece;

    public Tile() {
        isOccupied = false;
        piece = null;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setPiece(Piece piece) {
        if (piece == null) {
            isOccupied = false;
        } else {
            isOccupied = true;
        }
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

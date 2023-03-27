package goldfish.model;

import goldfish.model.pieces.Piece;

public class Tile {

    private Piece piece;
    private int x;
    private int y;

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

    public void setPiece(Piece piece) {
        if (piece != null){
            piece.setX(x);
            piece.setY(y);
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

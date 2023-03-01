package goldfish.model.pieces;

public abstract class Piece {

    private String color; // w = white, b = black
    private String type; // P = pawn, R = rook, N = knight, B = bishop, Q = queen, K = king

    public Piece(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public abstract boolean possibleMoves(int x, int y);
    
    @Override
    public String toString() {
        return color + type;
    }
}

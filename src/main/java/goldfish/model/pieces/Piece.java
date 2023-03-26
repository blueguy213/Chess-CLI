package goldfish.model.pieces;

public abstract class Piece {

    private String color; // w = white, b = black
    private String type; // P = pawn, R = rook, N = knight, B = bishop, Q = queen, K = king
    private int x; // x coordinate
    private int y; // y coordinate

    public Piece(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public abstract boolean verifyMove(int x, int y);
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return color + type;
    }

    public String getColor() {
        return color;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}

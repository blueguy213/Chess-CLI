package goldfish.model.pieces;

import goldfish.model.Board;

public abstract class Piece {

    private String color; // w = white, b = black
    private String type; // P = pawn, R = rook, N = knight, B = bishop, Q = queen, K = king
    private int x; // x coordinate
    private int y; // y coordinate

    private Board board;

    public Piece(String color, String type, Board board) {
        this.color = color;
        this.type = type;
        this.board = board;
    }

    public abstract boolean verifyMove(int x, int y);

    /** 
     * Override toString method
     * @return String
     */
    @Override
    public String toString() {
        return color + type;
    }

    /**
     * Gets 
     * @return String
     */
    public String getColor() {
        return color;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    //
    public Board getBoard() {
        return board;
    }
}

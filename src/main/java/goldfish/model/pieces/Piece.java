package goldfish.model.pieces;

import goldfish.model.Board;
import goldfish.model.Player;

public abstract class Piece {

    // w = white, b = black
    private String color;

    // P = pawn, R = rook, N = knight, B = bishop, Q = queen, K = king
    private String type;

    private int x; 
    private int y;

    // Board the piece is on
    private Board board;

    // Player the piece belongs to
    private Player player;

    /**
     * Superconstructor for objects that inherit the abstract Piece class.
     * @param color Color of the piece: w = white, b = black
     * @param type The type of piece to create: P = pawn, R = rook, N = knight, B = bishop, Q = queen, K = king
     * @param board the board the piece is on
     */
    public Piece(String color, String type, Board board) {
        this.color = color;
        this.type = type;
        this.board = board;
    }

    /**
     * Checks if the move is valid for the piece. True if valid, false if not.
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     */
    public abstract boolean verifyMove(int x, int y);

    /**
     * Checks if the king will be in check after the move. True if the king is in check, false if not.
     * Call at the end of verifyMove and only move forward if false.
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @return boolean
     */
    public abstract boolean putsKingInCheck(int x, int y);

    /** 
     * Override toString method to return the color and type of the piece
     * @return String
     */
    @Override
    public String toString() {
        return color + type;
    }

    /**
     * Gets the color of the piece.
     * @return String
     */
    public String getColor() {
        return color;
    }

    /**
     * Gets the type of the piece.
     * @return String
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the x coordinate of the piece.
     * 
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the y coordinate of the piece.
     * @param newY New y coordinate of the piece
     */
    public void setY(int newY) {
        this.y = newY;
    }

    /**
     * Sets the x coordinate of the piece.
     * @param newX New x coordinate of the piece
     */
    public void setX(int newX) {
        this.x = newX;
    }

    /**
     * Gets the board that the piece is on.
     * @param player
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Finds out if the opponent of the player that owns this piece is attacking the given tile.
     * @param x x coordinate of the tile in question
     * @param y y coordinate of the tile in question
     * @return
     */
    public boolean isEnemyAttacking(int x, int y) {
        return player.getOpponent().isAttacking(x, y);
    }
}

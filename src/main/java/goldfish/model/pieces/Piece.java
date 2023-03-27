package goldfish.model.pieces;

import goldfish.model.Board;
import goldfish.model.Player;

public abstract class Piece {

    // w = white, b = black
    private String color;

    // p = pawn, R = rook, N = knight, B = bishop, Q = queen, K = king
    private String type;

    private int x; 
    private int y;

    // Board the piece is on
    private Board board;

    // Player the piece belongs to
    private Player player;

    // Flag to see if the piece has moved yet (used for castling and en passant and pawn double move)
    private boolean hasMoved;

    /**
     * Superconstructor for objects that inherit the abstract Piece class.
     * @param color Color of the piece: w = white, b = black
     * @param type The type of piece to create: p = pawn, R = rook, N = knight, B = bishop, Q = queen, K = king
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
     * @return format is aN where a is the color (w = white, b = black) and N is the type (p = pawn, R = rook, N = knight, B = bishop, Q = queen, K = king)
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
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the player that owns this piece.
     * @return Player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets if the piece has moved yet.
     * @return True if the piece has moved, false if not.
     */
    public boolean getHasMoved() {
        return hasMoved;
    }

    /**
     * Gets the gameboard
     * @return The board that the piece is on.
     */
    public Board getBoard() {
        return board;
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
     * Sets the player that owns this piece.
     * @param player
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void movement() {
        hasMoved = true;
    }

    /**
     * Finds out if the opponent of the player that owns this piece is attacking the given tile.
     * @param x x coordinate of the tile in question
     * @param y y coordinate of the tile in question
     * @return
     */
    public boolean isEnemyAttacking(int x, int y) {
        // System.err.println(player);
        return player.getOpponent().isAttacking(x, y);
    }


}

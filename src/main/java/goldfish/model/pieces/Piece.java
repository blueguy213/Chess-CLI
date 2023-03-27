package goldfish.model.pieces;

import goldfish.model.Board;
import goldfish.model.Player;

/**
 * The Piece class represents a piece in the game of chess
 * @author Sree Kommalapati and Shreeti Patel
 */
public abstract class Piece {

    /**
     * Color of the piece
     * "w" = white, "b" = black
     */
    private String color;

    /**
     * Type of the piece
     * "p" = pawn, "R" = rook, "N" = knight, "B" = bishop, "Q" = queen, "K" = king
     */
    private String type;

    /**
     * The Board the piece is on
     */
    private Board board;

    /**
     * Player the piece belongs to
     */
    private Player player;

    /**
     * Flag to see if the piece has moved yet/when (for castling, en passant, and pawn double move) -1 = not moved, otherwise turn moved
     * @see goldfish.model.Pawn#verifyMove(int, int)
     * @see goldfish.model.Rook#verifyMove(int, int)
     */
    private int turnMoved;

    private int x; 
    private int y;

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
        this.turnMoved = -1;
    }

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
    public int getFirstMove() {
        return turnMoved;
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

    public void movement(int turn) {
        turnMoved = turn;
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

    /**
     * Checks if the king will be in check after the move. True if the king will be in check, false otherwise.
     * Call at the end of verifyMove and only move true if this is false.
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @return boolean
     */
    public boolean putsKingInCheck(int x, int y) {
        Piece oldPiece = getBoard().getPiece(x, y);
        getBoard().movePiece(this.x, this.y, x, y);
        // Check if the king is still in check

        if (!getPlayer().isCheck()) {
            getBoard().getTiles()[y][x].setPiece(oldPiece);
            return false;
        }
        getBoard().getTiles()[y][x].setPiece(oldPiece);
        return true;
    }

    /**
     * Checks if the move is valid for the piece. True if valid, false if not.
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     */
    public abstract boolean verifyMove(int x, int y);
}

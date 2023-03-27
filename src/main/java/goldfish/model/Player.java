package goldfish.model;

import goldfish.model.pieces.King;
import goldfish.model.pieces.Queen;
import goldfish.model.pieces.Rook;
import goldfish.model.pieces.Bishop;
import goldfish.model.pieces.Knight;
import goldfish.model.pieces.Pawn;
import goldfish.model.pieces.Piece;

/**
 * The Player class represents a player in the game of chess
 * @author Goldfish
 */
public class Player {

    private Player opponent;

    private String color;

    private King king;
    private Queen queen;
    private Rook rooks[];
    private Bishop bishops[];
    private Knight knights[];
    private Pawn pawns[];
    private Piece nonKingPieces[];

    /**
     * Constructor for the player
     * @param color the color of the player
     * @param opponent the opponent of the player
     * @param king the king of the player
     * @param queen the queen of the player
     * @param rooks the rooks of the player
     * @param bishops the bishops of the player
     * @param knights the knights of the player
     * @param pawns the pawns of the player
     */
    public Player(String color, Player opponent,King king, Queen queen, Rook[] rooks, Bishop[] bishops, Knight[] knights, Pawn[] pawns) {
        this.color = color;
        this.opponent = opponent;
        this.king = king;
        this.king.setPlayer(this);
        this.queen = queen;
        this.queen.setPlayer(this);
        this.rooks = rooks;
        for (Rook rook : rooks) {
            rook.setPlayer(this);
        }
        this.bishops = bishops;
        for (Bishop bishop : bishops) {
            bishop.setPlayer(this);
        }
        this.knights = knights;
        for (Knight knight : knights) {
            knight.setPlayer(this);
        }
        this.pawns = pawns;
        for (Pawn pawn : pawns) {
            pawn.setPlayer(this);
        }
        this.nonKingPieces = new Piece[] {
            queen,
            rooks[0], rooks[1],
            bishops[0], bishops[1],
            knights[0], knights[1],
            pawns[0], pawns[1], pawns[2], pawns[3], pawns[4], pawns[5], pawns[6], pawns[7]
        };
    }

    /**
     * Get the color of the player
     * @return "w" if the player is white, "b" if the player is black
     */
    public String getColor() {
        return color;
    }

    /**
     * Return the player's king
     * @return return the player's king
     */
    public King getKing() {
        return king;
    }

    /**
     * Return the player's queen
     * @return return the player's queen
     */
    public Queen getQueen() {
        return queen;
    }

    /**
     * Return the player's rooks
     * @return {Rook 1 (starts on a1), Rook 2 (starts on h1)}
     */
    public Rook[] getRooks() {
        return rooks;
    }

    /**
     * Return the player's bishops
     * @return {Bishop 1 (starts on c1), Bishop 2 (starts on f1)}
     */
    public Bishop[] getBishops() {
        return bishops;
    }

    /**
     * Return the player's knights
     * @return {Knight 1 (starts on b1), Knight 2 (starts on g1)}
     */
    public Knight[] getKnights() {
        return knights;
    }

    /**
     * Return the player's pawns
     * @return {Pawn 1 (starts on a2), Pawn 2 (starts on b2), ..., Pawn 8 (starts on h2)}
     */
    public Pawn[] getPawns() {
        return pawns;
    }

    /**
     * Return the opponent of the player
     * @return The White player if called on the Black player, and vice versa
     */
    public Player getOpponent() {
        return opponent;
    }

    /**
     * Check if the player is in check (if the opponent's pieces can attack the player's king)
     * @return true if the player is in check, false otherwise
     */ 
    public boolean isCheck() {
        return opponent.isAttacking(king.getX(), king.getY());
    }

    /**
     * Check if the player is in checkmate (if the player is in check and cannot move out of check)
     * @return true if the player is in checkmate, false otherwise
     */ 
    public boolean isCheckmate() {
        // Check the 3x3 square around the king
        for (int x = king.getX() - 1; x <= king.getX() + 1; x++) {
            for (int y = king.getY() - 1; y <= king.getY() + 1; y++) {
                // Check if the square is on the board
                if (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    // Check if the king can move to the square
                    if (king.verifyMove(x, y)) {
                        // Check if the king is still in check
                        if (!opponent.isAttacking(x, y)) {
                            return false;
                        }
                    }
                }
            }
        }
        // Check if any other piece can move to any square on the board which will result in the king not being in check
        for (Piece piece : nonKingPieces) {
            for (int x = 0; x < 8; x++) {
                for (int y = 0; y < 8; y++) {
                    // Check if the piece can move to the square
                    if (piece.verifyMove(x, y)) {
                        Piece oldPiece = piece.getBoard().getPiece(x, y);
                        piece.getBoard().movePiece(piece.getX(), piece.getY(), x, y);
                        // Check if the king is still in check
                        if (!opponent.isAttacking(x, y)) {
                            piece.getBoard().getTiles()[y][x].setPiece(oldPiece);
                            return false;
                        }
                    }
                }
            }
        }

        // King is in checkmate if all valid moves are still in check
        return true;
    }

    /**
     * Check if the player is in stalemate (if the player is not in check and cannot move)
     * @param x the x coordinate of the square to check
     * @param y the y coordinate of the square to check
     * @return true if the player is in stalemate, false otherwise
     */
    public boolean isAttacking(int x, int y) {

        boolean kingAttacking = king.verifyMove(x, y);
        boolean queenAttacking = queen.verifyMove(x, y);
        boolean rookAttacking = rooks[0].verifyMove(x, y) || rooks[1].verifyMove(x, y);
        boolean bishopAttacking = bishops[0].verifyMove(x, y) || bishops[1].verifyMove(x, y);
        boolean knightAttacking = knights[0].verifyMove(x, y) || knights[1].verifyMove(x, y);
        boolean pawnAttacking = pawns[0].verifyMove(x, y) || pawns[1].verifyMove(x, y) || pawns[2].verifyMove(x, y) || pawns[3].verifyMove(x, y) || pawns[4].verifyMove(x, y) || pawns[5].verifyMove(x, y) || pawns[6].verifyMove(x, y) || pawns[7].verifyMove(x, y);

        return kingAttacking || queenAttacking || rookAttacking || bishopAttacking || knightAttacking || pawnAttacking;
    }
}

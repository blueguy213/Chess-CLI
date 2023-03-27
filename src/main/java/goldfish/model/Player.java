package goldfish.model;

import goldfish.model.pieces.King;
import goldfish.model.pieces.Queen;
import goldfish.model.pieces.Rook;
import goldfish.model.pieces.Bishop;
import goldfish.model.pieces.Knight;
import goldfish.model.pieces.Pawn;
import goldfish.model.pieces.Piece;

public class Player {

    private Player opponent;

    private String color;

    private King king;
    private Queen queen;
    private Rook rooks[];
    private Bishop bishops[];
    private Knight knights[];
    private Pawn pawns[];

    public Player(String color, Player opponent,King king, Queen queen, Rook[] rooks, Bishop[] bishops, Knight[] knights, Pawn[] pawns) {
        this.color = color;
        this.opponent = opponent;
        this.king = king;
        this.queen = queen;
        this.rooks = rooks;
        this.bishops = bishops;
        this.knights = knights;
        this.pawns = pawns;
    }

    public String getColor() {
        return color;
    }


    public King getKing() {
        return king;
    }

    public Rook[] getRooks() {
        return rooks;
    }

    public Bishop[] getBishops() {
        return bishops;
    }

    public Knight[] getKnights() {
        return knights;
    }

    public Pawn[] getPawns() {
        return pawns;
    }

    public Player getOpponent() {
        return opponent;
    }

    // Check if the player is in check (if the opponent's pieces can attack the player's king)
    public boolean check() {
        /*
        TODO: Implement check: Loop through opponent's pieces and check if they can attack the player's king (use verifyMove() by passing in the king's coordinates to each opponent piece)
        */ 
        return false;
    }

    // Check if the player is in checkmate (if the player is in check and cannot move out of check)
    public boolean checkmate() {
        // TODO: Implement checkmate
        return false;
    }

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

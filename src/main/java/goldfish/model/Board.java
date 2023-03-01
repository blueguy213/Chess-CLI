package goldfish.model;

import goldfish.model.pieces.Bishop;
import goldfish.model.pieces.King;
import goldfish.model.pieces.Knight;
import goldfish.model.pieces.Pawn;
import goldfish.model.pieces.Queen;
import goldfish.model.pieces.Rook;

public class Board {
    
    private Tile[][] board;

    public Board() {
        board = new Tile[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Tile();
                if (i == 1) {
                    board[i][j].setPiece(new Pawn("b"));
                } else if (i == 6) {
                    board[i][j].setPiece(new Pawn("w"));
                } else if (i == 0) {
                    if (j == 0 || j == 7) {
                        board[i][j].setPiece(new Rook("b"));
                    } else if (j == 1 || j == 6) {
                        board[i][j].setPiece(new Knight("b"));
                    } else if (j == 2 || j == 5) {
                        board[i][j].setPiece(new Bishop("b"));
                    } else if (j == 3) {
                        board[i][j].setPiece(new Queen("b"));
                    } else if (j == 4) {
                        board[i][j].setPiece(new King("b"));
                    }
                } else if (i == 7) {
                    if (j == 0 || j == 7) {
                        board[i][j].setPiece(new Rook("w"));
                    } else if (j == 1 || j == 6) {
                        board[i][j].setPiece(new Knight("w"));
                    } else if (j == 2 || j == 5) {
                        board[i][j].setPiece(new Bishop("w"));
                    } else if (j == 3) {
                        board[i][j].setPiece(new Queen("w"));
                    } else if (j == 4) {
                        board[i][j].setPiece(new King("w"));
                    }
                }
            }
        }
    }

    public Tile[][] getBoard() {
        return board;
    }

    public void movePiece(int x, int y, int newX, int newY) {
        board[newX][newY].setPiece(board[x][y].getPiece());
        board[x][y].setPiece(null);
    }

    @Override
    public String toString() {
        String boardString = "\n";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].isOccupied()) {
                    boardString += board[i][j].toString();
                } else {
                    if ((i + j) % 2 == 0) {
                        boardString += "  ";
                    } else {
                        boardString += "##";
                    }
                }
                boardString += " ";
            }
            boardString += Integer.toString(8 - i) + "\n";
        }
        boardString += " a  b  c  d  e  f  g  h\n\n";
        return boardString;
    }
}

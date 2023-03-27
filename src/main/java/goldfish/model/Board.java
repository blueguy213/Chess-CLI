package goldfish.model;

import goldfish.model.pieces.Bishop;
import goldfish.model.pieces.King;
import goldfish.model.pieces.Knight;
import goldfish.model.pieces.Pawn;
import goldfish.model.pieces.Queen;
import goldfish.model.pieces.Rook;

public class Board {
    
    // The board is a 2D array of tiles (each tile has a piece on it)
    private Tile[][] board;
    // The players
    private Player white;
    private Player black;
    // The turn (0 = white, 1 = black, -1 = game over)
    private int turn;
    

    public Board() {
        board = new Tile[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Tile();
                if (i == 1) {
                    board[i][j].setPiece(new Pawn("b", this));
                } else if (i == 6) {
                    board[i][j].setPiece(new Pawn("w", this));
                } else if (i == 0) {
                    if (j == 0 || j == 7) {
                        board[i][j].setPiece(new Rook("b", this));
                    } else if (j == 1 || j == 6) {
                        board[i][j].setPiece(new Knight("b", this));
                    } else if (j == 2 || j == 5) {
                        board[i][j].setPiece(new Bishop("b", this));
                    } else if (j == 3) {
                        board[i][j].setPiece(new Queen("b", this));
                    } else if (j == 4) {
                        board[i][j].setPiece(new King("b", this));
                    }
                } else if (i == 7) {
                    if (j == 0 || j == 7) {
                        board[i][j].setPiece(new Rook("w", this));
                    } else if (j == 1 || j == 6) {
                        board[i][j].setPiece(new Knight("w", this));
                    } else if (j == 2 || j == 5) {
                        board[i][j].setPiece(new Bishop("w", this));
                    } else if (j == 3) {
                        board[i][j].setPiece(new Queen("w", this));
                    } else if (j == 4) {
                        board[i][j].setPiece(new King("w", this));
                    }
                }
            }
        }

        // Instantiate players using pieces from board
        white = new Player(
            "w",
            black,
            (King) board[7][4].getPiece(), 
            (Queen) board[7][3].getPiece(),
            new Rook[] { (Rook) board[7][0].getPiece(), (Rook) board[7][7].getPiece() },
            new Bishop[] { (Bishop) board[7][2].getPiece(), (Bishop) board[7][5].getPiece() },
            new Knight[] { (Knight) board[7][1].getPiece(), (Knight) board[7][6].getPiece() },
            new Pawn[] { 
                (Pawn) board[6][0].getPiece(),
                (Pawn) board[6][1].getPiece(),
                (Pawn) board[6][2].getPiece(),
                (Pawn) board[6][3].getPiece(),
                (Pawn) board[6][4].getPiece(),
                (Pawn) board[6][5].getPiece(),
                (Pawn) board[6][6].getPiece(),
                (Pawn) board[6][7].getPiece()
            }
        );

        black = new Player(
            "b",
            white,
            (King) board[0][4].getPiece(), 
            (Queen) board[0][3].getPiece(),
            new Rook[] { (Rook) board[0][0].getPiece(), (Rook) board[0][7].getPiece() },
            new Bishop[] { (Bishop) board[0][2].getPiece(), (Bishop) board[0][5].getPiece() },
            new Knight[] { (Knight) board[0][1].getPiece(), (Knight) board[0][6].getPiece() },
            new Pawn[] { 
                (Pawn) board[1][0].getPiece(),
                (Pawn) board[1][1].getPiece(),
                (Pawn) board[1][2].getPiece(),
                (Pawn) board[1][3].getPiece(),
                (Pawn) board[1][4].getPiece(),
                (Pawn) board[1][5].getPiece(),
                (Pawn) board[1][6].getPiece(),
                (Pawn) board[1][7].getPiece()
            }
        );
        // Set turn to white
        turn = 0;
    }

    /** 
     * @return Tile[][]
     */
    public Tile[][] getBoard() {
        return board;
    }

    // Move the piece at (x, y) to (newX, newY)
    public void movePiece(int x, int y, int newX, int newY) {
        board[newY][newX].setPiece(board[y][x].getPiece());
        board[y][x].setPiece(null);
    }

    /**
     * Prints the board in the format described in the assignment
     * bR bN bB bQ bK bB bN bR 8
     * bp bp bp bp bp bp bp bp 7
     *    ##    ##    ##    ## 6
     * ##    ##    ##    ##    5
     *    ##    ##    ##    ## 4
     * ##    ##    ##    ##    3 
     * wp wp wp wp wp wp wp wp 2
     * wR wN wB wQ wK wB wN wR 1
     *  a  b  c  d  e  f  g  h
* @return String
     */
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

    
    public Player getWhite() {
        return white;
    }

    public Player getBlack() {
        return black;
    }

    public int getTurn() {
        return turn;
    }

    /**
     * Check if the tile at (x, y) is occupied and return 1 if white, 2 if black, 0 if not occupied
     * @param x
     * @param y
     * @return 
     */
    public int checkOccupied(int x, int y) {
        if (board[y][x].isOccupied()) {
            if (board[y][x].getPiece().getColor().equals("w")) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }
}

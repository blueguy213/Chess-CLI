package goldfish.model;

import goldfish.model.pieces.Bishop;
import goldfish.model.pieces.King;
import goldfish.model.pieces.Knight;
import goldfish.model.pieces.Pawn;
import goldfish.model.pieces.Piece;
import goldfish.model.pieces.Queen;
import goldfish.model.pieces.Rook;

/**
 * The board class: Has a 2D array of tiles, two players (white and black), and a turn.
 * @author Goldfish
 */
public class Board {
    
    // The tiles is a 2D array of tiles (each tile has a piece on it)
    private Tile[][] tiles;
    // The players
    private Player white;
    private Player black;
    // The turn (0 = white, 1 = black, -1 = game over)
    private int turn;
    
    /**
     * Constructor for the tiles
     * Creates the tiles and sets up the pieces
     */
    public Board() {
        tiles = new Tile[8][8];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = new Tile(j, i);
                if (i == 1) {
                    tiles[i][j].setPiece(new Pawn("b", this));
                } else if (i == 6) {
                    tiles[i][j].setPiece(new Pawn("w", this));
                } else if (i == 0) {
                    if (j == 0 || j == 7) {
                        tiles[i][j].setPiece(new Rook("b", this));
                    } else if (j == 1 || j == 6) {
                        tiles[i][j].setPiece(new Knight("b", this));
                    } else if (j == 2 || j == 5) {
                        tiles[i][j].setPiece(new Bishop("b", this));
                    } else if (j == 3) {
                        tiles[i][j].setPiece(new Queen("b", this));
                    } else if (j == 4) {
                        tiles[i][j].setPiece(new King("b", this));
                    }
                } else if (i == 7) {
                    if (j == 0 || j == 7) {
                        tiles[i][j].setPiece(new Rook("w", this));
                    } else if (j == 1 || j == 6) {
                        tiles[i][j].setPiece(new Knight("w", this));
                    } else if (j == 2 || j == 5) {
                        tiles[i][j].setPiece(new Bishop("w", this));
                    } else if (j == 3) {
                        tiles[i][j].setPiece(new Queen("w", this));
                    } else if (j == 4) {
                        tiles[i][j].setPiece(new King("w", this));
                    }
                }
            }
        }

        // Instantiate players using pieces from tiles
        white = new Player(
            "w",
            black,
            (King) tiles[7][4].getPiece(), 
            (Queen) tiles[7][3].getPiece(),
            new Rook[] { (Rook) tiles[7][0].getPiece(), (Rook) tiles[7][7].getPiece() },
            new Bishop[] { (Bishop) tiles[7][2].getPiece(), (Bishop) tiles[7][5].getPiece() },
            new Knight[] { (Knight) tiles[7][1].getPiece(), (Knight) tiles[7][6].getPiece() },
            new Pawn[] { 
                (Pawn) tiles[6][0].getPiece(),
                (Pawn) tiles[6][1].getPiece(),
                (Pawn) tiles[6][2].getPiece(),
                (Pawn) tiles[6][3].getPiece(),
                (Pawn) tiles[6][4].getPiece(),
                (Pawn) tiles[6][5].getPiece(),
                (Pawn) tiles[6][6].getPiece(),
                (Pawn) tiles[6][7].getPiece()
            }
        );

        black = new Player(
            "b",
            white,
            (King) tiles[0][4].getPiece(), 
            (Queen) tiles[0][3].getPiece(),
            new Rook[] { (Rook) tiles[0][0].getPiece(), (Rook) tiles[0][7].getPiece() },
            new Bishop[] { (Bishop) tiles[0][2].getPiece(), (Bishop) tiles[0][5].getPiece() },
            new Knight[] { (Knight) tiles[0][1].getPiece(), (Knight) tiles[0][6].getPiece() },
            new Pawn[] { 
                (Pawn) tiles[1][0].getPiece(),
                (Pawn) tiles[1][1].getPiece(),
                (Pawn) tiles[1][2].getPiece(),
                (Pawn) tiles[1][3].getPiece(),
                (Pawn) tiles[1][4].getPiece(),
                (Pawn) tiles[1][5].getPiece(),
                (Pawn) tiles[1][6].getPiece(),
                (Pawn) tiles[1][7].getPiece()
            }
        );
        // Set turn to white
        turn = 0;
    }

    /** 
     * Gets the 2D array of tiles the board has
     * @return Tile[][]
     */
    public Tile[][] getTiles() {
        return tiles;
    }


    /**
     * Move the piece at (x, y) to (newX, newY)
     * @return Player
     */
    public void movePiece(int x, int y, int newX, int newY) {
        boolean isPieceNotifiedByMovement = tiles[y][x].getPiece().toString().charAt(1) == 'p' || tiles[y][x].getPiece().toString().charAt(1) == 'K' || tiles[y][x].getPiece().toString().charAt(1) == 'R';
        if (isPieceNotifiedByMovement) {
            tiles[y][x].getPiece().movement();;
        }
        tiles[newY][newX].setPiece(tiles[y][x].getPiece());
        tiles[y][x].setPiece(null);
        incrementTurn();
    }

    /**
     * Overrides toString to pring the board with the tiles and pieces in the format described by the assignment
     * @return String
     */
    @Override
    public String toString() {
        String tilesString = "\n";
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j].isOccupied()) {
                    tilesString += tiles[i][j].toString();
                } else {
                    if ((i + j) % 2 == 0) {
                        tilesString += "  ";
                    } else {
                        tilesString += "##";
                    }
                }
                tilesString += " ";
            }
            tilesString += Integer.toString(8 - i) + "\n";
        }
        tilesString += " a  b  c  d  e  f  g  h\n\n";
        return tilesString;
    }

    /**
     * Gets the white player object for the board
     * @return White Player
     */
    public Player getWhite() {
        return white;
    }

    /**
     * Gets the black player object for the board
     * @return Black Player
     */
    public Player getBlack() {
        return black;
    }

    /**
     * Gets the current turn
     * @return 0 if white, 1 if black
     */
    public int getTurn() {
        return turn;
    }

    /**
     * Check if the tile at (x, y) is occupied and by whom
     * @param x x location of the tile
     * @param y y location of the tile
     * @return 1 if white, 2 if black, 0 if not occupied
     */
    public int isOccupied(int x, int y) {
        if (tiles[y][x].isOccupied()) {
            if (tiles[y][x].getPiece().getColor().equals("w")) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    /**
     * Gets the piece at a given location from the tiles array
     * @param x x location of the desired piece
     * @param y y location of the desired piece
     * @return The piece at (x, y)
     */
    public Piece getPiece(int x, int y) {
        return tiles[y][x].getPiece();
    }

    /**
     * Flips turn from white to black or vice versa
     */
    public void incrementTurn() {
        turn = (turn + 1) % 2;
    }

    /**
     * Ends the game by setting turn to -1 as a signal for the game loop to end
     */
    public void gameOver() {
        turn = -1;
    }
}

package goldfish.chess;

import goldfish.model.Board;
import goldfish.model.Player;

/**
 * The Chess class represents the game of chess.
 * @author Sree Kommalapati and Shreeti Patel
 */
public class Chess {

    // Set up game variables
    public static Board board = new Board();
    public static boolean gameRunning = true;
    public static Player currentPlayer = board.getWhite();
    public static int src_x, src_y, dest_x, dest_y;
    public static String promotionType;

    public static void parseInput(String input) {            
        // Tokenize input to see how many tokens there are
        String[] tokens = input.split(" ");

        if (tokens.length == 1) { //must be draw or draw? or resign
            System.out.println("Draw not implemented yet.");
        }
        
        // Convert input to internal units
        src_x = tokens[0].charAt(0) - 'a';
        src_y = 7 - (tokens[0].charAt(1) - '1');
        dest_x = tokens[1].charAt(0) - 'a';
        dest_y = 7 - (tokens[1].charAt(1) - '1');

        if (tokens.length == 3) {
            promotionType = tokens[2];
        }
    }

    /**
     * Checks if the move is invalid.
     * 
     * @return
     */
    public static boolean isValidMove() {
        if (board.getTiles()[src_y][src_x].getPiece() != null
        && board.getTiles()[src_y][src_x].getPiece().getColor().equals(currentPlayer.getColor())
        && board.getTiles()[src_y][src_x].getPiece().verifyMove(dest_x, dest_y, true)) {
            return true;
        } else {
            System.out.println("Illegal move, try again");
            return false;
        }
    }

    public static void runGame() {

        // Print the starting board
        System.out.print(board);

        while (gameRunning) {

            do {
                // Prompt player for input
                if (board.getTurn() == 0) {
                    System.out.print("White's move: ");
                } else {
                    System.out.print("Black's move: ");
                }
                // Get input
                String input = System.console().readLine();
                // Parse input into internal units
                parseInput(input);
            } while (!isValidMove()); // Loop until valid input is given

            // Move piece
            board.movePiece(src_x, src_y, dest_x, dest_y);
            board.incrementTurn();

            // Draw board
            System.out.print(board);

            // Check white for checkmate if black just moved and vice versa
            if (board.getTurn() % 2 == 0) {
                currentPlayer = board.getWhite();
                if (board.getWhite().isCheckmate()) {
                    System.out.println("Checkmate\nBlack wins");
                    gameRunning = false;
                } else if (board.getWhite().isCheck()) {
                    System.out.println("Check");
                }
            } else {
                currentPlayer = board.getBlack();
                if (board.getBlack().isCheckmate()) {
                    System.out.println("Checkmate\nWhite wins");
                    gameRunning = false;
                } else if (board.getBlack().isCheck()) {
                    System.out.println("Check");
                }
            }
        }
    }
    

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
       runGame();
    }
}
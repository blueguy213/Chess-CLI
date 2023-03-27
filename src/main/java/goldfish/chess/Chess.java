package goldfish.chess;

import goldfish.model.Board;
import goldfish.model.Player;

public class Chess {

    // Set up game variables
    static Board board = new Board();
    static boolean gameRunning = true;
    static Player currentPlayer = board.getWhite();
    static int src_x, src_y, dest_x, dest_y;
    static String promotionType;

    public static void parseInput(String input) {            
        // Tokenize input to see how many tokens there are
        String[] tokens = input.split(" ");

        if (tokens.length == 1) {
            System.out.println("Draw not implemented yet.");
        }
        
        // Convert input to internal units
        src_x = tokens[0].charAt(0) - 'a';
        src_y = tokens[0].charAt(1) - '1';
        dest_x = tokens[1].charAt(0) - 'a';
        dest_y = tokens[1].charAt(1) - '1';

        if (tokens.length == 3) {
            promotionType = tokens[2];
        }
    }

    private static boolean isInvalidMove() {
        return board.getTiles()[src_y][src_x].getPiece() == null
        || board.getTiles()[src_y][src_x].getPiece().getColor().equals(currentPlayer.getColor())
        || !board.getTiles()[src_y][src_x].getPiece().verifyMove(dest_y, dest_x);
    }

    public static void runGame() {
        while (gameRunning) {

            // Draw board
            System.out.print(board);

            // Input verification loop
            do {
                // Prompt user
                if (board.getTurn() % 2 == 0) {
                    System.out.print("White's move: ");
                } else {
                    System.out.print("Black's move: ");
                }
                String input = System.console().readLine();
                parseInput(input);

                System.err.println("src_x: " + src_x + " src_y: " + src_y + " dest_x: " + dest_x + " dest_y: " + dest_y);
                System.err.println(board.getTiles()[src_y][src_x].getPiece() == null);
                System.err.println(board.getTiles()[src_y][src_x].getPiece().getColor().equals(currentPlayer.getColor()));
                System.err.println(!board.getTiles()[src_y][src_x].getPiece().verifyMove(dest_y, dest_x));

        

                if (isInvalidMove()) {
                    System.out.println("Illegal move, try again");
                }

            } while (
                board.getTiles()[src_y][src_x].getPiece() == null
                || board.getTiles()[src_y][src_x].getPiece().getColor().equals(currentPlayer.getColor())
                || !board.getTiles()[src_y][src_x].getPiece().verifyMove(dest_y, dest_x)
            );

            // Move piece
            board.movePiece(src_x, src_y, dest_x, dest_y);
            board.incrementTurn();

            // Check white for checkmate if black just moved and vice versa
            if (board.getTurn() % 2 == 0) {
                currentPlayer = board.getWhite();
                if (board.getWhite().isCheckmate()) {
                    System.out.println("Checkmate! Black wins!");
                    gameRunning = false;
                }
            } else {
                currentPlayer = board.getBlack();
                if (board.getBlack().isCheckmate()) {
                    System.out.println("Checkmate! White wins!");
                    gameRunning = false;
                }
            }
        }
        //input varification 

        //draw feature

        //game loop

        //input output

        //convert input to internal units (x,y both 0 - 7) (a)
    }
    

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
       runGame();
    }
}
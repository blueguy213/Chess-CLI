package goldfish.chess;

import goldfish.model.Board;
import goldfish.model.Player;
import goldfish.model.pieces.Piece;
import goldfish.model.pieces.Queen;
import goldfish.model.pieces.Rook;
import goldfish.model.pieces.Bishop;
import goldfish.model.pieces.Knight;
import goldfish.model.pieces.Pawn;

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
    public static boolean drawOffered = false;
    public static boolean drawDeclined = false;

    public static void parseInput(String input) {            
        // Tokenize input to see how many tokens there are
        String[] tokens = input.split(" ");

        if(drawOffered) { //draw was offered
            if (tokens[0].equals("draw")){ //draw was accepted
                gameRunning = false;
                return;
            } 
            else{
                drawDeclined = true;
                return;
            }
        }
        if (tokens[tokens.length-1].equals("draw?")) { // if last token is draw?
            drawOffered = true;
            return;
         }
         
         if(tokens[0].equals("resign")){ //if resign
            if(currentPlayer.getColor().equals("b")){
                System.out.println("White wins");
            }
            if(currentPlayer.getColor().equals("w")){
                System.out.println("Black wins");
            }
            gameRunning = false;
            return;
         }
        

        // Convert input to internal units
        if (tokens.length>1){
            src_x = tokens[0].charAt(0) - 'a';
            src_y = 7 - (tokens[0].charAt(1) - '1');
            dest_x = tokens[1].charAt(0) - 'a';
            dest_y = 7 - (tokens[1].charAt(1) - '1');
        }
    

        if (tokens.length == 3) {
            promotionType = tokens[2];

            Piece pawnReplacement = null;

            if (promotionType.equals("Q")) {
                pawnReplacement = new Queen("Q", board);
            } else if (promotionType.equals("R")) {
                pawnReplacement = new Rook("R", board);
            } else if (promotionType.equals("B")) {
                pawnReplacement = new Bishop("B", board);
            } else if (promotionType.equals("N")) {
                pawnReplacement = new Knight("N", board);
            }

            if (board.getPiece(src_x, src_y) instanceof Pawn && board.getTiles()[src_y][src_x].getPiece().verifyMove(dest_x, dest_y, true)) {
                board.promote(src_x, src_y, pawnReplacement);
            }
        }
    }

    /**
     * Checks if the move is invalid.
     * 
     * @return
     */
    public static boolean isValidMove() {
       
        if (drawDeclined){
            return false;
        } if (drawOffered){
            return true;
        }
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
            } while ((gameRunning)&&(!isValidMove())); // Loop until valid input is given draw is offered, or game is being 

            if((!gameRunning) || (drawOffered)){ 
                board.incrementTurn();
                continue;
            }    
            // Move piece
            board.movePiece(src_x, src_y, dest_x, dest_y);
            board.incrementTurn();

            // Draw board
            System.out.print(board);

            // Check white for checkmate if black just moved and vice versa
            if (board.getTurn() % 2 == 0) {
                currentPlayer = board.getWhite();
                if (board.getWhite().isCheck()) {
                    if (board.getWhite().isCheckmate()) {
                        System.out.println("Checkmate\nBlack wins");
                        gameRunning = false;
                        continue;
                    }
                    System.out.println("Check");
                    continue;
                }
            } else {
                currentPlayer = board.getBlack();
                if (board.getBlack().isCheck()) {
                    if (board.getBlack().isCheckmate()) {
                        System.out.println("Checkmate\nWhite wins");
                        gameRunning = false;
                    }
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
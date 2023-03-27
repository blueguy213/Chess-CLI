package goldfish.units;

import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

import goldfish.model.Board;
import goldfish.model.Player;
import goldfish.chess.Chess;

/**
 * Ensures the starting board is set up and printed properly for Chess
 */
public class GameLoopTests {


    public static String runTestGame(Scanner testInput) {

            // Set up game variables
        Board board = new Board();
        boolean gameRunning = true;
        Player currentPlayer = board.getWhite();
        int src_x = 0, src_y = 0, dest_x = 0, dest_y = 0;
        String promotionType;

        String testOutput = "";

        // Print the starting board
        testOutput += board;

        while (gameRunning && testInput.hasNextLine()) {
            do {
                // Prompt player for input
                if (board.getTurn() == 0) {
                    testOutput += "White's move: ";
                } else {
                    testOutput += "Black's move: ";
                }
                // Get input
                String input = testInput.nextLine();
                // Parse input into internal units
                Chess.parseInput(input);
            } while (!Chess.isValidMove()); // Loop until valid input is given

            // Move piece
            board.movePiece(src_x, src_y, dest_x, dest_y);

            // Draw board
            testOutput += board;

            // Check white for checkmate if black just moved and vice versa
            if (board.getTurn() % 2 == 0) {
                currentPlayer = board.getWhite();
                if (board.getWhite().isCheckmate()) {
                    testOutput += "Checkmate\nBlack wins";
                    gameRunning = false;
                } else if (board.getWhite().isCheck()) {
                    testOutput += "Check";
                }
            } else {
                currentPlayer = board.getBlack();
                if (board.getBlack().isCheckmate()) {
                    testOutput += "Checkmate\nWhite wins";
                    gameRunning = false;
                } else if (board.getBlack().isCheck()) {
                    testOutput += "Check";
                }
            }
        }

        return testOutput;
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testFirstEntry() {
        String testInput = "";

        String expectedOutput = """

bR bN bB bQ bK bB bN bR 8
bp bp bp bp bp bp bp bp 7
   ##    ##    ##    ## 6
##    ##    ##    ##    5
   ##    ##    ##    ## 4
##    ##    ##    ##    3 
wp wp wp wp wp wp wp wp 2
wR wN wB wQ wK wB wN wR 1
 a  b  c  d  e  f  g  h

White's move: 
""";

        Scanner testScanner = new Scanner(testInput);
        String testOutput = runTestGame(testScanner);

        assertEquals(expectedOutput, testOutput);
    }

}
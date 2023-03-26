package goldfish.units;

import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

import org.junit.Test;

import goldfish.model.Board;

/**
 * Ensures the starting board is set up and printed properly for Chess.
 */
public class StartingBoardTests {
    /**
     * Rigorous Test :-)
     */

     
    @Test
    public void printStartingBoard() {

        String correctStartingBoard = """

bR bN bB bQ bK bB bN bR 8
bp bp bp bp bp bp bp bp 7
   ##    ##    ##    ## 6
##    ##    ##    ##    5
   ##    ##    ##    ## 4
##    ##    ##    ##    3
wp wp wp wp wp wp wp wp 2
wR wN wB wQ wK wB wN wR 1
 a  b  c  d  e  f  g  h

""";
        Board startingBoard = new Board();
        System.out.println("Hello World!");
        
        // Check if the starting board is correct
        assertEquals(startingBoard.toString(), correctStartingBoard);
    }
}
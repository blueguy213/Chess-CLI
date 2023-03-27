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
     * Rigorous Tests :-)
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
        // Check if the starting board is correct
        assertEquals(startingBoard.toString(), correctStartingBoard);
    }

    @Test
    public void checkPiecePlacement() {
        Board startingBoard = new Board();
        
        // Check if the black pieces are stored in the correct Tiles using getTiles() method
        assertEquals(startingBoard.getTiles()[0][0].getPiece(), startingBoard.getBlack().getRooks()[0]);
        assertEquals(startingBoard.getTiles()[0][1].getPiece(), startingBoard.getBlack().getKnights()[0]);
        assertEquals(startingBoard.getTiles()[0][2].getPiece(), startingBoard.getBlack().getBishops()[0]);
        assertEquals(startingBoard.getTiles()[0][3].getPiece(), startingBoard.getBlack().getQueen());
        assertEquals(startingBoard.getTiles()[0][4].getPiece(), startingBoard.getBlack().getKing());
        assertEquals(startingBoard.getTiles()[0][5].getPiece(), startingBoard.getBlack().getBishops()[1]);
        assertEquals(startingBoard.getTiles()[0][6].getPiece(), startingBoard.getBlack().getKnights()[1]);
        assertEquals(startingBoard.getTiles()[0][7].getPiece(), startingBoard.getBlack().getRooks()[1]);
        assertEquals(startingBoard.getTiles()[1][0].getPiece(), startingBoard.getBlack().getPawns()[0]);
        assertEquals(startingBoard.getTiles()[1][1].getPiece(), startingBoard.getBlack().getPawns()[1]);
        assertEquals(startingBoard.getTiles()[1][2].getPiece(), startingBoard.getBlack().getPawns()[2]);
        assertEquals(startingBoard.getTiles()[1][3].getPiece(), startingBoard.getBlack().getPawns()[3]);
        assertEquals(startingBoard.getTiles()[1][4].getPiece(), startingBoard.getBlack().getPawns()[4]);
        assertEquals(startingBoard.getTiles()[1][5].getPiece(), startingBoard.getBlack().getPawns()[5]);
        assertEquals(startingBoard.getTiles()[1][6].getPiece(), startingBoard.getBlack().getPawns()[6]);
        assertEquals(startingBoard.getTiles()[1][7].getPiece(), startingBoard.getBlack().getPawns()[7]);

        // Check if the white pieces are stored in the correct Tiles using getTiles() method
        assertEquals(startingBoard.getTiles()[7][0].getPiece(), startingBoard.getWhite().getRooks()[0]);
        assertEquals(startingBoard.getTiles()[7][1].getPiece(), startingBoard.getWhite().getKnights()[0]);
        assertEquals(startingBoard.getTiles()[7][2].getPiece(), startingBoard.getWhite().getBishops()[0]);
        assertEquals(startingBoard.getTiles()[7][3].getPiece(), startingBoard.getWhite().getQueen());
        assertEquals(startingBoard.getTiles()[7][4].getPiece(), startingBoard.getWhite().getKing());
        assertEquals(startingBoard.getTiles()[7][5].getPiece(), startingBoard.getWhite().getBishops()[1]);
        assertEquals(startingBoard.getTiles()[7][6].getPiece(), startingBoard.getWhite().getKnights()[1]);
        assertEquals(startingBoard.getTiles()[7][7].getPiece(), startingBoard.getWhite().getRooks()[1]);
        assertEquals(startingBoard.getTiles()[6][0].getPiece(), startingBoard.getWhite().getPawns()[0]);
        assertEquals(startingBoard.getTiles()[6][1].getPiece(), startingBoard.getWhite().getPawns()[1]);
        assertEquals(startingBoard.getTiles()[6][2].getPiece(), startingBoard.getWhite().getPawns()[2]);
        assertEquals(startingBoard.getTiles()[6][3].getPiece(), startingBoard.getWhite().getPawns()[3]);
        assertEquals(startingBoard.getTiles()[6][4].getPiece(), startingBoard.getWhite().getPawns()[4]);
        assertEquals(startingBoard.getTiles()[6][5].getPiece(), startingBoard.getWhite().getPawns()[5]);
        assertEquals(startingBoard.getTiles()[6][6].getPiece(), startingBoard.getWhite().getPawns()[6]);
        assertEquals(startingBoard.getTiles()[6][7].getPiece(), startingBoard.getWhite().getPawns()[7]);
    }
}
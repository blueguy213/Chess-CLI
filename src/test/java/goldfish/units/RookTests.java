package goldfish.units;

import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

import org.junit.Test;

import goldfish.model.Board;
import goldfish.model.pieces.Rook;

/**
 * Ensures the starting board is set up and printed properly for Chess.
 */
public class RookTests {
    /**
     * Rigorous Test :-)
     */

     
    @Test
    public void diagonalMove() {

//    0  1  2  3  4  5  6  7 
// 0  bR bN bB bQ bK bB bN bR 8
// 1  bp bp bp bp bp bp bp bp 7
// 2     ##    ##    ##    ## 6
// 3  ##    ##    ##    ##    5
// 4     ##    ##    ##    ## 4
// 5  ##    ##    ##    ##    3 
// 6  wp wp wp wp wp wp wp wp 2
// 7  wR wN wB wQ wK wB wN wR 1
//     a  b  c  d  e  f  g  h

        // Setup starting board
        Board startingBoard = new Board();
        Rook testRook = new Rook("t", startingBoard);
        
        // // Clear pieces out of the way
        // startingBoard.getBoard()[6][7].setPiece(null);
        // startingBoard.getBoard()[6][6].setPiece(null);
        // startingBoard.getBoard()[7][6].setPiece(null);
        startingBoard.getTiles()[4][3].setPiece(testRook);


        //    0  1  2  3  4  5  6  7 
        // 0  bR bN bB bQ bK bB bN bR 8
        // 1  bp bp bp bp bp bp bp bp 7
        // 2     ##    ##    ##    ## 6
        // 3  ##    ##    ##    ##    5
        // 4     ##    tR    ##    ## 4
        // 5  ##    ##    ##    ##    3 
        // 6  wp wp wp wp wp wp    ## 2
        // 7  wR wN wB wQ wK wB ## wR 1
        //     a  b  c  d  e  f  g  h


        System.out.print(startingBoard.toString());
       // assertEquals(startingBoard.getWhite().getRooks()[1].verifyMove(5, 5), false);



        assertEquals(testRook.verifyMove(2, 1, false), false);
        assertEquals(testRook.verifyMove(3, 4, false), false);
        assertEquals(testRook.verifyMove(4, 5, false), false);
        assertEquals(testRook.verifyMove(5, 2, false), false);
       

        
    }

    @Test
    public void verticalMove() {

//    0  1  2  3  4  5  6  7 
// 0  bR bN bB bQ bK bB bN bR 8
// 1  bp bp bp bp bp bp bp bp 7
// 2     ##    ##    ##    ## 6
// 3  ##    ##    ##    ##    5
// 4     ##    ##    ##    ## 4
// 5  ##    ##    ##    ##    3 
// 6  wp wp wp wp wp wp wp wp 2
// 7  wR wN wB wQ wK wB wN wR 1
//     a  b  c  d  e  f  g  h

        // Setup starting board
        Board startingBoard = new Board();
        Rook testRook = new Rook("t", startingBoard);
        
        // Clear pieces out of the way
        // startingBoard.getBoard()[6][7].setPiece(null);
        // startingBoard.getBoard()[6][6].setPiece(null);
        // startingBoard.getBoard()[7][6].setPiece(null);
        startingBoard.getTiles()[4][3].setPiece(testRook);
        

//    0  1  2  3  4  5  6  7 
// 0  bR bN bB bQ bK bB bN bR 8
// 1  bp bp bp bp bp bp bp bp 7
// 2     ##    ##    ##    ## 6
// 3  ##    ##    ##    ##    5
// 4     ##    tR    ##    ## 4
// 5  ##    ##    ##    ##    3 
// 6  wp wp wp wp wp wp    ## 2
// 7  wR wN wB wQ wK wB ## wR 1
//     a  b  c  d  e  f  g  h


        System.out.print(startingBoard.toString());
        //assertEquals(startingBoard.getWhite().getRooks()[1].verifyMove(5, 5), false);


        System.out.println("X is " + testRook.getX() + " , Y is " + testRook.getY());
        assertEquals(testRook.verifyMove(3,2, false),true);
        assertEquals(testRook.verifyMove(3,5, false),true);
        assertEquals(testRook.verifyMove(6,4, false),true);
        assertEquals(testRook.verifyMove(1,4, false),true);
        
    
    }
    @Test
    public void pieceInWay() {

//    0  1  2  3  4  5  6  7 
// 0  bR bN bB bQ bK bB bN bR 8
// 1  bp bp bp bp bp bp bp bp 7
// 2     ##    ##    ##    ## 6
// 3  ##    ##    ##    ##    5
// 4     ##    tR    ##    ## 4
// 5  ##    ##    ##    ##    3 
// 6  wp wp wp wp wp wp    ## 2
// 7  wR wN wB wQ wK wB ## wR 1
//     a  b  c  d  e  f  g  h

        // Setup starting board
        Board startingBoard = new Board();
        Rook testRook = new Rook("t", startingBoard);
        startingBoard.getTiles()[4][3].setPiece(testRook);
        startingBoard.movePiece(4,6,4,4, true);
        startingBoard.movePiece(2,1,2,4, true);
    


        System.out.print(startingBoard.toString());
       

        System.out.println("X is " + testRook.getX() + " , Y is " + testRook.getY());
        assertEquals(testRook.verifyMove(3,0, false),false);
        assertEquals(testRook.verifyMove(3,6, false),false);
        assertEquals(testRook.verifyMove(6,4, false),false);
        assertEquals(testRook.verifyMove(0,4, false),false);
        
    
    }

}
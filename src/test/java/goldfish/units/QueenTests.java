package goldfish.units;

import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

import org.junit.Test;

import goldfish.model.Board;
import goldfish.model.pieces.Queen;


/**
 * Ensures the starting board is set up and printed properly for Chess.
 */
public class QueenTests {
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
        Queen testQueen = new Queen("t", startingBoard);
        startingBoard.getTiles()[4][3].setPiece(testQueen);
       
        
     
//    0  1  2  3  4  5  6  7 
// 0  bR bN bB bQ bK bB bN bR 8
// 1  bp bp bp bp bp bp bp bp 7
// 2     ##    ##    ##    ## 6
// 3  ##    ##    ##    ##    5
// 4     ##    tQ    ##    ## 4
// 5  ##    ##    ##    ##    3 
// 6  wp wp wp wp wp wp    ## 2
// 7  wR wN wB wQ wK wB ## wR 1
//     a  b  c  d  e  f  g  h


        System.out.print(startingBoard.toString());
       //assertEquals(startingBoard.getWhite().getRooks()[1].verifyMove(5, 5), false);

        assertEquals(testQueen.verifyMove(2,1),false);
        assertEquals(testQueen.verifyMove(3,4),true);
        assertEquals(testQueen.verifyMove(5,4),true);
        assertEquals(testQueen.verifyMove(5,2),true);
       

        
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
        Queen testQueen = new Queen("t", startingBoard);
        startingBoard.getTiles()[4][3].setPiece(testQueen);
       
//    0  1  2  3  4  5  6  7 
// 0  bR bN bB bQ bK bB bN bR 8
// 1  bp bp bp bp bp bp bp bp 7
// 2     ##    ##    ##    ## 6
// 3  ##    ##    ##    ##    5
// 4     ##    tQ    ##    ## 4
// 5  ##    ##    ##    ##    3 
// 6  wp wp wp wp wp wp    ## 2
// 7  wR wN wB wQ wK wB ## wR 1
//     a  b  c  d  e  f  g  h


        System.out.print(startingBoard.toString());
        //assertEquals(startingBoard.getWhite().getRooks()[1].verifyMove(5, 5), false);



        assertEquals(testQueen.verifyMove(3,3),true);
        assertEquals(testQueen.verifyMove(5,3),true);
        assertEquals(testQueen.verifyMove(4,6),true);
        assertEquals(testQueen.verifyMove(4,1),true);
    
    
        
    }


}
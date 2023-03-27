package goldfish.units;

import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertTrue;

import org.junit.Test;

import goldfish.model.Board;
import goldfish.model.pieces.Knight;


/**
 * Ensures the starting board is set up and printed properly for Chess.
 */
public class KnightTests {
    /**
     * Rigorous Test :-)
     */

     
     @Test
     public void diagonalMove() {
       // Setup starting board
        Board startingBoard = new Board();
        Knight testKnight = new Knight("t", startingBoard);
         
        startingBoard.getTiles()[4][3].setPiece(testKnight);
 
 
         //    0  1  2  3  4  5  6  7 
         // 0  bR bN bB bQ bK bB bN bR 8
         // 1  bp bp bp bp bp bp bp bp 7
         // 2     ##    ##    ##    ## 6
         // 3  ##    ##    ##    ##    5
         // 4     ##    tB    ##    ## 4
         // 5  ##    ##    ##    ##    3 
         // 6  wp wp wp wp wp wp    ## 2
         // 7  wR wN wB wQ wK wB ## wR 1
         //     a  b  c  d  e  f  g  h
 
 
         System.out.print(startingBoard.toString());
      
 
         assertEquals(testKnight.verifyMove(1, 2), false);
         assertEquals(testKnight.verifyMove(4, 3), false);
         assertEquals(testKnight.verifyMove(4, 5), false);
         assertEquals(testKnight.verifyMove(2, 5), false);
        
 
         
     }
 
     @Test
     public void verticalMove() {
 

         // Setup starting board
         Board startingBoard = new Board();
         Knight testKnight = new Knight("t", startingBoard);
         
         // Clear pieces out of the way
         // startingBoard.getBoard()[6][7].setPiece(null);
         // startingBoard.getBoard()[6][6].setPiece(null);
         // startingBoard.getBoard()[7][6].setPiece(null);
         startingBoard.getTiles()[4][3].setPiece(testKnight);
         
 
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
         //assertEquals(startingBoard.getWhite().getKnights()[1].verifyMove(5, 5), false);
 
 
         System.out.println("X is " + testKnight.getX() + " , Y is " + testKnight.getY());
         assertEquals(testKnight.verifyMove(3,2),false);
         assertEquals(testKnight.verifyMove(3,5),false);
         assertEquals(testKnight.verifyMove(6,4),false);
         assertEquals(testKnight.verifyMove(1,4),false);
         
     
     }

     @Test
     public void LMove() {
 

         // Setup starting board
         Board startingBoard = new Board();
         Knight testKnight = new Knight("t", startingBoard);
         
         // Clear pieces out of the way
         // startingBoard.getBoard()[6][7].setPiece(null);
         // startingBoard.getBoard()[6][6].setPiece(null);
         startingBoard.getTiles()[6][2].setPiece(null);
         startingBoard.getTiles()[4][3].setPiece(testKnight);
         
 
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
         //assertEquals(startingBoard.getWhite().getKnights()[1].verifyMove(5, 5), false);
 
 
         System.out.println("X is " + testKnight.getX() + " , Y is " + testKnight.getY());
         assertEquals(testKnight.verifyMove(2,2),true);
         assertEquals(testKnight.verifyMove(2,4),true);
         assertEquals(testKnight.verifyMove(5,3),true);
         assertEquals(testKnight.verifyMove(5,5),true);
         assertEquals(testKnight.verifyMove(2,6),true);
         assertEquals(testKnight.verifyMove(4,6),true);
         assertEquals(testKnight.verifyMove(1,4),true);
         assertEquals(testKnight.verifyMove(1,5),true);
         
         
     
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
         Knight testKnight = new Knight("t", startingBoard);
         startingBoard.getTiles()[4][3].setPiece(testKnight);
         startingBoard.movePiece(4,6,4,4);
         startingBoard.movePiece(2,1,2,4);
    


        System.out.print(startingBoard.toString());
       

        System.out.println("X is " + testKnight.getX() + " , Y is " + testKnight.getY());
        assertEquals(testKnight.verifyMove(3,0),false);
        assertEquals(testKnight.verifyMove(3,6),false);
        assertEquals(testKnight.verifyMove(6,4),false);
        assertEquals(testKnight.verifyMove(0,4),false);
        
    
    }

 
}
package goldfish.model.pieces;

import goldfish.model.Board;

public class King extends Piece {
    
    boolean hasMoved = false;
   
    public King(String color, Board board) {
        super(color, "K", board);

    }
    
    /** 
     * Verifies that x and y are within one square of the current position but not both identical
     * and that the new square is not under attack by the oppponent.
     * @param x
     * @param y
     * @return boolean
     */
    @Override
    public boolean verifyMove(int x, int y) {

        boolean stayingStill = (x == this.getX() && y == this.getY());
        boolean inRange = (Math.abs(x - this.getX()) <= 1 && Math.abs(y - this.getY()) <= 1);

        return inRange && !stayingStill && !this.isEnemyAttacking(x, y);


        
    }


    /**
     * Typically not called for the king, but if it is, it will return false.
     * 
     * @param x x coordinate of the piece
     * @param y y coordinate of the piece
     * @return boolean
     */
    @Override
    public boolean putsKingInCheck(int x, int y) {
        return false;
    }
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
 

    /**
     * Checks if the king can castle with the rook on the left/right side of the board.
     * 
     * @param isLeft true if trying to castle with the rook on the left side of the board (a), false if castling with the rook on the right (h)
     * @return boolean
     */
    public boolean verifyCastle(boolean isLeft){
        
        // not in check 
        if (this.getPlayer().isCheck()){
            return false;
        }

        if (isLeft){ // if left side of board castle

            if(this.getColor().equals('w')){ // if white
                if ((this.hasMoved== false) && (this.getBoard().getWhite().getRooks()[0].hasMoved)==false){ // king and left rook haven't moved
                    if((this.getBoard().isOccupied(1, 7) == 0) && (this.getBoard().isOccupied(2,7) == 0)){ // no pieces in between
                        return true;
                    }
                }
            }
            if(this.getColor().equals('b')){ // if black
                if ((this.hasMoved== false) && (this.getBoard().getBlack().getRooks()[0].hasMoved)==false){// king and left rook haven't moved
                    if((this.getBoard().isOccupied(1, 0) == 0) && (this.getBoard().isOccupied(2, 0) == 0)){ // no pieces in between
                        return true;
                    }
                }
            }
        } else { // if right side of board castle
            if(this.getColor().equals('w')){ // if white
                if ((this.hasMoved== false) && (this.getBoard().getWhite().getRooks()[1].hasMoved)==false){ // king and right rook haven't moved
                    if((this.getBoard().isOccupied(5, 7) == 0) && (this.getBoard().isOccupied(6, 7) == 0)){ // no pieces in between
                        return true;
                    }
                }
            }
            if(this.getColor().equals('b')){ // if black
                if ((this.hasMoved== false) && (this.getBoard().getBlack().getRooks()[1].hasMoved)==false){ // king and right rook haven't moved
                    if((this.getBoard().isOccupied(5, 0) == 0) && (this.getBoard().isOccupied(6, 0) == 0)){ // no pieces in between
                        return true;
                    }
                }
            }
        }
       
        return false;

    }
}
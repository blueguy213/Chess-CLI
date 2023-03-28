package goldfish.model.pieces;

import goldfish.model.Board;

/**
 * King class represents a king in the game of chess
 * @author Sree Kommalapati and Shreeti Patel
 */
public class King extends Piece {
    
    boolean hasMoved = false;
   
    public King(String color, Board board) {
        super(color, "K", board);

    }
    
    /** 
     * Verifies that x and y are within one square of the current position but not both identical
     * and that the new square is not under attack by the oppponent.
     * @param destX
     * @param destY
     * @param real checks if method is being called from the Game loop
     * @return boolean
     */
    @Override
    public boolean verifyMove(int destX, int destY, boolean real) {


        int currX = this.getX();
        int currY = this.getY();


        boolean stayingStill = (destX == currX && destY == currY);
        boolean inRange = (Math.abs(destX - currX) <= 1 && Math.abs(destY - currY) <= 1);

        boolean isCastle = false;

        
        //is destination going to put king in check
        if ((this.putsKingInCheck(destX, destY))){
            return false;
        }


        
        //check if trying to castle curr is kings stop to 2 places over


        if((currX==4)&&(currY==0)){     //black king 
            if((destX==6)&&(destY==0)){ // going to right
                isCastle = verifyCastle(false);
            }
            if((destX==2)&&(destY==0)){// going to left
                isCastle = verifyCastle(true);
            }
        }
        if((currX==4)&&(currY==7)){     //white king 
            if((destX==6)&&(destY==7)){//going right
                isCastle = verifyCastle(false);
            }
            if((destX==2)&&(destY==7)){//going left
                isCastle = verifyCastle(true);
            }
        }

        if(isCastle){
            return true;
        }
     
        if (inRange && !stayingStill && !this.isEnemyAttacking(destX, destY)) {
            return true;
        } else {
            return false;
        }
        

        
    
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
        if (this.getPlayer().isCheck()) {
            return false;
        }

        if (isLeft) { // if left side of board castle

            if(this.getColor().equals("w")){ // if white
                if ((this.hasMoved== false) && (this.getBoard().getWhite().getRooks()[0].hasMoved)==false){ // king and left rook haven't moved
                    if((this.getBoard().isOccupied(1, 7) == 0) && (this.getBoard().isOccupied(2,7) == 0)&& (this.getBoard().isOccupied(3,7) == 0)){ // no pieces in between
                        //can't be in check: 2,7  3,7
                        if(!(this.putsKingInCheck(2,7))&&(!(this.putsKingInCheck(3,7)))){  // 2 tiles on left of king not in check
                            return true;
                        }
                        // Check if the king is in check, if so return false. Then, move king to the left 1 space and check if it is in check. If it is in check, return false. If it is not in check, move the king to the left 1 space and check if it is in check. If it is in check, return false. If it is not in check, return true.
                        if (this.getPlayer().isCheck()) {
                            return false;
                        } else {
                            setX(getX() - 1);
                            if (this.getPlayer().isCheck()) {
                                setX(getX() + 1);
                                return false;
                            } else {
                                setX(getX() - 1);
                                if (this.getPlayer().isCheck()) {
                                    setX(getX() + 2);
                                    return false;
                                } else {
                                    setX(getX() + 2);
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            if(this.getColor().equals("b")) { // if black
                if ((this.hasMoved== false) && (this.getBoard().getBlack().getRooks()[0].hasMoved)==false){// king and left rook haven't moved
                    if((this.getBoard().isOccupied(1, 0) == 0) && (this.getBoard().isOccupied(2, 0) == 0)&& (this.getBoard().isOccupied(3,0) == 0)){ // no pieces in between
                        //can't be in check: 2,0  3,0
                        if(!(this.putsKingInCheck(2,0))&&(!(this.putsKingInCheck(3,0)))){ // 2 tiles on left of king not in check
                            return true;
                        }
                    }
                }
            }
        } else { // if right side of board castle
            if(this.getColor().equals("w")) { // if white
                if ((this.hasMoved== false) && (this.getBoard().getWhite().getRooks()[1].hasMoved)==false){ // king and right rook haven't moved
                    if((this.getBoard().isOccupied(5, 7) == 0) && (this.getBoard().isOccupied(6, 7) == 0)){ // no pieces in between
                        //can't be in check: 5,7   6,7
                        if(!(this.putsKingInCheck(5,7))&&(!(this.putsKingInCheck(6,7)))){ // 2 tiles on right of king not in check
                            return true;
                        }
                    }
                }
            }
            if(this.getColor().equals("b")) { // if black
                if ((this.hasMoved== false) && (this.getBoard().getBlack().getRooks()[1].hasMoved)==false){ // king and right rook haven't moved
                    if((this.getBoard().isOccupied(5, 0) == 0) && (this.getBoard().isOccupied(6, 0) == 0)){ // no pieces in between
                        //can't be in check: 5,0   6,0
                        if(!(this.putsKingInCheck(5,0))&&(!(this.putsKingInCheck(6,0)))){ // 2 tiles on right of king not in check
                            return true;
                        }
                    }
                }
            }
        }
       
        return false;

    }
}
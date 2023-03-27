package goldfish.model.pieces;
import goldfish.model.Board;


public class Rook extends Piece{
    public Rook(String color, Board board) {
        super(color, "R", board);
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
 
// TO DO: Implement the check if a piece of on the tile

    /** 
     * @param x
     * @param y
     * @return boolean
     */
    @Override
    public boolean verifyMove(int destX, int destY) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'possibleMoves'");

        int currX = this.getX();
        int currY = this.getY();

        //trace from start to end see if valid, see if there are pieces in the middle
        
        // See if move is valid move for a rook
        if (!((destX == currX) && (destY != currY)) || ((destX != currX)) && (destY == currY)) {
            System.out.println("A: invlaid rook move");
            return false;
        } 


        // if destination has same color piece as --> false 
        if (((getBoard().isOccupied(destX, destY)) != 0) && // dest tile is not empty and colors of curr and next tiles are same 
                (getBoard().isOccupied(currX, currY) == getBoard().isOccupied(destX, destY))){
           // System.out.println(string)
            return false;
        }
      


        // check for pieces in middle of path

        // check up/down:
        // if x is same and y is diff, check each tile from (x, curr y) to (x, new y) by going up if new y < curr y  or down if new y > curr y
        if ((destX == currX) && (destY != currY)) {
            if (currY > destY){ // going up
                for(int r = currY; r >= destY; r--) { // for each row index from currY to destY going up
                    if (getBoard().isOccupied(currX,r) != 0){ // if tile is occuipied return false
                        return false;
                    }
                }
            }
            if (currY < destY){ //doing down
                for(int r = currY; r <= destY; r++) { // for each row index from currY to destY going up
                    if (getBoard().isOccupied(currX,r) != 0){ // if tile is occuipied return false
                        return false;
                    }
                }

            }   
        }

       //check left/right:
       // if y is same and x is diff, check each tile from ( curr x,  y) to ( new x, y) by going left if new x < curr x  or right if new x > curr x
        if ((destY == currY) && (destX != currX)) {
            if (currX > destX){ // going left
                for(int c = currX; c >= destX; c--) { // for each row index from currX to destx going left
                    if (getBoard().isOccupied(c, currY) != 0){ // if tile is occuipied return false
                        return false;
                    }
                }
            }
            if (currX < destX){ //doing right
                for(int c = currX; c <= destX; c++) { // for each row index from currY to destY going up
                    if (getBoard().isOccupied(c, currY) != 0){ // if tile is occuipied return false
                        return false;
                    }
                }
            }   
         }

        return true;
        // new pos must have same x diff y, or same y diff x
        // 
    }

    @Override
    public boolean putsKingInCheck(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putsKingInCheck'");
    }
}
package goldfish.model.pieces;

public class Rook extends Piece{
    public Rook(String color) {
        super(color, "R");
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
            return false;
        } 
        // check for pieces in middle of path
        // check up/down:
        // if x is same and y is diff, check each tile from (x, curr y) to (x, new y) by going up if new y < curr y  or down if new y > curr y
        if ((destX == currX) && (destY != currY)) {
            if (currY > destY){ // going up
                for(int r = currY; r >= destY; r--) { // for each row index from currY to destY going up
                    // if (currX, r) has piece { return false }
                }
            }
            if (currY < destY){ //doing down
                for(int r = currY; r <= destY; r++) { // for each row index from currY to destY going up
                    // if (currX, r) has piece { return false }
                }

            }   
        }
       //check left/right:
       // if y is same and x is diff, check each tile from ( curr x,  y) to ( new x, y) by going left if new x < curr x  or right if new x > curr x
        if ((destY == currY) && (destX != currX)) {
            if (currX > destX){ // going left
                for(int c = currX; c >= destX; c--) { // for each row index from currX to destx going left
                    // if (c, currY) has piece { return false }
                }
            }
            if (currX < destX){ //doing right
                for(int c = currX; c <= destX; c++) { // for each row index from currY to destY going up
                    // if (c ,currY) has piece { return false }
                }

            }   
         }
        
        return true;
        // new pos must have same x diff y, or same y diff x
        // 
    }
}
package goldfish.model.pieces;
import goldfish.model.Board;

/**
 * The Rook class represents a rook in the game of chess
 * @author Shreeti Patel and Sree Kommalapati
 */
public class Rook extends Piece {
    boolean hasMoved = false;
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
     * @param destX X value of destination tile
     * @param destY Y value of destination tile
     * @param real checks if method is being called from the Game loop
     * @return boolean
     */
    @Override
    public boolean verifyMove(int destX, int destY, boolean real) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'possibleMoves'");

        int currX = this.getX();
        int currY = this.getY();

        
        // See if move is valid move for a rook
        if (!(((destX == currX) && (destY != currY)) || ((destX != currX)) && (destY == currY))){
            //System.out.println("A: invlaid rook move");
            return false;
        } 


        // if destination has same color piece as --> false 
        if (((getBoard().isOccupied(destX, destY)) != 0) && // dest tile is not empty and colors of curr and next tiles are same 
                (getBoard().isOccupied(currX, currY) == getBoard().isOccupied(destX, destY))) {
            //System.out.println("B: same color dest");
            return false;
        }

        // check for pieces in middle of path

        // check up/down:
        // if x is same and y is diff, check each tile from (x, curr y) to (x, new y) by going up if new y < curr y  or down if new y > curr y
        if ((destX == currX) && (destY != currY)) {
            if (currY > destY){ // going up
                for(int r = currY-1; r >= destY; r--) { // for each row index from currY to destY going up
                    if (getBoard().isOccupied(currX,r) != 0){ // if tile is occuipied return false
                        //System.out.println("C: piece in way going up. and r is " + r );
                        return false;
                    }
                }
            }
            if (currY < destY){ //doing down
                for(int r = currY+1; r <= destY; r++) { // for each row index from currY to destY going up
                    if (getBoard().isOccupied(currX,r) != 0){ // if tile is occuipied return false
                        //System.out.println("D: piece in way going down");
                        return false;
                    }
                }
            }   
        }
 
    //check left/right:
       // if y is same and x is diff, check each tile from ( curr x,  y) to ( new x, y) by going left if new x < curr x  or right if new x > curr x
        if ((destY == currY) && (destX != currX)) {
            if (currX > destX){ // going left
                for(int c = currX-1; c >= destX; c--) { // for each row index from currX to destx going left
                    if (getBoard().isOccupied(c, currY) != 0){ // if tile is occuipied return false
                        //System.out.println("E: piece in way going left");
                        return false;
                    }
                }
            }
            if (currX < destX){ //doing right
                for(int c = currX+1; c <= destX; c++) { // for each row index from currY to destY going up
                    if (getBoard().isOccupied(c, currY) != 0){ // if tile is occuipied return false
                        //System.out.println("F: piece in way going right and c is " + c);
                        return false;
                    }
                }
            }   
         }

        return true;
       
    }
}
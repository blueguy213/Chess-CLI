package goldfish.model.pieces;
import goldfish.model.Board;

/**
 * Knight class represents a Knight in the game of chess
 * @author Sree Kommalapati and Shreeti Patel
 */
public class Knight extends Piece {
    public Knight(String color, Board board) {
        super(color, "N", board);
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
     * @param destX X value of destination tile
     * @param destY Y value of destination tile
     * @param real checks if method is being called from the Game loop
     * @return boolean
     */
    @Override
    public boolean verifyMove(int destX, int destY, boolean real) {
        // can go to 8 possible spaces each move: 2 in one direction (up/down) or (left/left) and 1 in perpendicular direction
        // its ok if other pieces in it's path
        // System.out.println("destX is " + destX + ", destY is " + destY);
        int currX = this.getX();
        int currY = this.getY();
         // Check if d is not located 2 steps away in one direction and 1 step away in another direction from c
        if (!((Math.abs(currY - destY) == 2 && Math.abs(currX - destX) == 1) || 
            (Math.abs(currY - destY) == 1 && Math.abs(currX - destX) == 2))) {
            return false;
        }
       
         // if destination has same color piece as --> false 
         if (((getBoard().isOccupied(destX, destY)) != 0) && // dest tile is not empty and colors of curr and next tiles are same 
         (getBoard().isOccupied(currX, currY) == getBoard().isOccupied(destX, destY))){
             return false;
         }
    
        return true;

    }
}

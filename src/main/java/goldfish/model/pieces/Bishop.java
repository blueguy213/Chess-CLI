package goldfish.model.pieces;

import goldfish.model.Board;

public class Bishop extends Piece{
    public Bishop(String color, Board board) {
        super(color, "B", board);
    }

    
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
        
        
        // See if move is valid move for a bishop
        // can move diagonal 
        if (Math.abs(currY - destY) != Math.abs(currX - destX)) { // checks is dest is not in diagonal of curr
            return false;
        }

         // if destination has same color piece as curr--> false 
         if (((getBoard().isOccupied(destX, destY)) != 0) && // dest tile is not empty and colors of curr and next tiles are same 
         (getBoard().isOccupied(currX, currY) == getBoard().isOccupied(destX, destY))){
            return false;
        }

       
        // check for pieces in middle of path

        //traversal variables
        int row = currY; 
        int col = currX;

        while (row != destY && col != destX) {
            // check if there is piece on this tile
            if (getBoard().isOccupied(col,row) != 0){ // if tile is occuipied return false
                return false;
            }

            // Move to the next element in the diagonal
            if (destY < currY && destX < currX) { // if above left
                row--;
                col--;
            } else if (destY < currY && destX > currX) { // if above right
                row--;
                col++;
            } else if (destY > currY && destX < currX) { // if below left
                row++;
                col--;
            } else if (destY > currY && destX > currX) { // if below right
                row++;
                col++;
            }   
        }
        
        return true;
        
    }


    @Override
    public boolean putsKingInCheck(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putsKingInCheck'");
    }
}
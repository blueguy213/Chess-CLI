package goldfish.model.pieces;

public class Pawn extends Piece {
    
        public Pawn(String color) {
            super(color, "p");
        }

        
        /** 
         * @param x
         * @param y
         * @return boolean
         */
        @Override
        public boolean possibleMoves(int x, int y) {
            /*
             * 1. If the pawn is white, it can only move up the board
             */
            if (this.getColor().equals("w")) {
                if (y == this.getY() + 1) {
                    return true;
                }
            } else {
                if (y == this.getY() - 1) {
                    return true;
                }
            }
            return false;
        }


        
    
        
}

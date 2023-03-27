package goldfish.model.pieces;

import goldfish.model.Board;

public class Pawn extends Piece {
    
        public Pawn(String color, Board board) {
            super(color, "p", board);
        }

        /** 
         * @param x
         * @param y
         * @return boolean
         */
        @Override
        public boolean verifyMove(int x, int y) {
            if (x != this.getX()) {
                return false;
            } else {
                if (this.getColor().equals("w")) {
                    if (y == this.getY() + 1) {
                        return true;
                    }
                } else {
                    if (y == this.getY() - 1) {
                        return true;
                    }
                }
            }
            
            return false;
        }

        @Override
        public boolean putsKingInCheck(int x, int y) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'putsKingInCheck'");
        }
}
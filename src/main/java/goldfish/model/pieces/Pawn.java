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
        public boolean checkMove(int x, int y) {
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
}
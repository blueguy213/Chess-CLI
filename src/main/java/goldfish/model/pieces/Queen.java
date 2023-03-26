package goldfish.model.pieces;

public class Queen extends Piece{
    public Queen(String color) {
        super(color, "Q");
    }

    
    /** 
     * @param x
     * @param y
     * @return boolean
     */
    @Override
    public boolean checkMove(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'possibleMoves'");
    }
}
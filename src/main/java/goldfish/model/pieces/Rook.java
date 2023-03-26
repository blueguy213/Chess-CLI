package goldfish.model.pieces;

public class Rook extends Piece{
    public Rook(String color) {
        super(color, "R");
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


        // new pos must have same x diff y, or same y diff x
    }
}
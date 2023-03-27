package goldfish.model.pieces;
import goldfish.model.Board;

public class Queen extends Piece{
    public Queen(String color, Board board) {
        super(color, "Q", board);
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

        // verify if it can move like rook or bishop
        // pretend queen is rook, pretend queen is bishop, see if either is verified
        int currX = this.getX();
        int currY = this.getY();

        Rook qRook = new Rook(getColor(), getBoard());
        Bishop qBishop = new Bishop(getColor(), getBoard());

        qRook.setX(currX);
        qRook.setY(currY);
        qBishop.setX(currX);
        qBishop.setY(currY);

        return (qRook.verifyMove(destX, destY) || qBishop.verifyMove(destX, destY));
    }


    @Override
    public boolean putsKingInCheck(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'putsKingInCheck'");
    }
}
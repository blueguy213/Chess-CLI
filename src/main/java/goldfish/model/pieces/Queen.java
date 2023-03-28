package goldfish.model.pieces;
import goldfish.model.Board;

/**
 * The Queen class represents a queen in the game of chess
 * @author Shreeti Patel and Sree Kommalapati
 */
public class Queen extends Piece{
    public Queen(String color, Board board) {
        super(color, "Q", board);
    }

    
    /** 
     * @param destX X value of destination tile
     * @param destY Y value of destination tile
     * @param real checks if method is being called from the Game loop
     * @return boolean
     */
    @Override
    public boolean verifyMove(int destX, int destY, boolean real) {
  
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

        return (qRook.verifyMove(destX, destY, real) || qBishop.verifyMove(destX, destY, real));
    }
}
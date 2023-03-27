package goldfish.chess;

import goldfish.model.Board;

public class Chess 
{

    public static void runGame() {
        // Set up game variables
        Board board = new Board();
        boolean gameRunning = true;

        while (gameRunning) {
            //draw board
            System.out.print(board);
            
            //get input
            if (board.getTurn() % 2 == 0) {
                System.out.println("White's move: ");
            } else {
                System.out.println("Black's move: ");
            }
            String input = System.console().readLine();
            //input varification
            boolean invalidLength = input.length() != 5;
            boolean invalidFormat = input.charAt(2) != ' ';
            if (input.length() != 5) {
                System.out.println("Invalid input");
                continue;
            }
        }
        //input varification 

        //draw feature

        //game loop

        //input output

        //convert input to internal units (x,y both 0 - 7) (a)
    }
    

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
       runGame();
    }
}
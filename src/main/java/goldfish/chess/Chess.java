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
            boolean notInRange = input.charAt(0) < 'a' || input.charAt(0) > 'h' || input.charAt(3) < 'a' || input.charAt(3) > 'h' || input.charAt(1) < '1' || input.charAt(1) > '8' || input.charAt(4) < '1' || input.charAt(4) > '8';

            if (invalidLength || invalidFormat || notInRange) {
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
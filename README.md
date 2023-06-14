Shreeti Patel and Sree Kommalapati

#### Plan ####

# Split between app logic, board logic, and piece logic

# App Logic: 
 - Main runtime loop
 - Prompting
 - Parsing user-input
 - Interfacing with the Board object

# Board Logic:
 - Storing game state
 - Drawing board

# Player Logic:
 - Checking for check(mate)
 - Validating moves
# Piece Logic:
- Defining piece behaviour
- Determining possible moves for each piece
_______________________________________________________________________________________________________
=======================================================================================================
_______________________________________________________________________________________________________

# To Do:
Check by Submit
[]  blank line above and below any prompt/message your program will print, and the board itself.
[]  No blank line between an attempted move, the illegal move warning, and the actual correct move
[]  blank line between the board drawing and a move.


SP:
[X] Implement verifyMove in Rook
[X] Implement verifyMove in Bishop
[X] Implement verifyMove in Queen
[X] Implement verifyMove in Knight
[SP] Write 5 Tests
[X] Test Rook
[X] Test Bishop
[X] Test Queen
[X] Test Knight
[X] In Tile.setPiece() method we should update the coridnates of piece
[X] In Piece should we add setX() and setY() methods
[X] Implement verfiyCastle in King
[X] Implement draw/draw?
[X] Implement resign


SK:
[X] Implement verifyMove in King
[X] Check/ Checkmate
[X] Input Varifictaion
[X] Game Loop
[SK] Pawn Promotion
[X] Pawn can move 2 squares from start
[X] En passant
[X] Test Game Loop
[SK] Test Input Verification
[SK] Test verifyMove in King
[SK] Test verifyCastle in King
[SK] Test Check/Checkmate
_______________________________________________________________________________________________________
=======================================================================================================
_______________________________________________________________________________________________________

# ## # ## # How to Build the Docs # ## # ## #

 - To build the docs for the chess, model, and pieces packages, which have all the java source code:
 - Navigate to chessrepo/src/main/java and execute the following command:
# javadoc -d docs goldfish.chess goldfish.model goldfish.model.pieces

 - To build the docs for the tests written using JUnit, which show how the tests verify the program:
 - Navigate to chessrepo/test/java and execute the following command:

# javadoc -d doc goldfish.chess goldfish.model goldfish.model.pieces


_______________________________________________________________________________________________________
=======================================================================================================
_______________________________________________________________________________________________________

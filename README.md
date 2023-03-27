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
SP:
[X] Implement verifyMove in Rook
[X] Implement verifyMove in Bishop
[X] Implement verifyMove in Queen
[X] Implement verifyMove in Knight
[SP] Write 5 Tests
[SP] Test Rook
[SP] Test Bishop
[SP] Test Queen
[SP] Test Knight
[SP] In Tile.setPiece() method should we update the coridnates of piece
[X] In Piece should we add setX() and setY() methods
[SP] Implement verfiyCastle in King


SK:
[X] Implement verifyMove in King
[X] Check/ Checkmate
[X] Input Varifictaion
[X] Game Loop
[SK] Test Game Loop
[SK] Test Input Verification
[SK] Test verifyMove in King
[SK] Test verifyCastle in King
[SK] Test Check/Checkmate
[SK] Write 5 Tests

_______________________________________________________________________________________________________
=======================================================================================================
_______________________________________________________________________________________________________

# src -> Source Files
# 
# # src/main/java/goldfish -> Java files that make the app run
#  #  
#  # # src/main/java/goldfish/app -> Contains entrypoint of the application
#  #
#  # # src/main/java/goldfish/model -> Contains code for game objects and board logic
#  #
#  # # src/main/java/goldfish/model/pieces -> Contains code for piece logic
#   
# # # src/test/java/goldfish  -> Java files that test the application
   #
   # # src/test/java/goldfish/units -> Unit tests for specific pieces of the application

_______________________________________________________________________________________________________
=======================================================================================================
_______________________________________________________________________________________________________

**Edit a file, create a new file, and clone from Bitbucket in under 2 minutes**

When you're done, you can delete the content in this README and update the file with details for others getting started with your repository.

*We recommend that you open this README in another tab as you perform the tasks below. 
You can [watch our video](https://youtu.be/0ocf7u76WSo) for a full demo of all the steps in this tutorial. 
Open the video in a new tab to avoid leaving Bitbucket.*

_______________________________________________________________________________________________________
=======================================================================================================
_______________________________________________________________________________________________________

## Edit a file

You’ll start by editing this README file to learn how to edit a file in Bitbucket.

1. Click **Source** on the left side.
2. Click the README.md link from the list of files.
3. Click the **Edit** button.
4. Delete the following text: *Delete this line to make a change to the README from Bitbucket.*
5. After making your change, click **Commit** and then **Commit** again in the dialog. The commit page will open and you’ll see the change you just made.
6. Go back to the **Source** page.

_______________________________________________________________________________________________________
=======================================================================================================
_______________________________________________________________________________________________________

## Create a file

Next, you’ll add a new file to this repository.

1. Click the **New file** button at the top of the **Source** page.
2. Give the file a filename of **contributors.txt**.
3. Enter your name in the empty file space.
4. Click **Commit** and then **Commit** again in the dialog.
5. Go back to the **Source** page.

Before you move on, go ahead and explore the repository. You've already seen the **Source** page, but check out the **Commits**, **Branches**, and **Settings** pages.

_______________________________________________________________________________________________________
=======================================================================================================
_______________________________________________________________________________________________________


## Clone a repository

Use these steps to clone from SourceTree, our client for using the repository command-line free. Cloning allows you to work on your files locally. If you don't yet have SourceTree, [download and install first](https://www.sourcetreeapp.com/). If you prefer to clone from the command line, see [Clone a repository](https://confluence.atlassian.com/x/4whODQ).

1. You’ll see the clone button under the **Source** heading. Click that button.
2. Now click **Check out in SourceTree**. You may need to create a SourceTree account or log in.
3. When you see the **Clone New** dialog in SourceTree, update the destination path and name if you’d like to and then click **Clone**.
4. Open the directory you just created to see your repository’s files.

Now that you're more familiar with your Bitbucket repository, go ahead and add a new file locally. You can [push your change back to Bitbucket with SourceTree](https://confluence.atlassian.com/x/iqyBMg), or you can [add, commit,](https://confluence.atlassian.com/x/8QhODQ) and [push from the command line](https://confluence.atlassian.com/x/NQ0zDQ).
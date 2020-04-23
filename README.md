# CS 151 – Object Oriented Design, Section 01

#### Overview:

---

You're asked to create a tic-tac-toe game on a 3 x 3 grid that can be played by two people sitting next to each other. The first player selects as square on the board and will play for Xs. The game will then allow the second player to select for Os on the board.

#### Instructions on how to play tic-tac-toe can be found at:

---

https://www.wikihow.com/Play-Tic-Tac-Toe

#### Requirements and User Interface:

---

Use the MVC pattern to design your program. If a view also serves as a controller, any input entered through view has to update the model. For example, tic-tac-toe squares are part of the view and can serve as a controllers to take a user input.

This application needs to provide the user with different styles of the Tic-Tac-Toe board to choose from. The shape and color of the board and Xs and Os can be part of the style. Use the Strategy pattern to plug in a style for the board. The initial screen of the game displays two buttons to select the style of the board. Before the game starts, the player selects one of the styles by clicking the corresponding button, then the board will be display the selected style. Again, your design has to follow the Strategy pattern, so that the number of selectable styles is not limited to 2. Be creative and come up with two different styles for the board. The use of the Strategy pattern can be found in the Invoice example from the text book. An Invoice Formatter can be plugged in to display an invoice in a different format. The LayoutManager of Java Library is also another example of using the Strategy Pattern.

The graphical presentation does not have to be fancy as long as all required GUI components function correctly.

The program must offer an undo function for the player. Use a button to support this functionality. Before the other player takes a turn, the current player can undo what he has just selected. The state of the board goes back to the state before the player made a selection. The player is not allowed to make multiple undoes in a row. The button is disabled until the player makes another choice. The player can make undo at most 3 times at his turn.

After a user selects a square, check if the board is in a winning state (three Xs or Os in a row). If there is a winning state, disable all squares and announce the winner.

Name the test program with a main method as TicTacToeTest.java.

#### Rules:

---

The project outcome must be original work. You are NOT allowed to use any external class or someone else's code or design from the internet. I will use code plagiarism checkers. If copied code is found, the involved team will be responsible and everyone in the team will get 0 for the project and an incident report will be filed to the University.

You are allowed to use images to visualize the board and Os and Xs.
All team members should have approximately equal work loads. For example, if you only work on writing report, consider it an unfair distribution of work. You won't get much credit if you only worked on the reports.

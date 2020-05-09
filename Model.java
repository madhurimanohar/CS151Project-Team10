/**
 * 
 * @author madhurim, Gurteg Singh, Rohan Patel
 *
 */
public class Model {
    
    public char[][] board;  // this represents the board 
    public char playerSymbol; // this will be the symbol of the player i.e 'X' or 'O'
    public char winner; // this is the winner of the game   
    private int size;   // this refers to the size of the boards
 
    
    private int lastR = -1, lastC = -1; // last movew row and coloumn
    private int undos = 0; // total undos done in one turn
    private char lastPlayer; // last player who played the turn
    
    
    /*
     * First constructor initializes board and moveNum
     */
    public Model() {
        this.board = new char[3][3];
    }
    
    /*
     * Second constructor initializes board size and playerSymbol
     */
    public Model(int size) {
        this.size = size;
        board = new char[size][size];
        playerSymbol = 'X';
    }
    
    public char[][] getBoard() {
        return board;
    }
    
    public char getPlayerSymbol() {
        return playerSymbol;
    }
    
    
    public char getWinner() {
        return winner;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setBoard(char[][] b) {
        b = board;
    }
    
    public void setPlayerSymbol(char pS) {
        pS = playerSymbol;
    }
    
   
    
    public void setWinner(char w) {
        w = winner;
    }
    
    public void setSize(int s) {
        s = size;
    }
    
    
    
    /*
     * This method is used to determine if there is a winner.
     */
    public char findWinner() {
        if((checkRow() != '\0') || (checkCol() != '\0') || (checkDiagLTR() != '\0') || (checkDiagRTL() != '\0')) {
            return winner;
        }
        return '\0';
    }

    public boolean tied() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (board[r][c] == '\0')
                    return false;
            }
        }
        return true;
    }
    
    /*
     * This method checks for a valid move.
     */
    public boolean validMove(int r, int c) {
        if (board[r][c] == '\0') {  // if the spot on the board is null
            
            // if new player has player, reset undo count
            if(lastPlayer != playerSymbol) {
                undos = 0;
            }
            
            board[r][c] = playerSymbol;
            
            
            // update last move stats
            lastR = r;
            lastC = c;
            lastPlayer = playerSymbol;
            
            // switch player
            switchPlayer();
            
            return true;
        }
        return false;
    }
    
    // check if undo can be done
    public boolean canUndo() {
        return lastR != -1 && lastC != -1 && undos < 3 && winner == '\0';
    }
    
    
    
    // perform undo
    public void undo() {
        if(canUndo()) { 
            playerSymbol = lastPlayer; // update current player
            board[lastR][lastC] = '\0'; // clear move
            lastR = lastC = -1;
            undos++;
        }
    }
    
    
    private void switchPlayer() {
        if (playerSymbol == 'X') {
            playerSymbol = 'O';
        }
        else {
            playerSymbol = 'X';
        }
    }
    
    /*
     * This method checks for the winner in a row.
     */
    public char checkRow() {
        for (int r = 0; r < size; r++) {
            winner = board[r][0];   // set winner to "this" row and check here
            for (int c = 0; c < size; c++) {
                if (board[r][c] != winner) {
                    winner = '\0';  // this is the char symbol for a null value
                                    // need to use this instead of 'null' since winner is a char
                    break;
                }
            }
            if (winner != '\0')
                return winner;
        }
        return '\0';  
    }
    
    /*
     * This method checks for the winner in a column.
     */
    public char checkCol() {
        for (int c = 0; c < size; c++) {
            winner = board[0][c];   // set winner to "this" column and check here
            for (int r = 0; r < size; r++) {
                if (board[r][c] != winner) {
                    winner = '\0';
                    break;
                }
            }
            if (winner != '\0')
                return winner;
        }
        return '\0';
    }
    
    /*
     * This method checks for the winner in a diagonal
     * starting from left to right.
     */
    public char checkDiagLTR() {
        winner = board[0][0];   // set winner as left most point and start checking from here
        for (int r = 0; r < size; r++) {
            if (board[r][r] != winner) {
                winner = '\0';
                break;
            }
        }
        if (winner != '\0')
            return winner;
        return '\0';
    }
    
    /*
     * This method checks for the winner in a diagonal
     * starting from right to left.
     */
    public char checkDiagRTL() {
        winner = board[0][board.length - 1];    // set winner as right most point of the board and start checking from here
        for (int r = 0; r < size; r++) {
            if (board[r][(board.length - 1) - r] != winner) {
                winner = '\0';
                break;
            }
        }
        if (winner != '\0')
            return winner;

        return '\0';
    }
}
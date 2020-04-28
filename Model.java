public class Model {
    public char[][] board;  // this represents the board 
    
    public char playerSymbol; // this will be the symbol of the player i.e 'X' or 'O'
    
    public int moveNum; // this is to help figure out what the symbol of the player will be,
                        // we can base this off of the move number
    
    public String msg;  // this is for printing any message required on the board
                        // we may or may not need this 
    
    public char winner;
    
    /*
     * Constructor initializes board and moveNum
     */
    public Model() {
        this.board = new char[3][3];
        this.moveNum = 0;   // initialize to 0, create a method that will change the value
    }
    
    public char[][] getBoard() {
        return board;
    }
    
    public char getPlayerSymbol() {
        return playerSymbol;
    }
    
    public int getMoveNum() {
        return moveNum;
    }
    
    public String getMSG() {
        return msg;
    }
    
    public char getWindder() {
        return winner;
    }
    
    public void setBoard(char[][] b) {
        b = board;
    }
    
    public void setPlayerSymbol(char pS) {
        pS = playerSymbol;
    }
    
    public void setMoveNum(int mN) {
        mN = moveNum;
    }
    
    public void setMSG(String msg) {
        this.msg = msg;
    }
    
    public void setWinner(char w) {
        w = winner;
    }
    
    /*
     * This method is the basis off of which the player's 
     * symbol gets chosen.
     */
    public char chooseSymbol() {
        if(moveNum % 2 == 0) {
            playerSymbol = 'X';
        }
        else {
            playerSymbol = 'O';
        }
        return playerSymbol;
    }
    
    /*
     * This method is used to determine if there is a winner.
     */
    public boolean checkForWinner(int x, int y) {
        if(checkRow(x, y) || checkCol(x, y) || checkDiag(x, y)) {
            return true;
        }
        return false;
    }
    
    /*
     * This method checks for the winner in a row.
     */
    public boolean checkRow(int x, int y) {
        int countOfX = 0;
        int countOfO = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if((board[i][j]) == (chooseSymbol())) {
                    if(chooseSymbol() == 'X') {
                        countOfX++;
                    }
                    else {
                        countOfO++;
                    }
                }
            }
        }
        
        if((countOfX == 3)) {
            winner = 'X';
            return true;
        }
        else if((countOfO) == 3) {
            winner = 'O';
            return true;
        }
        
        return false;
    }
    
    /*
     * This method checks for the winner in a column.
     */
    public boolean checkCol(int x, int y) {
        int countOfX = 0;
        int countOfO = 0;
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if((board[j][i]) == (chooseSymbol())) {
                    if(chooseSymbol() == 'X') {
                        countOfX++;
                    }
                    else {
                        countOfO++;
                    }
                }
            }
        }
        
        if((countOfX == 3)) {
            winner = 'X';
            return true;
        }
        else if((countOfO) == 3) {
            winner = 'O';
            return true;
        }
        
        return false;
    }
    
    /*
     * This method checks for the winner in a diagonal.
     */
    public boolean checkDiag(int x, int y) {
        int countOfX = 0;
        int countOfO = 0;
        
        for(int i = 0; i < board.length; i++) {
            if((board[i][i]) == (chooseSymbol())) {
                if(chooseSymbol() == 'X') {
                    countOfX++;
                }
                else {
                    countOfO++;
                }
            }
        }
        
        if((countOfX == 3)) {
            winner = 'X';
            return true;
        }
        else if((countOfO) == 3) {
            winner = 'O';
            return true;
        }
        
        return false;
    }
    
    /*
     * This method sets the board for the game play.
     */
    public void playGame() {
        
    }
    
    
}
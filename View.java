import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author madhurim, Gurteg Singh, Rohan Patel
 *
 */
public class View extends JFrame {

    private JButton board[][] = new JButton[3][3];
    private int size;

    /*
     * Constructor
     */
    public View() {
        this.setTitle("Let's Play TicTacToe!");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
     * This method creates the GUI game board. 
     */
    public void createBoard(int size) { 
        this.size = size; 
        JPanel grid = new JPanel(); 
        grid.setLayout(new GridLayout(size, size));
        grid.setPreferredSize(new Dimension(400, 400)); 
        this.add(grid);
        this.pack();

        for (int r = 0; r < size; r++) { 
            for (int c = 0; c < size; c++) { 
                board[r][c] = new JButton("");
                board[r][c].putClientProperty("row", r);
                board[r][c].putClientProperty("col", c);
                board[r][c].setText("");
                grid.add(board[r][c]);
            } 
        }
        this.setVisible(true); 
    }

    /*
     * This method gives the size of the board.
     */
    public int setBoardSize() { 
        createBoard(3);
        return size; 
    }

    /*
     * ActionListener for all buttons.
     */
    public void addButtonListener(ActionListener listener) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++)
                board[r][c].addActionListener(listener);
        }
    }

    /*
     * This method changes the text of the button.
     */
    public void setButtonText(int r, int c, char symb) {
        board[r][c].setText(Character.toString(symb));
    }

    /*
     * This method displays the message in a popup box.
     */
    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message, message, 0);
    } 
}
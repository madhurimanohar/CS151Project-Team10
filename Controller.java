import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * 
 * @author madhurim, Gurteg Singh, Rohan Patel
 *
 */
public class Controller {

    private Model theModel;
    private View theView;

    public Controller(Model theModel, View theView) {
        this.theView = theView;
        this.theModel = theModel;
        theView.addButtonListener(new Listener());
    }

    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            JButton btn = (JButton) ae.getSource();
            char playerSymbol;
            int r;
            int c;
            char winner;

            playerSymbol = theModel.getPlayerSymbol(); // get the playerSymbol from Model class
            r = (int) btn.getClientProperty("row");
            c = (int) btn.getClientProperty("col");

            while(theModel.validMove(r, c)) {   // checks for a valid move by the player
                theView.setButtonText(r, c, playerSymbol);
                winner = theModel.findWinner();
                if ((winner == 'X') || (winner == 'O')) {   // if the symbol of the winner is either X or O
                    theView.displayMessage(winner + " has won the game!");
                }
                else if (theModel.tied()) { // else it's a tie
                    theView.displayMessage("You both tied! Replay!");
                }
            } 
        }
    }
}
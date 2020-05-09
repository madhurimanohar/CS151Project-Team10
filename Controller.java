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
		theView.addButtonListener(new XOListener());
		theView.addUndoButtonListener(new UndoListener());
		theView.undoUpdate(theModel.canUndo());
	}

	
	// XO Listener for the square buttons
	class XOListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			JButton btn = (JButton) ae.getSource();
			char playerSymbol;
			int r;
			int c;
			char winner;

			playerSymbol = theModel.getPlayerSymbol(); // get the playerSymbol from Model class
			r = (int) btn.getClientProperty("row");
			c = (int) btn.getClientProperty("col");

			if (theModel.validMove(r, c)) { // checks for a valid move by the player
				theView.setButtonText(r, c, playerSymbol);

				winner = theModel.findWinner();
				if ((winner == 'X') || (winner == 'O')) { // if the symbol of the winner is either X or O
					disableButtons(); // disable all buttons
					theView.displayMessage(winner + " has won the game!");

				} else if (theModel.tied()) { // else it's a tie
					disableButtons(); // disable all buttons
					theView.displayMessage("You both tied! Replay!");
				}

				theView.undoUpdate(theModel.canUndo());
			}

		}
	}

	
	// listener for undo
	class UndoListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			theModel.undo(); // perform undo
			
			// check if undo can be done
			theView.undoUpdate(theModel.canUndo());
			
			
			// refresh to original state of model
			JButton[][] board = theView.getBoard();
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					board[i][j].setText(theModel.getBoard()[i][j] + "");
				}
			}
		}
	}

	// disable all buttons in the UI as game is over
	void disableButtons() {
		JButton[][] board = theView.getBoard();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j].setEnabled(false);
			}
		}

		theView.undoUpdate(false);
	}

}
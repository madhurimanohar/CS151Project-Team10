import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * 
 * @author madhurim, Gurteg Singh, Rohan Patel
 *
 */
public class Controller {

	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.view = view;
		this.model = model;
		view.addButtonListener(new XOListener());
		view.addUndoButtonListener(new UndoListener());
		view.undoUpdate(model.canUndo());
	}

	// XO Listener for the square buttons
	class XOListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			JButton btn = (JButton) ae.getSource();
			char playerSymbol;
			int r;
			int c;
			char winner;

			playerSymbol = model.getPlayerSymbol(); // get the playerSymbol from Model class
			r = (int) btn.getClientProperty("row");
			c = (int) btn.getClientProperty("col");

			if (model.validMove(r, c)) { // checks for a valid move by the player
				view.setButtonText(r, c, playerSymbol);

				winner = model.checkForWinner();
				if ((winner == 'X') || (winner == 'O')) { // if the symbol of the winner is either X or O
					disableButtons(); // disable all buttons
					view.displayMessage(winner + " has won the game!");

				} else if (model.tied()) { // else it's a tie
					disableButtons(); // disable all buttons
					view.displayMessage("You both tied! Replay!");
				}

				view.undoUpdate(model.canUndo());
			}

		}
	}

	
	// listener for undo
	class UndoListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			model.undo(); // perform undo
			
			// check if undo can be done
			view.undoUpdate(model.canUndo());
			
			
			// refresh to original state of model
			JButton[][] board = view.getBoard();
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					board[i][j].setText(model.getBoard()[i][j] + "");
				}
			}
		}
	}

	// disable all buttons in the UI as game is over
	void disableButtons() {
		JButton[][] board = view.getBoard();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j].setEnabled(false);
			}
		}

		view.undoUpdate(false);
	}

}
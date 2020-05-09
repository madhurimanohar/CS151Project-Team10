import javax.swing.JOptionPane;

/**
 * 
 * @author madhurim, Gurteg Singh, Rohan Patel
 *
 */
public class TicTacToeTest {
    
    public static void main(String args[]) {
        String[] choices = {"Basic Look", "Modern Look"};
        int choice = JOptionPane.showOptionDialog(null, "Please choose what type of style you would like", "Style Selection", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        UILook uiLook;
        if(choice == 0)
            uiLook = new BasicLook();
        else
            uiLook = new ModernLook();
        
        View theView = new View(uiLook);
        Model theModel = new Model(theView.setBoardSize());
        Controller theController = new Controller(theModel, theView);
    }
}
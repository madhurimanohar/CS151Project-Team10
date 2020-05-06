/**
 * 
 * @author madhurim, Gurteg Singh, Rohan Patel
 *
 */
public class Main {
    
    public static void main(String args[]) {
        View theView = new View();
        Model theModel = new Model(theView.setBoardSize());
        Controller theController = new Controller(theModel, theView);
    }
}
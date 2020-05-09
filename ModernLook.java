import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

/**
 * 
 * @author madhurim, Gurteg Singh, Rohan Patel
 *
 */
// Modern look makes the game look better
public class ModernLook implements UILook{

    @Override
    public void formatSquare(JButton button) {
        button.setFocusable(false);
        button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        button.setForeground(Color.RED);
        button.setBackground(Color.DARK_GRAY);
    }

    
    
}
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

// Basic look just changes the font
public class BasicLook implements UILook{

    @Override
    public void formatSquare(JButton button) {
        button.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
        button.setBackground(Color.white);
        button.setForeground(Color.black);
    }

}

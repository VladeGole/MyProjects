package ponggame;

import java.awt.HeadlessException;
import javax.swing.JFrame;

public class PongFrame extends JFrame {

    public PongFrame() throws HeadlessException {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        add(new PongPanel());
        pack();
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    
    
}

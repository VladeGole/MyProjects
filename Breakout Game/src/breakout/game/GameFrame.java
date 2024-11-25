package breakout.game;

import java.awt.HeadlessException;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

    public GameFrame() throws HeadlessException {
        super("Breakout Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,600);
        add(new GamePanel());
        this.setResizable(false);
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    
    
}

package snake;

import javax.swing.*;
import java.awt.*;

public class SnakeFrame extends JFrame {

    public SnakeFrame() throws HeadlessException {
        setTitle("SnakeGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(new SnakePanel());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


package quizapplication;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    public Score() throws HeadlessException {
        super("Score");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1100,800);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon icon=new ImageIcon("score-624x468.png");
        JLabel lab=new JLabel(icon);
        lab.setBounds(40,320,580,480);
        Font f=new Font("Dialog",Font.ITALIC,40);
        JLabel score=new JLabel("Score: "+String.valueOf(Quiz.score));
        score.setFont(f);
        score.setBounds(360,180,300,40);
        
        add(score);
        add(lab);
        setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public static void main(String[]arg){
        new Score();
    }
   
}

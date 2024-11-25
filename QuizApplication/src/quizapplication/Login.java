
package quizapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{
    
    JButton rules,back;
    JTextField text;

    public Login() throws HeadlessException {
        super("Quiz Application");
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1250,600);
        setLocation(250,150);
        
        ImageIcon icon=new ImageIcon("man-playing-quiz-with-smartphone-mobile-app-vector-35896824.jpg");
        JLabel lab=new JLabel(icon);
        lab.setBounds(0,0,500,500);
        
        Font f=new Font("Ink Free",Font.BOLD,30);
        JLabel naslov=new JLabel("Simple Minds");
        naslov.setFont(f);
        naslov.setBounds(850,40,200,50);
        
        JLabel name=new JLabel("Enter your name");
        name.setFont(f);
        name.setBounds(828,120,300,50);
        
        text=new JTextField("",30);
        text.setFont(f);
        text.setBounds(810,210,280,30);
        
       rules=new JButton("Rules");
       rules.setFont(f);
       back=new JButton("Back");
       back.setFont(f);
       rules.setBounds(790,270,150,30);
       back.setBounds(970,270,150,30);
       rules.addActionListener(this);
       back.addActionListener(this);
       
       rules.setFocusable(false);
       back.setFocusable(false);
       
       
        add(back); 
        add(rules);
        add(text);
        add(name);
        add(naslov);
        add(lab);
        setVisible(true);
        
    }
    
    
    
    public static void main(String[]arg){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==rules){
            setVisible(false);
            new Rules(text.getText());
        }
        
        
    }
    
}

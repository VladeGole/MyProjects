package quizapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Rules extends JFrame implements ActionListener {
    
    String name;
    JButton back,next;

    public Rules(String name){
        super("Rules");
        this.name=name;
        
        setLayout(null);
        setSize(800,650);
        setLocation(250,150);
        
        Font font=new Font("Ink Free",Font.BOLD,35);
        JLabel lab=new JLabel("Welcome "+name+" to Simple Minds");
        lab.setFont(font);
        lab.setBounds(80,30,700,40);
        lab.setForeground(Color.BLUE);
        
        JLabel tex=new JLabel();
        tex.setFont(new Font("Dialog",Font.PLAIN,16));
        tex.setBounds(90,100,650,290);
        tex.setText(
                "<html>"+
                "Ovaj kviz se sastoji do obavestenja koji se odnose na ovaj kviz"+"<br><br>"+
                "Ovaj kviz se sastoji do obavestenja koji se odnose na ovaj kviz"+"<br><br>"+
                "Ovaj kviz se sastoji do obavestenja koji se odnose na ovaj kviz"+"<br><br>"+
                "Ovaj kviz se sastoji do obavestenja koji se odnose na ovaj kviz"+"<br><br>"+
                "Ovaj kviz se sastoji do obavestenja koji se odnose na ovaj kviz"+"<br><br>"+
                "<html>"        
        );
        
        next=new JButton("Start");
        back=new JButton("Back");
        next.setFocusable(false);
        back.setFocusable(false);
        
        next.addActionListener(this);
        back.addActionListener(this);
        
        next.setBounds(140,450,110,30);
        back.setBounds(320,450,110,30);
        
        next.setForeground(Color.BLUE);
        back.setForeground(Color.BLUE);
       
        add(lab);
        add(tex);
        add(next);
        add(back);
        setVisible(true);
        
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(back==e.getSource()){
            new Login();
        }else{
            setVisible(false);
            new Quiz("Quiz");
        }
      
    }
    
    
    public static void main(String[]arg){
        new Rules("User");
    }
}


package bankomat2;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;


public class Login extends JFrame implements ActionListener{
    
    JButton clear;
    JButton signUp;
    JButton signIn;
    JTextField cardfield;
    JPasswordField pinField;

    public Login() throws HeadlessException {
        super("Login");
        setSize(800,900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
      
        
        ImageIcon il=new ImageIcon(getClass().getResource("slika.jpg"));
        Image i2=il.getImage().getScaledInstance(150,100,Image.SCALE_DEFAULT);
        ImageIcon icon=new ImageIcon(i2);
        JLabel lab=new JLabel(icon);
        lab.setBounds(80,80,150,100);
        add(lab);
        
        Font font=new Font("Arial",Font.BOLD,30);
        JLabel lab1=new JLabel("Welcome to ATM");
        lab1.setFont(font);
        lab1.setBounds(300,80,600,80);
        add(lab1);
        
        JLabel lab2=new JLabel("Card No:");
        lab2.setFont(font);
        lab2.setBounds(150,350,180,50);
        add(lab2);
        
        cardfield=new JTextField(20);
        cardfield.setBounds(300,350,260,40);
        add(cardfield);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(font);
        pin.setBounds(150,450,60,50);
        add(pin);
        
        pinField=new JPasswordField(20);
        pinField.setBounds(300,450,260,40);
        add(pinField);
        
        signIn=new JButton("Sign In");
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.setBounds(300,550,100,40);
        add(signIn);
        
        clear=new JButton("Clear");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(450,550,100,40);
        add(clear);
        
        signUp=new JButton("Login");
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.setBounds(300,620,250,40);
        add(signUp);
        
        clear.addActionListener(this);
        signIn.addActionListener(this);
        signUp.addActionListener(this);
        
        setVisible(true);
        this.setLocationRelativeTo(null);
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            cardfield.setText("");
            pinField.setText("");
        }
        
        if(e.getSource()==signUp){
            String card=cardfield.getText();
            String pin=pinField.getText();
            Conn c=new Conn();
            String query="select * from login where cardNumber = '"+card+"' and pin = '"+pin+"'";
            try{
               ResultSet rs= c.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new ATM(pin).setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null,"Inccorect Pin or Card");
               }
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        
        if(e.getSource()==signIn){
            setVisible(false);
            new SignIn().setVisible(true);
        }
    }
    
    
    
}

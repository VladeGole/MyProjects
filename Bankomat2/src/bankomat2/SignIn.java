
package bankomat2;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
 import com.toedter.calendar.JDateChooser;


public class SignIn extends JFrame implements ActionListener {
    
    JButton next;
    JTextField nameField;
    JTextField fatherField;
    JRadioButton male;
    JRadioButton female;
    JTextField adresField;
    JTextField cityField;
    JTextField stateField;
    JTextField pinField;
    JTextField emailField;
    JDateChooser birth;
    Random br;
    int broj=0;
    

    public SignIn() throws HeadlessException {
        super("Sign In");
        setSize(700,850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setResizable(true);
       
        setLayout(null);
        
        br=new Random();
        Font font=new Font("Arial",Font.BOLD,30);
        JLabel lab=new JLabel("Application Form No."+Math.abs(br.nextInt()%5000));
        lab.setFont(font);
        lab.setBounds(160,40,500,80);
        add(lab);
        
        Font font1=new Font("Arial",Font.BOLD,20);
        JLabel lab2=new JLabel("1.Personal details");
        lab2.setFont(font1);
        lab2.setBounds(250,120,350,50);
        add(lab2);
        
        JLabel name=new JLabel("Name:");
        name.setFont(font1);
        name.setBounds(90,200,80,40);
        add(name);
        
        nameField=new JTextField(20);
        nameField.setBounds(250,205,280,30);
        add(nameField);
        
        JLabel father=new JLabel("Father`s name:");
        father.setFont(font1);
        father.setBounds(90,260,190,40);
        add(father);
        
        fatherField=new JTextField(20);
        fatherField.setBounds(250,265,280,30);
        add(fatherField);
        
        JLabel date=new JLabel("Date of Birth:");
        date.setFont(font1);
        date.setBounds(90,320,140,40);
        add(date);
        
        birth=new JDateChooser();
        birth.setBounds(250,325,280,30);
        add(birth);
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(font1);
        gender.setBounds(90,365,140,40);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(250,370,120,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(370,370,140,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup group=new ButtonGroup();
        group.add(male);
        group.add(female);
        
        JLabel email=new JLabel("Email:");
        email.setFont(font1);
        email.setBounds(90,425,140,40);
        add(email);
        
        emailField=new JTextField(20);
        emailField.setBounds(250,430,280,30);
        add(emailField);
        
        JLabel adres=new JLabel("Addres:");
        adres.setFont(font1);
        adres.setBounds(90,485,140,40);
        add(adres);
        
        adresField=new JTextField(20);
        adresField.setBounds(250,490,280,30);
        add(adresField);
        
        JLabel city=new JLabel("City:");
        city.setFont(font1);
        city.setBounds(90,545,140,40);
        add(city);
        
        cityField=new JTextField(20);
        cityField.setBounds(250,550,280,30);
        add(cityField);
        
        JLabel state=new JLabel("State:");
        state.setFont(font1);
        state.setBounds(90,605,140,40);
        add(state);
        
        stateField=new JTextField(20);
        stateField.setBounds(250,610,280,30);
        add(stateField);
        
        JLabel pin=new JLabel("Pin Code:");
        pin.setFont(font1);
        pin.setBounds(90,665,140,40);
        add(pin);
        
        pinField=new JTextField(20);
        pinField.setBounds(250,670,280,30);
        add(pinField);
        
        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(500,750,100,40);
        next.addActionListener(this);
        add(next);
        
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
            String formo=String.valueOf(broj);
            String name=nameField.getText();
            String fname=fatherField.getText();
            String gande="";
            String birth1=((JTextField)birth.getDateEditor().getUiComponent()).getText();
            if(male.isSelected()){
                gande="Male";
            }
            if(female.isSelected()){
                gande="Female";
            }
                
             String addres=adresField.getText();
             String city=cityField.getText();
             String state=stateField.getText();
             String pin=pinField.getText();
             String email=emailField.getText();
             
             try {
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null,"Name is required");
             }
             else{
                
                    Conn c=new Conn();
                    String query="insert into signup values('"+formo+"', '"+name+"', '"+fname+"', '"+gande+"', '"+addres+"', '"+city+"', '"+state+"', '"+pin+"', '"+email+"', '"+birth1+"')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                    new SignUpTwo(formo).setVisible(true);
                }
             }catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }  
        
    }
    
}

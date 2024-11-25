package bankomat2;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignUpThree extends JFrame implements ActionListener {
    
        JButton submit;
        JButton cancel;
        JRadioButton box1;
        JRadioButton box2;
        JRadioButton box3;
        JRadioButton box4;
        
        JCheckBox serve1;
        JCheckBox serve2;
        JCheckBox serve3;
        JCheckBox serve4;
        String formo;

    public SignUpThree(String formo) throws HeadlessException {
        super("Account Details");
        this.formo=formo;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,900);
        this.setResizable(true);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        Font font=new Font("Arial",Font.BOLD,30);
        JLabel lab=new JLabel("Page 3: Account Details");
        lab.setFont(font);
        lab.setBounds(210,40,500,80);
        add(lab);
        
        Font font1=new Font("Arial",Font.BOLD,20);
        
        JLabel type=new JLabel("Account Type: ");
        type.setFont(font1);
        type.setBounds(90,200,180,40);
        add(type);
        
        box1=new  JRadioButton("Saving account");
        box1.setBackground(Color.WHITE);
        box1.setBounds(90,240,180,40);
        add(box1);
        
        box2=new  JRadioButton("Fixed deposite account");
        box2.setBackground(Color.WHITE);
        box2.setBounds(280,240,310,40);
        add(box2);
        
        box3=new  JRadioButton("Current account");
        box3.setBackground(Color.WHITE);
        box3.setBounds(90,300,180,40);
        add(box3);
        
        box4=new  JRadioButton("Reccuring deposite account");
        box4.setBackground(Color.WHITE);
        box4.setBounds(280,300,310,40);
        add(box4);
        
        ButtonGroup group=new ButtonGroup();
        group.add(box1);
        group.add(box2);
        group.add(box3);
        group.add(box4);
        
        JLabel card=new JLabel("Card Number: ");
        card.setFont(font1);
        card.setBounds(90,360,180,40);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-1848");
        number.setFont(font1);
        number.setBounds(290,360,250,40);
        add(number);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(font1);
        pin.setBounds(90,420,250,40);
        add(pin);
        
        JLabel pin2=new JLabel("XXXX");
        pin2.setFont(font1);
        pin2.setBounds(290,420,250,40);
        add(pin2);
        
        JLabel serve=new JLabel("Services Required:");
        serve.setFont(font1);
        serve.setBounds(90,480,250,40);
        add(serve);
        
         serve1=new JCheckBox("ATM CARD");
        serve1.setBackground(Color.WHITE);
        serve1.setBounds(90,520,180,40);
        add(serve1);
        
         serve2=new JCheckBox("Internet Banking");
        serve2.setBackground(Color.WHITE);
        serve2.setBounds(290,520,250,40);
        add(serve2);
        
        serve3=new JCheckBox("Mobile Banking");
        serve3.setBackground(Color.WHITE);
        serve3.setBounds(90,580,200,40);
        add(serve3);
        
         serve4=new JCheckBox("EMAIL&SMS Alert");
        serve4.setBackground(Color.WHITE);
        serve4.setBounds(290,580,210,40);
        add(serve4);
        
        JCheckBox serve5=new JCheckBox("I nereby declares that the above entered details are corect to the best of my know ledge");
        serve5.setBackground(Color.WHITE);
        serve5.setBounds(90,640,610,40);
        add(serve5);
        
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(210,700,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(380,700,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource()==cancel){
             setVisible(false);
             new SignUpTwo("").setVisible(true);
        }else if(e.getSource()==submit){
         
         String acountType="";
         if(box1.isSelected()){
             acountType="Saving account";
         }else if(box2.isSelected()){
             acountType="Fixed deposite account";
         }else if(box3.isSelected()){
             acountType="Current account";
         }else if(box4.isSelected()){
             acountType="Reccuring deposite account";
         }
         
         String services="";
         
         if(serve1.isSelected()){
             services+=" ATM CARD";
         }else if(serve2.isSelected()){
             services+=" Internet Banking";
         }else if(serve3.isSelected()){
             services+=" Mobile Banking";
         }else if(serve4.isSelected()){
             services+=" Internet Banking";
         }
         
         Random random=new Random();
         String cardNumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
         String pin=""+Math.abs((random.nextInt()%9000)+1000);
         String pun="";
         
         try{
         if(acountType.equals("")){
             JOptionPane.showMessageDialog(null,"Acount Type is required");
         }else{
         
             Conn con=new Conn();
             
             String query="insert into signinthree values('"+formo+"', '"+acountType+"', '"+cardNumber+"', '"+pin+"')";
             String query2="insert into login values('"+formo+"', '"+cardNumber+"', '"+pin+"')";
             con.s.executeUpdate(query);
             con.s.executeUpdate(query2);
             JOptionPane.showMessageDialog(null,"Card Number is "+cardNumber+" and pin is "+pin);
             setVisible(false);
             new Login().setVisible(true);
         
         }
         }catch(Exception ex){
             System.out.println(ex.getMessage());
         }
        }
         
    }
    
}

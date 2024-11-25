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

public class ATM extends JFrame implements ActionListener {
        JButton deposite;
        JButton fastMoney;
        JButton pin;
        JButton withdrawl;
        JButton mini;
        JButton balance;
        JButton exit;
        String pin2;

    public ATM(String pin2) throws HeadlessException {
        super("ATM");
        this.pin2=pin2;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,850);
        this.setResizable(true);
        setLayout(null);
        
        ImageIcon icon=new ImageIcon(getClass().getResource("atm.jpg"));
        Image i2=icon.getImage().getScaledInstance(700,850,Image.SCALE_DEFAULT);
        ImageIcon icon2=new ImageIcon(i2);
        JLabel lab=new JLabel(icon2);
        lab.setBounds(0,0,700,850);
        add(lab);
        
        JLabel lab2=new JLabel("Please select your transcation");
        lab2.setFont(new Font("Arial",Font.BOLD,10));
        lab2.setForeground(Color.WHITE);
        lab2.setBounds(195,270,180,30);
        lab.add(lab2);
        
        deposite=new JButton("Deposite");
        deposite.setBounds(130,393,90,30);
        deposite.addActionListener(this);
        lab.add(deposite);
        
        fastMoney=new JButton("Fast Cash");
        fastMoney.setBounds(130,425,90,30);
        fastMoney.addActionListener(this);
        lab.add(fastMoney);
        
        pin=new JButton("Pin Change");
        pin.setBounds(130,458,90,30);
        pin.addActionListener(this);
        lab.add(pin);
        
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(295,393,90,30);
        withdrawl.addActionListener(this);
        lab.add(withdrawl);
        
        mini=new JButton("Mini Statemant");
        mini.setBounds(295,426,90,30);
        mini.addActionListener(this);
        lab.add(mini);
        
        balance=new JButton("Balancy Enquier");
        balance.setBounds(295,459,90,30);
        balance.addActionListener(this);
        lab.add(balance);
        
        exit=new JButton("Exit");
        exit.setBounds(295,492,90,30);
        exit.addActionListener(this);
        lab.add(exit);
        
        
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    

     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposite){ 
            setVisible(false);
            new Deposit(pin2).setVisible(true);
        }else if(ae.getSource()==withdrawl){ 
            setVisible(false);
            new Withdraw(pin2).setVisible(true);
        }else if(ae.getSource()==fastMoney){ 
            setVisible(false);
            new FastCash(pin2).setVisible(true);
        }else if(ae.getSource()==mini){ 
            new Mini(pin2).setVisible(true);
        }else if(ae.getSource()==pin){ 
            setVisible(false);
            new Pin(pin2).setVisible(true);
        }else if(ae.getSource()==balance){ 
            this.setVisible(false);
            new Balancu(pin2).setVisible(true);
        }else if(ae.getSource()==exit){ 
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new ATM("").setVisible(true);
    }
}
    


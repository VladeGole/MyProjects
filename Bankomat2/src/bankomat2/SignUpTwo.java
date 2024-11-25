package bankomat2;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUpTwo extends JFrame implements ActionListener {
    
     JComboBox box;
     JComboBox box2;
     JComboBox box3;
     JTextField eduField;
     JTextField panField;
     JTextField seniorField;
     JTextField accField;
     JRadioButton b1;
     JRadioButton b2;
     JRadioButton b3;
     String formo;
     JButton submit;

    public SignUpTwo(String formo) throws HeadlessException {
        super("Additional Details");
        this.formo=formo;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,900);
        this.setResizable(true);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Font font=new Font("Arial",Font.BOLD,30);
        JLabel lab=new JLabel("Page 2: Additional pages");
        lab.setFont(font);
        lab.setBounds(210,40,500,80);
        add(lab);
        
        Font font1=new Font("Arial",Font.BOLD,20);
        
        JLabel religion=new JLabel("Religion: ");
        religion.setFont(font1);
        religion.setBounds(90,200,140,40);
        add(religion);
        
        String[]reli={"Islam","Hindi","Hriscanin","Katolik","Jevrej"};
        box=new JComboBox(reli);
        box.setBounds(200,205,550,30);
        box.setBackground(Color.WHITE);
        add(box);
        
        JLabel category=new JLabel("Category: ");
        category.setFont(font1);
        category.setBounds(90,260,140,40);
        add(category);
        
        String[] categ={"General","OBC","SC","ST","Other"};
        box2=new JComboBox(categ);
        box2.setBounds(200,265,550,30);
        box2.setBackground(Color.WHITE);
        add(box2);
        
        JLabel income=new JLabel("Income: ");
        income.setFont(font1);
        income.setBounds(90,320,140,40);
        add(income);
        
        String[] inc={"Null","<1,50,000","<2,50,0000","5,00,000","Up to 10,00,000"};
        box3=new JComboBox(inc);
        box3.setBounds(200,325,550,30);
        box3.setBackground(Color.WHITE);
        add(box3);
        
        JLabel edu=new JLabel("Educional");
        edu.setFont(font1);
        edu.setBounds(90,380,140,40);
        add(edu);
        
        JLabel quali=new JLabel("Qualiticion:");
        quali.setFont(font1);
        quali.setBounds(90,400,140,40);
        add(quali);
        
        eduField=new JTextField(30);
        eduField.setBounds(200,405,550,30);
        add(eduField);
        
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(font1);
        occupation.setBounds(90,460,140,40);
        add(occupation);
        
        b1=new JRadioButton("Married");
        b1.setBackground(Color.WHITE);
        b1.setBounds(230,465,150,30);
        add(b1);
        
        b2=new JRadioButton("Unmarried");
        b2.setBackground(Color.WHITE);
        b2.setBounds(400,465,150,30);
        add(b2);
        
        b3=new JRadioButton("Other");
        b3.setBackground(Color.WHITE);
        b3.setBounds(600,465,150,30);
        add(b3);
        
        ButtonGroup group=new ButtonGroup();
        group.add(b1);
        group.add(b2);
        group.add(b3);
        
        JLabel pan=new JLabel("PAN Number:");
        pan.setFont(font1);
        pan.setBounds(90,520,140,40);
        add(pan);
        
        panField=new JTextField(30);
        panField.setBounds(230,525,520,30);
        add(panField);
        
        JLabel senior=new JLabel("Senior citizen:");
        senior.setFont(font1);
        senior.setBounds(90,580,140,40);
        add(senior);
        
        seniorField=new JTextField(30);
        seniorField.setBounds(230,585,520,30);
        add(seniorField);
        
        JLabel acc=new JLabel("Exisiting Account:");
        acc.setFont(font1);
        acc.setBounds(90,640,190,40);
        add(acc);
        
        accField=new JTextField(30);
        accField.setBounds(265,645,486,30);
        add(accField);
        
        submit=new JButton("Submit");
        submit.setBounds(650,750,100,40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        add(submit);
        submit.addActionListener(this);
        
        setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
       
        String sreligion=(String) box.getSelectedItem();
        String scategory=(String) box2.getSelectedItem();
        String sincome=(String) box3.getSelectedItem();
        String seducation=eduField.getText();
        String span=panField.getText();
        String ssenior= seniorField.getText();
        String sacc=accField.getText();
        String gende=null;
        if(b1.isSelected()){
            gende="Married";
        }
        if(b2.isSelected()){
            gende="Unmarried";
        }
        if(b3.isSelected()){
            gende="Other";
        }
        
          try {
             if(sreligion.equals("")){
                 JOptionPane.showMessageDialog(null,"Name is required");
             }
             else{
                
                    Conn c=new Conn();
                    String query="insert into signupin values('"+formo+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+span+"', '"+ssenior+"', '"+sacc+"', '"+gende+"')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                    new SignUpThree(formo).setVisible(true);
                }
             }catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }  
        
    }
    
}

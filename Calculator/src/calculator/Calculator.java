
package calculator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class Calculator extends JFrame implements ActionListener {
    JButton[]dugmad=new JButton[10];
    JTextField text;
    JButton[]functionDugmad=new JButton[6];
    JButton del,clear;
    char operator;
    double num1,num2,result;
    public Calculator() throws HeadlessException {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(460,650);
        setLayout(null);
        text=new JTextField();
        text.setBounds(50,25,300,50);
        Font f=new Font("Ink Free",Font.BOLD,30);
        text.setFont(f);
        
        GridLayout grid=new GridLayout(4,4);
        JPanel pane=new JPanel();
        pane.setLayout(grid);
        for(int i=0;i<10;i++){
            dugmad[i]=new JButton(""+i);
            dugmad[i].setFont(f);
            dugmad[i].addActionListener(this);
            dugmad[i].setFocusable(false);
        }
        
        for(int i=0;i<6;i++){
            functionDugmad[i]=new JButton();
            functionDugmad[i].setFont(f);
            functionDugmad[i].addActionListener(this);
            functionDugmad[i].setFocusable(false);
        }
        functionDugmad[0].setText("+");
        functionDugmad[1].setText("-");
        functionDugmad[2].setText("*");
        functionDugmad[3].setText("/");
        functionDugmad[4].setText(".");
        functionDugmad[5].setText("=");
        
        
        
        
        pane.add(dugmad[1]);
        pane.add(dugmad[2]);
        pane.add(dugmad[3]);
        pane.add(functionDugmad[0]);
        pane.add(dugmad[4]);
        pane.add(dugmad[5]);
        pane.add(dugmad[6]);
        pane.add(functionDugmad[1]);
        pane.add(dugmad[7]);
        pane.add(dugmad[8]);
        pane.add(dugmad[9]);
        pane.add(functionDugmad[2]);
        pane.add(functionDugmad[4]);
        pane.add(dugmad[0]);
        pane.add(functionDugmad[5]);
        pane.add(functionDugmad[3]);
        
        pane.setBounds(50,100,300,300);
        pane.setBackground(Color.GRAY);
        
        
       
        del=new JButton("Del");
        del.setFont(f);
        del.addActionListener(this);
        clear=new JButton("Clear");
        clear.setFont(f);
        del.setBounds(50,430,145,80);
        clear.setBounds(205,430,145,80);
        clear.addActionListener(this);
        add(text);
        add(pane);
        add(del);
        add(clear);
  
        setVisible(true);
    }
    
    
    
    
    
    
 
    public static void main(String[] args) {
      new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
       for(int i=0;i<dugmad.length;i++){
           if(e.getSource()==dugmad[i]){
               text.setText(text.getText().concat(String.valueOf(i)));
           }
       }
       if(e.getSource()==functionDugmad[4]){
           text.setText(text.getText()+".");
       }
       
       if(e.getSource()==functionDugmad[0]){
            num1=Double.parseDouble(text.getText());
           operator='+';
           text.setText("");
          
       }
       
         if(e.getSource()==functionDugmad[1]){
            num1=Double.parseDouble(text.getText());
           operator='-';
           text.setText("");
          
       }
         
           if(e.getSource()==functionDugmad[2]){
            num1=Double.parseDouble(text.getText());
           operator='*';
           text.setText("");
          
       }
           
             if(e.getSource()==functionDugmad[3]){
            num1=Double.parseDouble(text.getText());
           operator='/';
           text.setText("");
          
       }
             
             if(e.getSource()==functionDugmad[5]){
            num2=Double.parseDouble(text.getText());
           
            result=0;
           
           switch(operator){
               case '+': result=num1+num2;
                        break;
                
               case '-': result=num1-num2;
                        break;
                        
               case '*': result=num1*num2;
                        break;
               
               case '/': result=num1/num2;
                        break;
           }
           
           num1=result;
           text.setText(String.valueOf(num1));
          
          
       }
             
             if(e.getSource()==del){
                 text.setText("");
             }
             
             if(e.getSource()==clear){
                 String slovo=text.getText();
                  String m="";
                for(int i=0;i<slovo.length()-1;i++){
                     m+=slovo.charAt(i);
                    }
                text.setText(m);
    }

  
     
  
}
}

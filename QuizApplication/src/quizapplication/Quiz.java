
package quizapplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


public class Quiz extends JFrame implements ActionListener {
    
    String[][]question=new String[7][5];
    String[][]answers=new String[7][1];
    JLabel ques;
    JRadioButton[]option=new JRadioButton[4];
    JButton[] butt=new JButton[3];
    public static int timer=15;
    ButtonGroup group=new ButtonGroup();
    int count=0;
    String useranswers[][] = new String[7][1];
    public static int ans_given = 0;
    public static int score = 0;
    String name;
    
    public Quiz(String name) {
        this.name=name;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1150,880);
        setLayout(null);
        setLocation(200,70);
        
        ImageIcon image=new ImageIcon("quizslika.png");
        JLabel lab=new JLabel(image);
        lab.setBounds(0,0,1150,450);
        
        Font f=new Font("Dialog",Font.PLAIN,20);
        
        question[0][0]="Which is used to find and fix bugs in the Java programs?";
        question[0][1]="JVM";
        question[0][2]="JDB";
        question[0][3]="JDK";
        question[0][4]="JRE";

        question[1][0]="What is return type of the hashCode() method in the Object class?";
        question[1][1]="int";
        question[1][2]="Object";
        question[1][3]="long";
        question[1][4]="void";

        question[2][0]="Which package contains the Random class?";
        question[2][1]="java.util";
        question[2][2]="java.lang";
        question[2][3]="java.awt";
        question[2][4]="java.io";

        question[3][0]="An interface with no field or methods is know as?";
        question[3][1]="JVM";
        question[3][2]="JDB";
        question[3][3]="JDK";
        question[3][4]="JRE";

        question[4][0]="In which memory a String is stored,when we create a string using new operator?";
        question[4][1]="Stack";
        question[4][2]="String memory";
        question[4][3]="Random storage space";
        question[4][4]="Heap memory";

        question[5][0]="Which of the following is a marker interface?";
        question[5][1]="Runnable";
        question[5][2]="Remote";
        question[5][3]="Readable";
        question[5][4]="Result";

        question[6][0]="Which keyword is used for acessing the features of a package?";
        question[6][1]="import";
        question[6][2]="package";
        question[6][3]="extends";
        question[6][4]="export";
        
        answers[0][0]="JVM";
        answers[1][0]="Object";
        answers[2][0]="java.lang";
        answers[3][0]="JDB";
        answers[4][0]="String memory";
        answers[5][0]="Remote";
        answers[6][0]="import";
        
        
        
        int m=160;
        for(int i=0;i<butt.length;i++){
            butt[i]=new JButton();
            butt[i].addActionListener(this);
            butt[i].setFont(new Font("Dialog",Font.PLAIN,16));
            butt[i].setForeground(Color.BLUE);
            butt[i].setFocusable(false);
            butt[i].setBounds(m,760,120,30);
            m+=140;
            add(butt[i]);
        }
        
        butt[0].setText("Next");
       
        
        butt[1].setText("50-50");
        butt[2].setText("Submit");
        butt[2].setEnabled(false);
        
        ques=new JLabel();
        ques.setBounds(30,500,570,50);
        ques.setFont(f);
        
        for(int i=0;i<option.length;i++){
            option[i]=new JRadioButton();
            add(option[i]);
            group.add(option[i]);
        }
        
        add(ques);
        add(lab);
        
        start(count);
        setVisible(true);
    }
    
    /**
     *
     * @param g
     */
    public void paint(Graphics g) {
        super.paint(g);
        
        String time = "Time left - " + timer + " seconds"; // 15
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));
        
        if (timer > 0) { 
            g.drawString(time, 750, 550);
        } else {
            g.drawString("Times up!!", 750, 550);
        }
        
        timer--; // 14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(count==6){
            butt[0].setEnabled(false);
            butt[2].setEnabled(true);
        }
        
       if(ans_given==1){
           ans_given=0;
           timer=15;
       }else if(timer<0){
           timer=15;
           if(group.getSelection()==null){
               useranswers[count][0]="";
           }else{
               useranswers[count][0]=group.getSelection().getActionCommand();
           }
            count++;
            start(count);
       }
      
        
    }
    
     public  void start(int count){
        int m=550;
        ques.setText(String.valueOf(count+1)+". "+question[count][0]);
        for(int i=0;i<4;i++){
            option[i].setText(question[count][i+1]);
            option[i].setFont(new Font("Dialog",Font.PLAIN,16));
            option[i].setBounds(30,m,350,50);
            option[i].setFocusable(false);
            option[i].getActionCommand();
            m+=50;
        }
        option[0].setEnabled(true);
             option[1].setEnabled(true);
             option[2].setEnabled(true);
             option[3].setEnabled(true);
        group.clearSelection();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==butt[0]){
            if(group.getSelection()==null){
                useranswers[count][0]="";
            }else{
                useranswers[count][0]=group.getSelection().getActionCommand();
            }
            
            
            
            timer=15;
            count++;
            start(count);
        }
        
        if(e.getSource()==butt[1]){
            if(count==0||count==2||count==4||count==6){
                option[0].setEnabled(false);
                option[2].setEnabled(false);
            }else{
                option[1].setEnabled(false);
                option[3].setEnabled(false); 
            }
            butt[1].setEnabled(false);
        
        }
        
        if(e.getSource()==butt[2]){
            for(int i=0;i<answers.length;i++){
                if(answers[i][0].equals(useranswers[i][0])){
                    score+=10;
                }else{
                    score+=0;
                }
            }
            setVisible(false);
            new Score();
        }
        
    }
    
    public static void main(String[]arg){
        new Quiz("User");
    }
    
}

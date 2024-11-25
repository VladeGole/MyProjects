
package com.java.creategame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Banko extends JFrame implements ActionListener {
    int rows=9;
    int colums=14;
    JButton restart;
    JTextField moneyField,foundField;
    Board board;
    int money;
    Button dugme;
    int found;
    int moneyBags;

    public Banko()  {
        super("Banko");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout bord=new BorderLayout();
        setLayout(bord);
        FlowLayout flow=new FlowLayout(FlowLayout.CENTER);
        JPanel top=new JPanel();
        top.setLayout(flow);
        JLabel moneyLab=new JLabel("Money:$");
        top.add(moneyLab);
        moneyField=new JTextField("",5);
        top.add(moneyField);
        JLabel foundLab=new JLabel("Found:");
        top.add(foundLab);
        foundField=new JTextField("",7);
        top.add(foundField);
        restart=new JButton("Restart");
        restart.addActionListener(this);
        top.add(restart);
        board=new Board(rows,colums,this);
        setup();
        setSize(650,450);
        add(top,BorderLayout.NORTH);
        add(board,BorderLayout.CENTER);
        setVisible(true);
        
    }
    
    public void setup(){
        found=-1;
        money=0;
        earnMoney();
    }
    
    public void spendMoney(){
        money=money-250;
        moneyField.setText(""+money);
        if(money<=0){
            revealBoard();
        }
    }
    
    public void earnMoney(){
        money=money+1000;
        moneyField.setText(""+money);
        found++;
        foundField.setText(found+" of "+"10");
        if(moneyBags>=10){
            revealBoard();
        }
    }
    
    public void revealBoard(){
        for(int row=0;row<rows;row++){
            for(int colum=0;colum<colums;colum++){
                dugme=board.square[row][colum];
                
                if(dugme.state==-2){
                    dugme.found=true;
                    dugme.revealMoney();
                }else{
                    Color green=new Color(204,255,204);
                    Color red=new Color(255,204,204);
                    if(money<=0){
                        dugme.setBackground(red);
                    }else{
                        dugme.setBackground(green);
                    }
                }
                if(dugme.state==0){
                    dugme.clear(false);
                }
            }
        }
    }
    
  
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if(source instanceof Button){
            Button button=(Button)e.getSource();
            if(button.state==-2){
                button.revealMoney();
            }else{
                button.clear(true);
            }
        }else{
            setup();
            board.setup();
        }
    }
    
     public static void main(String[]arg){
        new Banko();
    }
}

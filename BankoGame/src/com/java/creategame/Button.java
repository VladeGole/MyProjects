
package com.java.creategame;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Button extends JButton {
    
    int row;
    int column;
    int near;
    int state;
    Board board;
    boolean found;
    public static ImageIcon unknowBag=new ImageIcon("unknown_bag.gif");
    public static ImageIcon money_bag=new ImageIcon("money_bag.gif");

    public Button(int row, int column,Board board) {
        this.row = row;
        this.column = column;
        this.board = board;
        setup();
    }
    
    public void setup(){
        fill();
        state=0;
        near=0;
        found=false;
        setBackground(null);
        
    }
    
    public void fill(){
        setIcon(unknowBag);
        setText("");
        setEnabled(true);
    }
    
    public void clear(boolean clicked){
        if(clicked){
            
           board.app.spendMoney();
            
        }
        setIcon(null);
        state=-1;
        setEnabled(false);
        if(near>0){
            setText(""+near);
        }else{
        
           Button above=above();
           Button below=below();
           Button left=left();
           Button right=right();
            
           if(above!=null&&above.state==0){
               above.clear(false);
           }
           if(below!=null&&below.state==0){
               below.clear(false);
           }
           if(left!=null&&left.state==0){
               left.clear(false);
           }
           if(right!=null&&right.state==0){
               right.clear(false);
           }
        
        
        }
        
    }
    
    public void revealMoney(){
        setIcon(money_bag);
        setText("");
        if(!found){
            board.app.earnMoney();
            found=true;
        }
        
    }
    
    public Button above(){
        if(row>0){
          return  board.square[row-1][column];
        }
        return null;
    }
    
    public Button below(){
        if(row<board.rows-1){
        return board.square[row+1][column];
        }
        return null;
    }
    
    public Button left(){
        if(column>0){
            return board.square[row][column-1];
        }
        return null;
    }
    
    public Button right(){
        if(column<board.colums-1){
            return board.square[row][column+1];
        }
        return null;
    }
    
}

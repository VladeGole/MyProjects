package com.java.creategame;

import java.awt.GridLayout;
import javax.swing.JPanel;

public class Board extends JPanel{
    
    int rows;
    int colums;
    public Button square[][];
    Banko app;
    int moneyBags;

    public Board(int rows, int colums, Banko app) {
        this.rows = rows;
        this.colums = colums;
        this.app = app;
        square=new Button[rows][colums];
        GridLayout grid=new GridLayout(rows,colums);
        setLayout(grid);
        
        for(int row=0;row<rows;row++){
           for(int colum=0;colum<colums;colum++){
             Button button=new Button(row,colum,this);
             square[row][colum]=button;
             button.addActionListener(app);
             add(button);
           }
        }
        setup();
    }
    
    public void setup(){
        for(int row=0;row<rows;row++){
            for(int colum=0;colum<colums;colum++){
                square[row][colum].setup();
            }
        }
        
           int i=0;
        moneyBags=10;
        while(i<moneyBags){
            int hidRow=(int)(Math.floor(Math.random()*rows));
            int hidColum=(int)(Math.floor(Math.random()*colums));
            if(square[hidRow][hidColum].state==-2){
                continue;
            }else{
                square[hidRow][hidColum].state=-2;
                i++;
            }
        }
        
         for (int row = 0; row < rows; row++) {
            for (int column = 0; column < colums; column++) {
                if (square[row][column].state == 0) {
                   
                    square[row][column].near = getBagCount(row, column);
                }
            }
       }
        
    }
    
    
      private int getBagCount(int row, int column) {
      
       int count = 0;
      
       int above = (row > 0) ? row - 1 : row;
       int below = (row < rows - 1) ? row + 1 : row;
       int left = (column > 0) ? column - 1 : column;
       int right = (column < colums - 1) ? column + 1 : column;
       for (int i = above; i <= below; i++) {
            for (int j = left; j <= right; j++) {
                if (square[i][j].state == -2) {
                   
                       count++;
                }
            }
       }
       return count;
   }
        
    
    
    
}

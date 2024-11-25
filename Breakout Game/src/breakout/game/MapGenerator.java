package breakout.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
    
    int[][]map;
    int brickWidth;
    int brickHeight;

    public MapGenerator(int row,int column) {
        map=new int[row][column];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                map[i][j]=1;
            }
        }
        brickWidth=540/column;
        brickHeight=150/row;
    }
    
    public void draw(Graphics2D g){
        
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j]>0){
                    g.setColor(Color.WHITE);
                    g.fillRect(j*brickWidth+80, i*brickHeight+50,brickWidth,brickHeight);
                    
                    g.setColor(Color.BLACK);
                    
                    g.setStroke(new BasicStroke(3));
                    g.drawRect(j*brickWidth+80, i*brickHeight+50,brickWidth,brickHeight);
                }
            }
        }
        
    }
    
    public void setBrick(int value,int row,int column){
        map[row][column]=value;
    }
    
    
    
    
}

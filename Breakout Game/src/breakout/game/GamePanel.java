
package breakout.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener{
    
    private MapGenerator map;
    boolean play=true;
    int playerX=200;
    private Timer timer;
    private int delay=8;
    private int ballposX=150;
    private int ballposY=350;
    private int balldirX=-1;
    private int balldirY=-2;
    private int score=0;
    private int totalbrick=21;
    
    public GamePanel() {
        map=new MapGenerator(3,7);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        timer=new Timer(delay,this);
        timer.start();
        
    }
    
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        
        //background
        g.setColor(Color.BLACK);
        g.fillRect(1,1,692,592);
        
         map.draw((Graphics2D) g);
        //border
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,692,3);
        g.fillRect(0,0,3,592);
        g.fillRect(681,0,3,592);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("serif",Font.BOLD,15));
        g.drawString("Score:"+score,460,30);
        
        //pade
        g.setColor(Color.GREEN);
        g.fillRect(playerX,555,100,8);
        
        //ball
        g.setColor(Color.YELLOW);
        g.fillOval(ballposX,ballposY,15,15);
        
        if(ballposY>560){
            play=false;
            balldirX=0;
            balldirY=0;
            g.setColor(Color.red);
           g.setFont(new Font("serif",Font.BOLD,30));
           g.drawString("Game Over,Scores:",240,250);
           g.setFont(new Font("serif",Font.BOLD,30));
           g.drawString("Please click Enter for again",200,290);
        }
        
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        
        if(play){
            
         if(new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))){
             balldirY=-balldirY;
         }
         
         for(int i=0;i<map.map.length;i++){
             for(int j=0; j<map.map[0].length;j++){
                 if(map.map[i][j]>0){
                     int brickX=j* map.brickWidth+80;
                     int brickY=i*map.brickHeight+50;
                     int brickWidth=map.brickWidth;
                     int brickHeight=map.brickHeight;
                     
                     Rectangle rect=new Rectangle(brickX,brickY,brickWidth,brickHeight);
                     Rectangle ballRect=new Rectangle(ballposX,ballposY,20,20);
                     Rectangle brickRect=rect;
                     
                     if(ballRect.intersects(brickRect)){
                         map.setBrick(0,i,j);
                         totalbrick--;
                         score+=5;
                         
                         if(ballposX+19<=brickRect.x || ballposX+1 >=brickRect.x + brickRect.width){
                             balldirX=-balldirX;
                         }else{
                             balldirY=-balldirY;
                         }
                     }
                 }
             }
         }
            
            
        ballposX+=balldirX;
        ballposY+=balldirY;
        
        if(ballposX<0){
            balldirX=-balldirX;
        }
        
        if(ballposY<0){
            balldirY=-balldirY;
        }
        
        if(ballposX>670){
            balldirX=-balldirX;
        }
        
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Taster pritisnut:"+e.getKeyCode());
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(playerX>=600){
                playerX=600;
            }else{
                moveRight();
                repaint();
            }
        }
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(playerX<=10){
                playerX=10;
            }else{
                moveLeft();
                repaint();
            }
        }
        
        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(!play){
            play=true;
            ballposX=150;
            ballposY=350;
            balldirX=-1;
            balldirY=-2;
            playerX=200;
            score=0;
            map=new MapGenerator(3,7);
            repaint();
            }
            
        }
    }
    
    

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
    public void moveRight(){
        playerX+=20;
    }
    
    public void moveLeft(){
        playerX-=20;
    }
    
    
    
}

package ponggame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PongPanel extends JPanel implements ActionListener{
    
    int screnWidth=700;
    int screnHeight=400;
    int positionY1=200;
    int positionY2=150;
    private int ballpositionX=150;
    private int ballpositionY=200;
    int balldirX=-2;
    int balldirY=-3;
    int scorePlayer1=0;
    int scorePlayer2=0;
    
    Timer timer;
    boolean run=true;

    public PongPanel() {
        this.setPreferredSize(new Dimension(screnWidth,screnHeight));
        this.setBackground(Color.BLACK);
        setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.addKeyListener(new MyKeyAdapter());
        run=true;
        timer=new Timer(5,this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.WHITE);
        g.drawLine(screnWidth/2,0,screnWidth/2,screnHeight);
        
        g.setColor(Color.white);
        g.fillOval(ballpositionX,ballpositionY,15,15);
        
        g.setColor(Color.BLUE);
        g.fillRect(0,positionY1,10,90);
        
        g.setColor(Color.red);
        g.fillRect(screnWidth-10,positionY2,10,90);
        
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString(""+scorePlayer1,320,30);
        g.drawString(""+scorePlayer2,365,30);
        
        g.dispose();
          
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(run){
            
            if(new Rectangle(ballpositionX,ballpositionY,15,15).intersects(new Rectangle(0,positionY1,10,90))||
              (new Rectangle(ballpositionX,ballpositionY,15,15).intersects(new Rectangle(screnWidth-10,positionY2,10,90))
              )){
                     balldirX=-balldirX;
                }
            
            if(ballpositionX<0){
                reset();
                scorePlayer2++;
            }
            
             if(ballpositionX>700){
                reset();
                scorePlayer1++;
            }
        
            ballpositionX+=balldirX;
            ballpositionY+=balldirY;
            
            
              if(ballpositionY<0){
               balldirY=-balldirY;
                 }
             
            
              if(ballpositionY>385){
                balldirY=-balldirY;
           
                 }
            
        }
        repaint();
    }
    
    public void moveDown(){
        positionY1+=15;
    }
    
    public void moveUp(){
       positionY1-=15; 
    }
    
    public void reset(){
        ballpositionX=150;
        ballpositionY=200;
    }
    
    
    
    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            System.out.println(e.getKeyCode());
            if(e.getKeyCode()==KeyEvent.VK_UP){
                if(positionY1<=1){
                    positionY1=1;
                }else{
                    moveUp();
                    repaint();
                }
            }
            
             if(e.getKeyCode()==KeyEvent.VK_DOWN){
                if(positionY1>=320){
                    positionY1=320;
                }else{
                    moveDown();
                    repaint();
                }
            }
             
               if(e.getKeyCode()==KeyEvent.VK_S){
                if(positionY2>=316){
                    positionY2=316;
                }else{
                    positionY2+=15;
                    repaint();
                }
            }
               
                if(e.getKeyCode()==KeyEvent.VK_W){
                if(positionY2<=1){
                    positionY2=1;
                }else{
                    positionY2-=15;
                    repaint();
                }
            }
            
        }
    }
    
    
    
}

package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SnakePanel extends JPanel implements ActionListener {

    public static int SCREEN_WIDTH=600;
    public static int SCREEN_HEIGHT=600;
    public static int BALL_SIZE=25;
    public boolean isRunning=false;
    public int appleX;
    public int appleY;
    public Random random=new Random();
    public char direction='R';
    public int bodySnake=6;
    public static int GAME=(SCREEN_HEIGHT*SCREEN_WIDTH)/BALL_SIZE;
    public int x[]=new int[GAME];
    public int y[]=new int[GAME];
    public Timer timer;
    public int score=0;

    public SnakePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        setBackground(Color.black);
        setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(isRunning) {

            for (int i = 0; i < SCREEN_WIDTH / BALL_SIZE; i++) {
                g.drawLine(0, i * BALL_SIZE, SCREEN_WIDTH, i * BALL_SIZE);
                g.drawLine(i * BALL_SIZE, 0, i * BALL_SIZE, SCREEN_HEIGHT);
            }

            g.setColor(Color.RED);
            g.fillOval(appleX, appleY, BALL_SIZE, BALL_SIZE);

            for (int i = 0; i < bodySnake; i++) {
                if (i == 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x[i], y[i], BALL_SIZE, BALL_SIZE);
                } else {
                    g.setColor(new Color(45, 180, 0));
                    g.fillRect(x[i], y[i], BALL_SIZE, BALL_SIZE);
                }
            }
        }else{
            gameOver(g);
        }
    }

    public void applePosition(){
        appleX= random.nextInt((int)(SCREEN_HEIGHT/BALL_SIZE))*BALL_SIZE;
        appleY= random.nextInt((int)(SCREEN_HEIGHT/BALL_SIZE))*BALL_SIZE;
    }

    public void frameTarget(){
        if((x[0]>SCREEN_WIDTH || x[0]<0) || (y[0]>SCREEN_HEIGHT || y[0]<0)){
            isRunning=false;
        }

        for(int i = bodySnake;i>0;i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                isRunning = false;
            }
        }

        if(!isRunning){
            timer.stop();
        }

    }

    public void appleEat(){
        if(x[0]==appleX && y[0]==appleY){
            bodySnake++;
            applePosition();
            score++;
        }
    }

    public void startGame(){
        applePosition();
        isRunning=true;
        timer=new Timer(70,this);
        timer.start();
    }

    public void gameOver(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Ink",Font.BOLD,40));
        FontMetrics fontMetrics=getFontMetrics(g.getFont());
        g.drawString("Score: "+String.valueOf(score),SCREEN_WIDTH/2,SCREEN_HEIGHT/2);
        g.setColor(Color.red);
        g.setFont( new Font("Ink Free",Font.BOLD, 75));
        FontMetrics metrics2 = getFontMetrics(g.getFont());
        g.drawString("Game Over", (SCREEN_WIDTH - metrics2.stringWidth("Game Over"))/3, SCREEN_HEIGHT/3);

    }

    public void move(){
        for(int i=bodySnake;i>0;i--){
            x[i]=x[i-1];
            y[i]=y[i-1];
        }

        switch (direction){
            case 'R':x[0]+=BALL_SIZE;
                    break;
            case 'L':x[0]-=BALL_SIZE;
                    break;

            case 'U':y[0]-=BALL_SIZE;
                    break;

            case 'D':y[0]+=BALL_SIZE;
                    break;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(isRunning){
                move();
                frameTarget();
                appleEat();
            }
            repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            System.out.println(e.getKeyChar());
           switch (e.getKeyCode()){
               case KeyEvent.VK_LEFT:
                   if(direction=='R'){direction='R';}else{direction='L';}
                        break;


               case KeyEvent.VK_RIGHT:
                   if(direction=='L'){direction='L';}else{direction='R';}
                   break;


               case KeyEvent.VK_UP:
                   if(direction=='D'){direction='D';}else{direction='U';}
                   break;


               case KeyEvent.VK_DOWN:
                   if(direction=='U'){direction='U';}else{direction='D';}
                   break;


           }

        }
    }


}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JPanel {

    public static final int FRAMEWIDTH = 900, FRAMEHEIGHT = 900;
    private int level = 1;
    private Timer timer;
    private ArrayList<Ball> balls;
    private ArrayList<Triggerball> trigger;

    public Main() {
        balls = new ArrayList<Ball>();
        trigger = new ArrayList<Triggerball>();

        for (int i = 0; i < level*20; i++) {
           if(Math.random() > .5){
               Ball balli = new Ball((int)(Math.random()*878),(int)(Math.random()*900),(int)(Math.random()*-3)-1,(int)(Math.random()*-3)-1);
               balls.add(balli);
           }
            Ball balli = new Ball((int)(Math.random()*878),(int)(Math.random()*900),(int)(Math.random()*3)+1,(int)(Math.random()*3)+1);
            balls.add(balli);
        }

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                int x = mouseEvent.getX();
                int y = mouseEvent.getY();
               Triggerball starter = new Triggerball(x-25,y-25,0,0,50,(int)System.currentTimeMillis());
                trigger.add(starter);
                repaint();
                }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
            }
        });

        timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for (int j = 0; j < trigger.size(); j++) {
                    Triggerball t = trigger.get(j);
                    if (t.getDead()){
                        trigger.remove(j);
                    }
                    for (int i = 0; i < balls.size(); i++) {
                        Ball b = balls.get(i);
                        if (b.intersect(t)){
                            trigger.add(new Triggerball((int)(b.getCenterPoint().getX())-t.getDiameter()/2,(int)(b.getCenterPoint().getY())-t.getDiameter()/2, 0, 0, 50,System.currentTimeMillis()));
                            balls.remove(i);
                            i--;
                            if(balls.size() < level*10){
                                restart();
                                level++;
                            }
                        }
                    }
                }

                for(Ball b: balls) {
                    b.move(FRAMEWIDTH,FRAMEHEIGHT-22);
                }
                repaint();
            }
        });
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for (Triggerball t: trigger){
            t.draw(g2);
        }
        for(Ball b: balls) {
            b.draw(g2);
        }
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("J+D Project");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, FRAMEWIDTH, FRAMEHEIGHT + 22);
        Main panel = new Main();
        panel.setSize(FRAMEWIDTH, FRAMEHEIGHT);
        panel.setFocusable(true);
        panel.grabFocus();
        window.add(panel);
        window.setVisible(true);
        window.setResizable(false);
    }
    public void restart(){
        //TODO write restart method!!!
    }
}
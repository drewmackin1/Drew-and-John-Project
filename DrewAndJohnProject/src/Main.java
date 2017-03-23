import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JPanel {

    public static final int FRAMEWIDTH = 900, FRAMEHEIGHT = 900;
    private int level = 4;
    private Timer timer;
    private ArrayList<Ball> balls;
    private ArrayList<Triggerball> trigger;

    public Main() {
        balls = new ArrayList<Ball>();
        trigger = new ArrayList<Triggerball>();

        for (int i = 0; i < level*10; i++) {
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
               Triggerball starter = new Triggerball(x-25,y-25,0,0,50);
//                Ball starter = new Ball(x-25, y-25,0,0);
//                starter.setDiameter(50);
                trigger.add(starter);
// balls.add(starter);

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
                    for (int i = 0; i < balls.size(); i++) {
                        Ball b = balls.get(i);
                        if (b.intersect(t.getX(), t.getY())) {
                            trigger.add(new Triggerball(b.getX(), b.getY(), 0, 0, 50));
                            balls.remove(i);
                            i--;
                            System.out.println("work");

//                        b.setVY(0);
//                        b.setVX(0);

//                        while (b.getDiameter() < 50){
//                            b.setDiameter(b.getDiameter()+1);
                        }
                    }
                }
                for (int i = 0; i < trigger.size(); i++) {
                    if ()

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
        JFrame window = new JFrame("Project");
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
}
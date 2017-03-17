import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JPanel {

    public static final int FRAMEWIDTH = 900, FRAMEHEIGHT = 900;
    private int level = 3;
    private Timer timer;
    private ArrayList<Ball> balls;

    public Main() {
        balls = new ArrayList<Ball>();
        for (int i = 0; i < level*10; i++) {
           if(Math.random() > .5){
               Ball balli = new Ball((int)(Math.random()*878),(int)(Math.random()*900),(int)(Math.random()*-3)+1,(int)(Math.random()*-3)+1);
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
                repaint();
            }
        });
        timer.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for(Ball b: balls) {
            b.draw(g2);
            b.move(FRAMEWIDTH,FRAMEHEIGHT-22);

        }
    }
    public boolean intersect(int x, int y){
       boolean f = false;
        for(Ball b: balls) {
            if(b.getX()-5 > x-25 && b.getX()-5 < x+25 && b.getY()-5 > y-25 && b.getY() < y+25){
             f = true;
            }
        }
        return f;
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
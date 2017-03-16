import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main extends JPanel {

    public static final int FRAMEWIDTH = 1440, FRAMEHEIGHT = 900;
    private Timer timer;
    private ArrayList<Ball> balls;

    public Main() {
        Ball ball1 = new Ball(100,100, 20, 20);
        balls.add(ball1);

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
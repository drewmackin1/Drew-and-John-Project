import java.awt.*;

public class Ball {

    private int x, y, vx, vy, diameter;
    private Color color;

    public Ball(int x, int y, int vx, int vy){
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;

        diameter = 10;
        randomColor();
    }

    public void draw(Graphics2D g2){
        g2.setColor(color);
        g2.fillOval(x, y, diameter, diameter);
    }

    public void move(int w, int h){

        if(x + diameter >= w) {
            vx = -vx;
            x = w - diameter;
        }
        else if(y + diameter >= h) {
            vy = -vy;
            y = h - diameter;
        }
        else if(y <= 0) {
            vy = -vy;
            y = 0;
        }
        else if(x <= 0) {
            vx = -vx;
            x = 0;
        }
        x += vx;
        y += vy;
    }
    public boolean intersect(int mx, int my){
        boolean f = false;

            if(50>Math.sqrt(Math.pow((this.y+25)-(my+25),2)+Math.pow((this.x+25)-(mx+25),2))){
                f = true;
            }
        return f;
    }

    public void randomColor(){
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);

        Color rColor = new Color(r, g, b);
        color = rColor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDiameter() {
        return diameter;
    }

    public Ball setDiameter(int diameter) {
        this.diameter = diameter;
        return this;
    }

    public void setVX(int newVX){
        vx = newVX;
    }

    public void setVY(int newVY){
        vy = newVY;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getVx() {
        return vx;
    }

    public int getVy() {
        return vy;
    }
}

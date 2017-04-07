import java.awt.*;

public class Triggerball extends Ball{

    Main main;

    private long birthTime;
    private Color color;
    public Triggerball(int x, int y, int diameter, long birthTime, Color color, Main m){
        super(x,y,0,0);
        setDiameter(diameter);
        this.birthTime = birthTime;
        this.color = color;
        main = m;

    }
    public boolean getDead(){
        if(System.currentTimeMillis() - birthTime > 10000/main.getLevel()+23){
            /*
            1 = 13 (10/x)+2
            2 = 8
            3 = 6
            4 = 5
            5 = 5
            6 = 4
            7 = 4
            8 = 4
            9 = 4
            10 = 4
             */
            return true;
        }
        return  false;
    }

    public void grow(){
        if(getDiameter() < 100){
            setDiameter(getDiameter()+2);
            setX(getX()-1);
            setY(getY()-1);
        }
    }
}
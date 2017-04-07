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
        if(System.currentTimeMillis() - birthTime > 10000/main.getLevel()+2){
            /*
            1 = 12 (10/x)+2
            2 = 7
            3 = 5
            4 = 4
            5 = 4
            6 = 3
            7 = 3
            8 = 3
            9 = 3
            10 = 3
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
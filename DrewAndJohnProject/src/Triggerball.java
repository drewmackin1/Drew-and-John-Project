import java.awt.*;

public class Triggerball extends Ball{

    Main main = new Main();

    private long birthTime;
    public Triggerball(int x, int y, int diameter, long birthTime){
        super(x,y,0,0);
        setDiameter(diameter);
        this.birthTime = birthTime;

    }
    public boolean getDead(){
        if(System.currentTimeMillis() - birthTime > 10000/main.getLevel()){
            System.out.println(main.getLevel());
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

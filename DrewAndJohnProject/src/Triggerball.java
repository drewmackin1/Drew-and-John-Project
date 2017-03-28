public class Triggerball extends Ball{

    private long birthTime;
    public Triggerball(int x, int y, int vx, int vy, int diameter, long birthTime){
        super(x,y,vx,vy);
        setDiameter(diameter);
        this.birthTime = birthTime;

    }
    public boolean getDead(){
        if(System.currentTimeMillis() - birthTime > 10000){
            return true;
        }
        return  false;
    }
}

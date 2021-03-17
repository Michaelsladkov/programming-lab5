package data;

public class Coordinates {
    private final long x;
    private final long y;
    public Coordinates(long xCoordinate, long yCoordinate){
        x=xCoordinate;
        y=yCoordinate;
    }
    public long getX(){
        return x;
    }
    public long getY(){
        return y;
    }
}
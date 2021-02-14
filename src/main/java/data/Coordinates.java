public class Coordinates {
    private long x;
    private long y;
    public Coordinates(){
        x=0;
        y=0;
    }
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
    public void setX(long xCoordinate){
        x=xCoordinate;
    }
    public void setY(long yCoordinate){
        y=yCoordinate;
    }
    public void setCoordinates(long xCoordinate, long yCoordinate){
        x=xCoordinate;
        y=yCoordinate;
}
}
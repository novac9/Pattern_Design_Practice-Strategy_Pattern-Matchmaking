/*
This matchmaking algorithm is to find the best match with four different strategies - distance-based, habits/interests-based,
 reverse distance-based, and reverse habits/interests-based. 
*/

public class Coord {
    private double x;
    private double y;
    public Coord(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

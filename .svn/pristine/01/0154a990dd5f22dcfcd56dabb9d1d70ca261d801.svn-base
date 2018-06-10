package ch4;

public class Point implements Comparable<Point> {

    private static final Point ORIGIN = new Point();
    private int x, y;
    
    public Point() {
    }
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public double distance(Point p) {
        int xdiff = x - p.x;
        int ydiff = y - p.y;
        return Math.sqrt(xdiff * xdiff + ydiff * ydiff);
    }

    @Override
    public int compareTo(Point p) {
        double pDist = p.distance(ORIGIN);
        double dist = this.distance(ORIGIN);
        if (dist > pDist) {
            return 1;
        } else if (dist == pDist) {
            return 0;
        } else {
            return -1;
        }
    }
    
    public static void main (String args[]) {
        Point p1 = new Point(5,5);
        Point p2 = new Point(4,6);
        System.out.println(p1.compareTo(p2));
        
        Comparable<Point> obj = new Point();
        // INVALID: Comparable has no distance method; need an explicit cast
        //double dist = obj.distance(p1);
        System.out.println(obj.toString());
        double dist =((Point)obj).distance(p1);
        System.out.println(dist);
        System.out.println(obj.toString());
    }
}

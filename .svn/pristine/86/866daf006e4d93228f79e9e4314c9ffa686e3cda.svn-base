package ch1;

class Point {

    public double x;
    public double y;

    public void clear() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public void move(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

// Pixel inherits all data(fields) and methods from Point
public class Pixel extends Point {
    // extend data by adding a new field
    public String color;

    // extend behavior by overriding the clear method from superclass
    public void clear() {
        super.clear();
        color = null;
    }
}

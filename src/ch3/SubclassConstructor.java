package ch3;

class X {

    protected int xMask = 0x00ff;
    protected int fullMask;
    protected double value;

    public X() {
        init();
        fullMask = xMask;
        value = 0.0;
    }

    private static void init() {
        System.out.println("X init.");
    }

    public int mask(int orig) {
        return (orig & fullMask);
    }

    public void method1() {
        System.out.println("method1(X) called.");
    }
}

class Y extends X {

    protected int yMask = 0xff00;
    protected int value;

    public Y() {
        init();
        fullMask |= yMask;
        value = 1;
    }

    private static void init() {
        System.out.println("Y init.");
    }

    public int mask(int orig) {
        return (orig & fullMask);
    }

    public void method1() {
        System.out.println("method1(Y) called.");
    }
}

public class SubclassConstructor {

    public static void main(String args[]) {
        //System.out.println("fullmask=" + Integer.toHexString(x.xMask));
        X x = new X();
        System.out.printf("fullMask=%x\n", x.fullMask);
        x.method1();
        System.out.println();
        Y y = new Y();
        System.out.printf("fullMask=%x\n", y.fullMask);
        y.method1();
        System.out.println();
        X xy = new Y();
        System.out.printf("fullMask=%x\n", xy.fullMask);
        xy.method1();
        System.out.println();

    }
}
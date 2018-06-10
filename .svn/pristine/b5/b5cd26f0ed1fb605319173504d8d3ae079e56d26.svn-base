package ch4;

interface X {

    int val = 1;
}

interface Y extends X {

    double val = 2.5;
    double sum = val + X.val;
}

class Z implements Y {
}

interface C {

    String val = "Interface C";
}

interface D extends X, C {
    // using val is ambiguous
    // should be accessed X.val or C.val
}

interface CardDealer {

    //void draw(); // flip top card
    void deal(); // distribute cards
    void shuffle();
    boolean getState();
}

interface GraphicalComponent {

    //void draw(); // render on default device
    void rotate(int degrees);
    void fill();
    int getState();
}

// ERROR: both superinterfaces have a method with the same name but different
//return types
//interface GraphicalCardDealer
//        extends CardDealer, GraphicalComponent {
//}

public class ExtendedInterface {

    public static void main(String args[]) {
        System.out.println("Z.val=" + Z.val + ", Z.sum=" + Z.sum);
        Z z = new Z();
        System.out.println("z.val=" + z.val
                + ", ((Y)z).val=" + ((Y) z).val
                + ", ((X)z).val=" + ((X) z).val);
    }
}

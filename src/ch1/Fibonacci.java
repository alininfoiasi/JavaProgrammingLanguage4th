package ch1;

/**
 *
 * @author alin
 */
public class Fibonacci {
    // final: immutable variable (can never had its value changed)
    // String is an immutable object
    // static: the variable isn't associated with each instance, but with 
    // the class

    static final int MAX = 10;

    /**
     * Print the Fibonacci sequence for values < MAX
     */
    public static void runFibonacci() {
        int lo = 1;
        int hi = 1;
        System.out.println("Using DO-WHILE:");
        System.out.println(lo);
        // do-while: always executes at least once
        do {
            System.out.println(hi);
            hi = lo + hi;
            lo = hi - lo;
        } while (hi < MAX);

        lo = 1;
        hi = 1;
        System.out.println("Using WHILE:");
        System.out.println(lo);
        while (hi < MAX) {
            System.out.println(hi);
            hi = lo + hi;
            lo = hi - lo;
        }
    }

    static double average(int[] values) {
        // normal boolean operators always evaluate both operands, so this 
        // won't work
        //if (values == null | values.length == 0)
        //   throw new IllegalArgumentException();

        // conditional boolean operators evaluates first operand, and the 
        // second one only if necessary
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException();
        } else {
            double sum = 0.0;
            for (int i = 0; i < values.length; i++) {
                sum += values[i];
            }
            return sum / values.length;
        }
    }

    public static void main(String args[]) {
        Fibonacci.runFibonacci();
    }
}

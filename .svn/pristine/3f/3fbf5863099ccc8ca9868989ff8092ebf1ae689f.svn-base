package ch2;

class Primes {

    private static final int value = 100;
    private static int[] knownPrimes = new int[value];

    static {
        knownPrimes[0] = 2;
        knownPrimes[1] = 3;
        for (int i = 2; i < knownPrimes.length; i++) {
            knownPrimes[i] = getNextPrime(knownPrimes[i - 1]);
        }
    }

    public void displayPrimes() {
        for (int i = 0; i < knownPrimes.length; i++) {
            System.out.println(knownPrimes[i]);
        }
    }

    private static int getNextPrime(int last) {
        // start with the next prime number
        int next = last + 1;
        int i = 2;

        while (i <= Math.sqrt(next)) {
            if (next % i == 0) {
                next++;
                i = 2;
            } else {
                i++;
            }
        }
        return next;
    }
}

public class InitializationBlock {

    public static int somevalue = 10;

    {
        System.out.println("instance initializer 1");
    }

    // static block initializers are executed after class load in the order
    // they appear
    static {
        System.out.println("static initializer 1");
    }

    {
        System.out.println("instance initializer 2");
    }

    public InitializationBlock() {
        System.out.println("constructor");
    }

    {
        System.out.println("instance initializer 3");
    }

    static {
        System.out.println("static initializer 2");
    }

    public static void main(String args[]) {

        InitializationBlock sib1 = new InitializationBlock();
        InitializationBlock sib2 = new InitializationBlock();
        InitializationBlock sib3 = new InitializationBlock();
        System.out.println(InitializationBlock.somevalue);

        //Primes p = new Primes();
        //p.displayPrimes();

    }
}

package ch2;

public enum SingletonBetter {
    // lazy initialization is not possible

    INSTANCE;
    private static volatile int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        ++counter;
    }

    public static void main(String args[]) {
        System.out.println(SingletonBetter.INSTANCE.getCounter());
        SingletonBetter.INSTANCE.incrementCounter();
        System.out.println(SingletonBetter.INSTANCE.getCounter());

    }
}

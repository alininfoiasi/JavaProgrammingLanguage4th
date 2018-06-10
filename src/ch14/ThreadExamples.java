package ch14;

// extend the thread (the worker)
class PingPong extends Thread {

    private String word; // what word to print
    private int delay; // how long to pause

    public PingPong(String whatToSay, int delayTime) {
        word = whatToSay;
        delay = delayTime;
    }

    @Override
    public void run() {
        try {
            for (;;) {
                System.out.print(word + " ");
                Thread.sleep(delay); // wait until next time
            }
        } catch (InterruptedException e) {
            return; // end this thread
        }
    }
}

// implement a certain work
class RunPingPong implements Runnable {

    private String word; // what word to print
    private int delay; // how long to pause

    RunPingPong(String whatToSay, int delayTime) {
        word = whatToSay;
        delay = delayTime;
    }

    @Override
    public void run() {
        try {
            for (;;) {
                System.out.print(word + " ");
                Thread.sleep(delay); // wait until next time
            }
        } catch (InterruptedException e) {
            return; // end this thread
        }
    }
}

class SeparateGroups {

    private double aVal = 0.0;
    private double bVal = 1.1;
    protected final Object lockA = new Object();
    protected final Object lockB = new Object();

    public double getA() {
        synchronized (lockA) {
            return aVal;
        }
    }

    public void setA(double val) {
        synchronized (lockA) {
            aVal = val;
        }
    }

    public double getB() {
        synchronized (lockB) {
            return bVal;
        }
    }

    public void setB(double val) {
        synchronized (lockB) {
            bVal = val;
        }
    }

    public void reset() {
        synchronized (lockA) {
            synchronized (lockB) {
                aVal = bVal = 0.0;
            }
        }
    }
}

public class ThreadExamples {

    public static void useThread() {
        new PingPong("ping", 33).start(); // 1/30 second
        new PingPong("PONG", 100).start(); // 1/10 second
    }

    public static void useRunnable() {
        Runnable ping = new RunPingPong("ping", 33);
        Runnable pong = new RunPingPong("PONG", 100);
        new Thread(ping).start();
        new Thread(pong).start();
    }

    public static void main(String[] args) {
        ThreadExamples.useRunnable();
    }
}

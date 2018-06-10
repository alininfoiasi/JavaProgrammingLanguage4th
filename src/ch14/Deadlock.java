package ch14;

/**
 *
 * @author alin
 */
public class Deadlock {

    public static void sleepMethod1() {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };

        try {
            for (int i = 0;
                    i < importantInfo.length;
                    i++) {
                //Pause for 4 seconds
                Thread.sleep(4 * 1000);
                //Print a message
                System.out.println(importantInfo[i]);
                if(i==2) {
                    Thread.currentThread().interrupt();
                }
                if (Thread.interrupted()) {
                    // we've been interrupted
                    return;
                    // or 
                    //  throw new InterruptedException();
                }
            }
        } catch (InterruptedException ie) {
            // very important!
            // the interrupted flag is cleared, so to avoid problems with any 
            // possible loops
            //Thread.currentThread().interrupt();
            return;
        }
    }

    /**
     * to avoid deadlocks, use a consistent order in acquiring locks
     */
    private static void testDeadlock() {
        final Object lock1 = new Object();
        final Object lock2 = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread1 acquired lock1");
                    try {
                        Thread.sleep(6 * 10000);
                    } catch (InterruptedException ignore) {
                    }
                    synchronized (lock2) {
                        System.out.println("Thread1 acquired lock2");
                    }
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("Thread2 acquired lock2");
                    try {
                        Thread.sleep(6 * 10000);
                    } catch (InterruptedException ignore) {
                    }
                    synchronized (lock1) {
                        System.out.println("Thread2 acquired lock1");
                    }
                }
            }
        });
        thread2.start();

        // Wait a little for threads to deadlock.
        try {
            Thread.sleep(2 * 10000);
        } catch (InterruptedException ignore) {
        }
    }

    /*
     * - wait() is called on an object monitor
     * - wait() can be waken by notify() -> when only one thread is waiting for
     * the condition to be held or notifyAll() -> more threads can continue 
     * executing after the condition is held
     * - should happen in a synchronized block
     * - it releases the lock while waiting
     */
    private static void testWait() {
        final Object lock = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("Thread1 acquired lock and waiting now"
                            + " (including lock release)...");
                    try {
                        // wait() can be resumed for no apparent reason and
                        // should be used with a conclusion inside a while:
                        //  while (!condition) { mon.wait(); }
                        lock.wait(10 * 1000);
                    } catch (InterruptedException ignore) {
                    }
                    System.out.println("Thread1 done");
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("Thread2 acquired lock");
                }
                System.out.println("Thread2 done");
            }
        });
        thread2.start();
    }

    /*
     * - sleep() is used to suspend the exection of a thread, so that CPU can
     * be given to other thread
     * - it does not releases the lock on current object
     */
    private static void testSleep() {
        final Object lock = new Object();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("Thread1 acquired lock and sleeping now...");
                    try {
                        Thread.sleep(10 * 1000);
                    } catch (InterruptedException ignore) {
                    }
                    System.out.println("Thread1 done");
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("Thread2 acquired lock");
                }
                System.out.println("Thread2 done");
            }
        });
        thread2.start();
    }

    public static void main(String args[]) {
        //Deadlock.testWait();
        //Deadlock.testSleep();
        //Deadlock.testDeadlock();
        Deadlock.sleepMethod1();
    }
}

package ch2;

public class Singleton {

    
    // need volatile here because reader threads do not lock and they could
    // get an outdated value if another thread is waiting to execute the
    // getSingletonObject() method
    private static volatile Singleton singleton_object;
    // volatile: do not cache it, read it from the main memory
    // one master copy of the field for all threads that access it
    // read/writes to/from atomic data types (int, boolean) only needs
    //to use volatile (no synchronization is required)
    private volatile int counterValue;

    private Singleton() {
    }

    // synchronized: avoid simultaneous access from different threads 
    public static synchronized Singleton getSingletonObject() {
        if (singleton_object == null) {
            singleton_object = new Singleton();
        }
        return singleton_object;
    }

    public int getCounter() {
        return counterValue;
    }

    public void incrementCounter() {
        ++counterValue;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static void main(String args[]) {
        Singleton obj1 = Singleton.getSingletonObject();
        Singleton obj2 = Singleton.getSingletonObject();
        System.out.println(obj1.getCounter());
        System.out.println(obj2.getCounter());
        obj1.incrementCounter();
        System.out.println(obj1.getCounter());
        System.out.println(obj2.getCounter());
    }
}

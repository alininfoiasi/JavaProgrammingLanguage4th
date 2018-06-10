package extra.thread;

class LightThread extends Thread{
	private LightMonitor lightMonitor = null;
	
	public LightThread(LightMonitor lm) {
		this.lightMonitor = lm;
	}
	
	public void run() {
		try {
			lightMonitor.correctMethod();
			//lightMonitor.wrongMethod();
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class LightMonitor {
	// resources
	// using volatile avoid local cache copies for each thread (if using only atomic operations on it)
	// otherwise, use with synchronize
	private volatile int value = 0;
	// volatile is not enough (no atomic operations on it); always use synchronize for updating it
	private long counter = 0;
	// light monitors
	private static Object valueMonitor = new Object();
	private static Object counterMonitor = new Object();
	
	public LightMonitor() {
	}
	
	public void wrongMethod() {
		// BAD
		value+=10;
		// no common resource accessed here
		System.out.println("Start...");
		// gain a lock on counter (we state that only counter will be accessed, but not value)
		synchronized(counterMonitor) {	
			counter++;
		}
		// BAD
		value-=10;
		// gain a lock on counter (we state that only counter will be accessed, but not value), which is false here
		synchronized(counterMonitor) {
			System.out.println("Data: value=" + value + " counter=" + counter);
		}
		// no common resource accessed here
		System.out.println("Stop.");
		System.out.println();
	}
	
	public void correctMethod() {
		// no common resource accessed here
		System.out.println("Start...");
		// gain a lock on value (we state that only id will be accessed, but not counter)
		synchronized(valueMonitor) {
			// gain also a lock on counter
			synchronized(counterMonitor) {	
				value+=10;
				counter++;
				value-=10;
				System.out.println("Data: value=" + value + " counter=" + counter);
			}
		}
		// no common resource accessed here
		System.out.println("Stop.");
		System.out.println();
	}
	
	public static void main(String args[]) {
		LightMonitor lmA = new LightMonitor();
		LightMonitor lmB = new LightMonitor();
		LightMonitor lmC = new LightMonitor();
		LightThread lt1 = new LightThread(lmA);
		LightThread lt2 = new LightThread(lmB);
		LightThread lt3 = new LightThread(lmB);
		LightThread lt4 = new LightThread(lmC);
		LightThread lt5 = new LightThread(lmC);
		LightThread lt6 = new LightThread(lmC);
		lt1.start();
		lt2.start();
		lt3.start();
		lt4.start();
		lt5.start();
		lt6.start();
	}
}

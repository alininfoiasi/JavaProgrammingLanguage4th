package extra.thread;

class VThread extends Thread{
	private Example ex= null;

	public VThread(Example x) {
		ex = x;
	}

	public void run() {
		try {
			ex.setValue(-ex.getValue());
			ex.increment();
			ex.printInfo();
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

interface Example {
	public int getValue();
	public void setValue(int v);
	public boolean checkValue(int v);
	public void doubleValue();
	public void increment();
	public void printInfo();
}

class BadExample implements Example {
	private static int value = 1;
	private static long counter;

	// value should be volatile
	public int getValue(){
		return value;
	}
	
	// value should be volatile, for the last update to be available to all threads 
	// volatile is enough, the new value does not depend on the current value
	public void setValue(int v){
		value = v;
	}
	
	// doesn't require synchronization; we only check the value, which should be volatile
	public boolean checkValue(int v){
		return ( (value == v) ? true: false );	
	}
	
	// volatile is not enough, the new value depends on the current value
	public void doubleValue(){
		value *= 2;
	}
	
	// not an atomic operation; should be synchronized
	public void increment(){
		counter++;
	}

	public void printInfo(){
		System.out.println("Bad - Value: " + value + "; counter: " + counter);
	}
}

class GoodExample implements Example {
	private static volatile int value = 1;
	private static volatile long counter;

	
	public int getValue(){
		return value;
	}
	
	// doesn't require synchronization; the last update will be available to all threads 
	public void setValue(int v){
		value = v;
	}

	// doesn't require synchronization; we only check the value 
	public boolean checkValue(int v){
		return ( (value == v) ? true: false );
	}
	
	// requires synchronization, the new value depends on the current value
	public synchronized void doubleValue(){
		value *= 2;
	}
		
	// synchronized operation, because it is not atomic
	public synchronized void increment(){
		counter++;
	}

	public void printInfo(){
		System.out.println("Good - Value: " + value + "; counter: " + counter);
	}
}

public class VolatileUsage {
	public static void main(String args[]) {
		Example ex1 = new BadExample();
		Example ex2 = new BadExample();
		Example ex3 = new BadExample();
		Example ex4 = new BadExample();
		
		VThread t1 = new VThread(ex1);
		VThread t2 = new VThread(ex2);
		VThread t3 = new VThread(ex3);
		VThread t4 = new VThread(ex4);
		t1.start();
		t2.start();
		t3.start();
		t4.start();	
	}
}
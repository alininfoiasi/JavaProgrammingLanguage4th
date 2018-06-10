package extra.thread;

class MyBuffer {
	private double currentNumber = -1.0;
	private boolean available = false;
	
	// block the access to the current object when executed
	public synchronized double get() {
		while (!available) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		available = false;
		notifyAll();
		return currentNumber;
	}
	
	// block the access to the current object when executed
	public synchronized void set(double number) {
		while (available) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.currentNumber = number;
		available = true;
		notifyAll();
	}
}

class Producer extends Thread {
	private MyBuffer myBuffer = null;
	
	public Producer(MyBuffer buffer) {
		myBuffer = buffer;
	}
	
	public void run() {
		double value = Math.random();
		for (int i=0; i<10; i++) {
			value = i*100;
			myBuffer.set(value);
			System.out.println("We produce " + value);
			try {
				sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	private MyBuffer myBuffer = null;
	
	public Consumer(MyBuffer buffer) {
		myBuffer = buffer;
	}
	
	public void run() {
		double value = Math.random();
		for (int i=0; i<10; i++) {
			value = myBuffer.get();
			System.out.println("We consume " + value);
			try {
				sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


public class ProducerConsumer {

	public static void main(String args[]) {
		MyBuffer myBuffer = new MyBuffer();
		Producer p1 = new Producer(myBuffer);
		Consumer c1 = new Consumer(myBuffer);
		p1.start();
		c1.start();
	}
}

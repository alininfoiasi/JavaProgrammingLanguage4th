package extra.thread;

class ThreadExample1 implements Runnable {

	public void run() {
		System.out.println("*******************************************");
		try {
			while(true){
				// give the possibility for other threads to be executed
				Thread.sleep(10);
				// OR
				// give the possibility for other threads of the same or higher priority to be executed
				//Thread.yield();
				System.out.println(Math.random());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

class ThreadExample2 extends Thread {
	private boolean stillRunning = true;
	
	public void toggleRunning() {
		stillRunning = (stillRunning==true) ? false:true; 
	}
	
	public void run() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
		try {
			while(stillRunning){
				
				System.out.println(Math.random());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

public class ThreadExample implements Runnable {

	public void run() {
		System.out.println("-----------------------------------------------------");
		try {
			for(int i=0;i<100;i++){
				Thread.sleep(10);
				System.out.println(i);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		
		ThreadExample1 tex11 = new ThreadExample1();
		Thread t3 = new Thread(tex11);
		// t3 is 
		t3.setDaemon(true);
		t3.start();
		
		ThreadExample2 tex21 = new ThreadExample2();
		tex21.start();
		tex21.toggleRunning();
		
		ThreadExample tex1 = new ThreadExample();
		Thread t1 = new Thread(tex1);
		ThreadExample tex2 = new ThreadExample();
		Thread t2 = new Thread(tex2);
		t1.start();
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		t2.setPriority(Thread.MAX_PRIORITY);
		
	}
}

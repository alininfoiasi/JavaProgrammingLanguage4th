package extra.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Experiment{

	public volatile long totalThreads=0;
	public volatile long count=0;
	public volatile long currentCount=0;
	// parallelization capability of the system (use 1, 10, 100)
	public static final int MAXThreads = 10;
	public static final int SIZE = 50;

	public Experiment(){
	}

	public synchronized void updateTotalThreads(long value){
		totalThreads+=value;
		//System.out.println("totalThreads=" + totalThreads);
	}

	public synchronized void updateCurrentCount(long value){
		currentCount+=value;
		//System.out.println("totalThreads=" + currentCount);
	}

	public long getCurrentCount(){
		return currentCount;
	}

	// simulation of the system
	public void startSystem(){
		// MAXThreads is the maximum parallel capacity of our system
		ExecutorService executor = Executors.newFixedThreadPool(MAXThreads);
		// simulate the arrival of all ratings
		while (count<SIZE)
		{
			Runnable worker = new RunThread(this, count);
			executor.execute(worker);
			count++;
		}
		// This will make the executor accept no new threads
		// and finish all existing threads in the queue
		executor.shutdown();
		// Wait until all threads are finish
		while (!executor.isTerminated()) {
		}
		System.out.println("Simulation - done!");
	}

	public static void main(String args[]){
		Experiment experiment = new Experiment();
		experiment.startSystem();
	}
}



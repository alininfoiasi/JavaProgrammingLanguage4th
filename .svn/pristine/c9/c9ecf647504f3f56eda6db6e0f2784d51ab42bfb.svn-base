package extra.thread;


public class RunThread implements Runnable{
	private Experiment experiment;
	private long id;
	private long time = 0;
	private long count = 0;

	public RunThread(Experiment experiment, long id) {
		super();
		this.experiment = experiment;
		this.id = id;
	}

	public long getCount(){
	    return count;
	  }
	
	public long getTime(){
	    return time;
	  }
	
	public static void waiting (int seconds){
		long t0, t1;
		t0 =  System.currentTimeMillis();
		do{
			t1 = System.currentTimeMillis();
		}while ((t1 - t0) < (seconds * 1000));
	}
	
	public void run() {
		System.out.println("Start thread id:" + id);
		try {
			// http://www.vogella.com/articles/JavaConcurrency/article.html
			waiting(10);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		System.out.println("Finish thread id:" + id);
		// update variables for statistics
		experiment.updateTotalThreads(1);
		experiment.updateCurrentCount(1);
	}
}

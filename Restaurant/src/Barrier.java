public class Barrier {

	private final int MAX_THREADS_TO_SYNCHRONIZE;
	private int count; // threads that have 'arrived' thus far

	public Barrier(int max) {
		MAX_THREADS_TO_SYNCHRONIZE = max;
		count = 0;
	}

	public synchronized void waitForOthers() {
		while (count < MAX_THREADS_TO_SYNCHRONIZE - 1) {
			try {
				count++;
				//System.out.println("count = " + count);
				wait();
			} catch (InterruptedException e) {
			}
		}
		count = MAX_THREADS_TO_SYNCHRONIZE;
		notifyAll();
		//System.out.println("count = " + count);

	}

}

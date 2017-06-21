
public class DiningThread extends Thread {

	private Barrier barrier;
	private String task; // e.g. "Task A"
	private int id;

	public DiningThread(Barrier b, String work, int threadid) {
		barrier = b;
		task = work;
		id = threadid;

	}

	public void run() {
		System.out.println("I am thread " + id  + ", working on " + task + ", and waiting to eat.");
		barrier.waitForOthers();
		System.out.println("I am thread " + id  + ", and I am eating");
	}

	public static void main(String[] args) throws InterruptedException {

		Barrier b = new Barrier(4); // 4 threads must be synchronized

		// create DiningThread objects

		DiningThread firstThread = new DiningThread(b, "Task A", 1);
		DiningThread secondThread = new DiningThread(b, "Task B", 2);
		DiningThread thirdThread = new DiningThread(b, "Task C", 3);
		DiningThread fourthThread = new DiningThread(b, "Task D", 4);

		// start them
		firstThread.start();
		secondThread.start();
		thirdThread.start();
		fourthThread.start();

		// join them
		try {
			firstThread.join();
			secondThread.join();
			thirdThread.join();
			fourthThread.join();
		} catch (InterruptedException e) {
			System.out.println(e);
		}

	}
}

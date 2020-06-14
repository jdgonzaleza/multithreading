package threading.pool;

public class Worker implements Runnable {
	private int id;

	public Worker(int id) {
		this.id = id;
	}
	@Override
	public void run() {
		System.out.println("Starting worker: " + id);
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
		}
		System.out.println("Completed worker: " + id);
	}
}

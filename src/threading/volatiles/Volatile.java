package threading.volatiles;

public class Volatile {
	public static void main(String[] args) throws InterruptedException {
		Runner r1 = new Runner();
		r1.start();

		r1.shutdown();

	}
}

class Runner extends Thread {
	private boolean running = true;
	public void run() {
		while(running) {
			System.out.println("Inside while loop 😄");

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void shutdown() {
		running = false;
	}
}
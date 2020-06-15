package threading.producerconsumer;

import java.security.SecureRandomParameters;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<Integer> q;

	public Consumer(BlockingQueue<Integer> q) {
		this.q = q;
	}

	@Override
	public void run() {
		Random random = new Random();

		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if(random.nextInt(10) == 0) {
				try {
					Integer value = q.take();
					System.out.println("Taken value: " + value+ " ; Queue size: " + q.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

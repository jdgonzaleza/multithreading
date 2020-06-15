package threading.producerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	private BlockingQueue<Integer> q;

	public Producer(BlockingQueue<Integer> q)  {
		this.q = q;
	}

	public void run() {
		Random random = new Random();
		while(true) {
			try {
				q.put(random.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

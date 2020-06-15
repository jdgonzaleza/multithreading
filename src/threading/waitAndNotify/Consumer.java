package threading.waitAndNotify;

import java.util.Queue;
import java.util.Random;

public class Consumer implements Runnable {
	private Queue<Integer> queue;

	public Consumer(Queue<Integer> queue) {
		this.queue = queue;
	}

	public void run(){
		while (true) {
			synchronized (queue) {
				while(queue.size() == 0) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("List size is: " + queue.size());
				int value = queue.poll();
				System.out.println("; value is: " + value);
				queue.notify();
			}
			Random random = new Random();
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

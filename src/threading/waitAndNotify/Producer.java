package threading.waitAndNotify;

import java.util.Queue;

public class Producer implements Runnable {
	private Queue<Integer> queue;

	public Producer(Queue<Integer> queue) {
		this.queue = queue;
	}
	public void run() {
		int value = 0;
		while (true) {
			synchronized (queue) {
				while(queue.size() == App.LIMIT) {
					try {
						queue.wait();
					} catch (InterruptedException e) {
					}
				}
				queue.add(value++);
				queue.notify();
			}
		}
	}
}

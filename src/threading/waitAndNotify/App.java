package threading.waitAndNotify;

import java.util.LinkedList;
import java.util.Queue;

public class App {
	private static Queue<Integer> queue = new LinkedList<>();
	public static final int LIMIT = 10;
	public static void main(String[] args) {
		Thread consumer = new Thread(new Consumer(queue));
		Thread producer = new Thread(new Producer(queue));

		producer.start();
		consumer.start();

		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

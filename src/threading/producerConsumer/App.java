package threading.producerConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
	private static BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);
	public static void main(String[] args) throws InterruptedException {
		Thread producer = new Thread(new Producer(q));
		Thread consumer = new Thread(new Consumer(q));

		producer.start();
		consumer.start();

		producer.join();
		consumer.join();
	}
}

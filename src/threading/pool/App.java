package threading.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for(int i = 0; i<10; i ++) {
			executor.submit(new Worker(i));
		}
		executor.shutdown();

		try {
			executor.awaitTermination(30, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

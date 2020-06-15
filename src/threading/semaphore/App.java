package threading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i = 0; i<200; i++) {
			executor.submit(() -> Connection.getInstance().connect());
		}
		executor.shutdown();
		executor.awaitTermination(100, TimeUnit.SECONDS);
	}
}

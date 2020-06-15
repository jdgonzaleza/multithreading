package threading.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);

		ExecutorService service = Executors.newFixedThreadPool(3);
		for(int i = 0 ; i<3; i++) {
			service.submit(new Worker(latch));
		}
		service.shutdown();

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		System.out.println("Completed");
	}
}

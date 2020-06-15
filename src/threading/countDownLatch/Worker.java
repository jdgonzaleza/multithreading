package threading.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{
	private CountDownLatch latch;

	public Worker(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		System.out.println("Starting");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		latch.countDown();
	}
}

package threading.reentrantLocks;

import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();

	private void increment() {
		for(int i = 0; i < 10000; i++) {
			count++;
		}
	}

	public void firstThread() throws InterruptedException {
		lock.lock();

		System.out.println("waiting");
		cond.await();

		System.out.println("resume...");

		try{
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void secondThread() throws InterruptedException {
		Thread.sleep(1000);
		lock.lock();

		Thread.sleep(500);
		System.out.println("Time to get back!");

		cond.signal();

		try {
			increment();
		} finally {
			lock.unlock();
		}
	}

	public void finish() {
		System.out.println("count: " + count);
	}
}

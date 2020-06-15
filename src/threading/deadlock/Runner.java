package threading.deadlock;

import javax.sound.sampled.SourceDataLine;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	private Lock l1 = new ReentrantLock();
	private Lock l2 = new ReentrantLock();

	private Account ac1 = new Account();
	private Account ac2 = new Account();

	private void acquireLock(Lock l1, Lock l2) {
		while (true) {
			boolean gotL1 = false;
			boolean gotL2 = false;

			try {
				gotL1 = l1.tryLock();
				gotL2 = l2.tryLock();
			} finally {
				if (gotL1 && gotL2) {
					return;
				}
				if (gotL1) {
					l1.unlock();
				}
				if (gotL2 ) {
					l2.unlock();
				}
			}
		}
	}

	public void firstThread() {
		Random random = new Random();

		for(int i = 0; i < 100000; i++) {
			acquireLock(l1, l2);
			try {
				Account.transfer(ac1, ac2, random.nextInt(100));
			} finally {
				l1.unlock();
				l2.unlock();
			}
		}
	}

	public void secondThread() {
		Random random = new Random();

		for(int i = 0; i < 100000; i++) {
			acquireLock(l2, l1);
			try {
				Account.transfer(ac2, ac1, random.nextInt(100));
			} finally {
				l2.unlock();
				l1.unlock();
			}
		}
	}

	public void finish() {
		System.out.println("Account 1 balance: " + ac1.balance);
		System.out.println("Account 2 balance: " + ac2.balance);
		System.out.println("Total balance: " + (ac1.balance + ac2.balance));
	}
}

package threading.synchro;

public class Sync {
	private int count = 0;

	public static void main(String[] args) {
		Sync app = new Sync();
		app.doSomething();
	}

	public synchronized void increment() {
		count++;
	}

	public void doSomething() {
		Thread t1 = new Thread(() -> {
			for(int i = 0; i<10000; i++) {
				increment();
			}
		});

		Thread t2 = new Thread(() -> {
			for(int i = 0; i<10000; i++) {
				increment();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(count);
	}
}

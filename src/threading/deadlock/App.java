package threading.deadlock;


public class App {
	static Runner runner = new Runner();

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread( () -> runner.firstThread() );
		Thread t2 = new Thread( () -> runner.secondThread() );

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		runner.finish();
	}
}

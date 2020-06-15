package threading.basicThread;

public class StartingThread {

	public static void main(String[] args) {

		Thread t1 = new Thread( () -> {
			for(int i = 0; i < 10; i++) {
				System.out.println("Hello from t1 " + i);
			}
		} );

		Thread t2 = new Thread( () -> {
			for(int i = 0; i < 10; i++) {
				System.out.println("Hello from t2 " + i);
			}
		} );

		t1.start();
		t2.start();
	}
}

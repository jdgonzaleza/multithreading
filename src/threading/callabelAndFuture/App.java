package threading.callabelAndFuture;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;
import java.util.concurrent.*;

public class App {


	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Integer> future = executor.submit( () -> {
			System.out.println("Starting...");
			Random random = new Random();
			int duration = random.nextInt(2000);
			Thread.sleep(duration);
			return duration;
		});
		executor.shutdown();
		System.out.println(future.get());
	}


}

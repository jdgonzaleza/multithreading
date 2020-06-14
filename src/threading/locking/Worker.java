package threading.locking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker {

	private static List<Integer> list1 = new ArrayList<>();
	private static List<Integer> list2 = new ArrayList<>();
	private static Random random = new Random();
	public static void main(String[] args) {
		System.out.println("Starting at...");
		long start = System.currentTimeMillis();

		Thread t1 = new Thread(() -> process() );
		Thread t2 = new Thread(() -> process() );

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start));
		System.out.println("list 1: " + list1.size() + " list 2: " + list2.size());
	}

	public static void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (list1){
			list1.add(random.nextInt(100));
		}
	}

	public static void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (list2) {
			list2.add(random.nextInt(100));
		}
	}

	public static void process() {
		for(int i = 0; i<1000; i++) {
			stageOne();
			stageTwo();
		}
	}

}

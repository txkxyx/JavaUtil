package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 10; i++) {
			final int index = i;
			System.out.println("Index:" + index);
			executor.execute(new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep(100);
						System.out.println("Thread:" + Thread.currentThread().getId() + "*** Index:" + index) ;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
		}
		System.out.println("Sleeping..."
		        + Thread.currentThread().getId());
	      try {
			Thread.sleep(15 * 1000);
			System.out.println("Close...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

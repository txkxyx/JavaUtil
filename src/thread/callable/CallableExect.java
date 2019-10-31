package thread.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExect {

	public static void main(String[] args)  {
		ExecutorService executor = Executors.newFixedThreadPool(3);

		List<Future<String>> resultList = new ArrayList<Future<String>>();

		System.out.println("Task Start");
		for (int i = 0; i < 10; i++) {
			CallableObject object = new CallableObject(i, "Thread" + i);
			resultList.add(executor.submit(object));
		}
		System.out.println("Task End");

		for (Future<String> future : resultList) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}

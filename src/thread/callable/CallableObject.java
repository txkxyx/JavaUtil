package thread.callable;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class  CallableObject implements Callable<String>{

	private int id;
	private String name;

	public CallableObject(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.println("Thead ID:" + id + " Start");

		Thread.sleep(1000);

		LocalDateTime now = LocalDateTime.now();
		String result = this.name + "_" + now.toString();

		System.out.println("Thead ID:" + id + "End");
		return result;
	}

}

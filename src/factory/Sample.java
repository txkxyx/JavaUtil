package factory;

import factory.model.Computer;

public class Sample {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("PC", "10", "126", "8");
		Computer server = ComputerFactory.getComputer("Server", "20", "256", "16");
		System.out.println("PC:" + pc);
		System.out.println("Server:" + server);
	}
}

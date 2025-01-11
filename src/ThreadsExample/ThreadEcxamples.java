package ThreadsExample;

class Threads extends Thread {
	public void run() {
		System.out.println("Threads..........");
	}
}

public class ThreadEcxamples {

	public static void main(String[] args) {
		Threads t = new Threads();
		t.setDaemon(true);
		t.setDaemon(false);
		t.start();
		t.setDaemon(false);
	}
}

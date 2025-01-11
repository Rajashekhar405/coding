package ThreadsExample;

public class CreatngThreads {

	public static void main(String[] args) {
		MyThread t1 = new MyThread();
		t1.start();
		
		 MyThread1 thread = new MyThread1();
		 Thread t2 = new Thread(thread);
		 t2.start();
	}
}

class MyThread extends Thread {
	
	@Override
	public	void run() {
		for(int i=100; i<200; i++) {
			System.out.println("Hello="+i);
		}
	}
}

class MyThread1 implements Runnable {

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
		System.out.println("Hi="+i);
	}
	}
}

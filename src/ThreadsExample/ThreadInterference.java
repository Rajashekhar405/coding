package ThreadsExample;

class Shared {
	volatile int i;
	void shared() {
		i=10;
		System.out.println(i);
		i=20;
		System.out.println(i);
		i=30;
		System.out.println(i);
	}
}

public class ThreadInterference {

	public static void main(String[] args) {
		Shared s1 = new Shared();
		Thread t1 = new Thread() {
			public void run() {
				s1.shared();
			}
		};
		
		final Thread t2 = new Thread() {
			public void run() {
				s1.shared();
			}
		};
		
		t1.start();
		t2.start();
	}
}

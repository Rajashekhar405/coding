package ThreadsExample;

public class JOiningThreadsExample {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main thread started : Task is to print numbers from 0 to 30");
		
		Thread t1 = new Thread() {
			public void run() {
				try {
					Thread.sleep(300, 500000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				for(int i=0;i<1000;i++) {
					System.out.println(i);
				}
				System.out.println("Numbers from 0 to 10 are printed");
			}
		};
		
		Thread t2= new Thread() {
			public void run() {
				try {
					t1.join(5000, 500000);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				for(int i=1000; i<2000; i++) {
					System.out.println(i);
				}
				System.out.println("Numbers from 11 to 20 are printed");
			}
		};
		
		Thread t3 = new Thread() {
			public void run() {
				try {
					t2.join(5000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				for(int i=2000; i<3000; i++) {
					System.out.println(i);
				}
				System.out.println("Numbers from 21 to 30 are printed");
			}
		};
		t3.join();
		t3.start();
		t2.start();
		t1.start();
		
		System.out.println("Task is finished");
	}
}

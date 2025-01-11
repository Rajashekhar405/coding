package ThreadsExample;

class SleepingThread extends Thread {
	public SleepingThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 0; i <= 100; i++)
        {
			System.out.println("before sleeping...............");
			try {
				sleep(5000);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println("after sleeping.........");
            System.out.println(i);
        }
	}
}

public class SleepingExample {

	public static void main(String[] args) {
		SleepingThread st = new SleepingThread("myThread");
		st.start();
//		System.out.println("before sleeping...............");
//		try {
//			st.sleep(5000);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		System.out.println("after sleeping.........");
	}
}

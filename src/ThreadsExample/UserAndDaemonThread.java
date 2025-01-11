package ThreadsExample;

class UserThread extends Thread {
	@Override
	public void run() {
		System.out.println(getId() +" is running");
		System.out.println("user thread...................");
	}
}

class DaemonThread extends Thread {
	public DaemonThread() {
		setDaemon(true);
	}
	public void run() {
		for(int i=0;i<100;i++) {
			
			System.out.println("Daemon Thread............."+i);
		}
	}
}

public class UserAndDaemonThread {

	public static void main(String[] args) {
		DaemonThread dt = new DaemonThread();
		dt.start();
		UserThread ut = new UserThread();
		ut.setName("USER THREAD");
		System.out.println(ut.getName());
		ut.start();
		
		Thread tt = Thread.currentThread();
		tt.setName("Hello");
		System.out.println("Thrad ID :: " + tt.getId());
		System.out.println(tt.getName());
		System.out.println(tt.getPriority());
		
		System.out.println(Thread.MIN_PRIORITY);
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.NORM_PRIORITY);
		
		System.out.println("BFEFORE SLEEPING............");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("AFTER SLEEPING");
	}
}

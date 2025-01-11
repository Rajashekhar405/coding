package ThreadsExample;

public class DefiningThreads {

	//
	static class Thread3 extends Thread {
		public void run() {
			System.out.println("inside thread static innier class");
		}
	}
	
	static class ThreadRunnable implements Runnable {
		public void run() {
			System.out.println("from runnable interface, static inner class");
		}
	}
	
	
	 class Thread4 extends Thread {
		public void run() {
			System.out.println("non static inner class");
		}
	}
	
	class Thread5 implements Runnable {

		@Override
		public void run() {
			System.out.println("non static thread from runnable interface");
		}
		
	}
	
	public static void main(String[] args) {
		UsageClassOne one= new UsageClassOne();
		one.method();
		UsegeClassTwo two= new UsegeClassTwo();
		two.method();
		
		Thread3 t3 = new Thread3();
		t3.start();

		ThreadRunnable tr = new ThreadRunnable();
		Thread tr1 = new Thread(tr);
		tr1.start();
		
		//Thread4 t4 = new Thread4();
		//t4.start();
		
		//Thread5 t5 = new Thread5();
		Thread t55 = new Thread();
		t55.start();
		
		class Thread6 extends Thread {
			public void run() {
				System.out.println("inside local thread");
			}
		}
		class Thread7 implements Runnable {

			@Override
			public void run() {
				System.out.println("insiede local thread runnable interface");
			}
			
		}
		
		new Thread() {
			public void run() {
				System.out.println("anonymous thread");
			}
		}.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("runnable interface from anonymuous inner class");	
			}
		}).start();
	}
	
}


//type 1
class MyThreadt1 extends Thread{
	public void run() {
		System.out.println("Keep Sometask here");
	}
}

class UsageClassOne{
	void method() {
		MyThreadt1 t1 = new MyThreadt1();
		t1.start();
	}
}

class UsegeClassTwo {
	void method() {
		MyThreadt1 t1 = new MyThreadt1();
		t1.start();
	}
}



package ThreadsExample;

class SharedExample {

	// we can achive thread interference using final keyword, volatile and synchronized keyword at method level
	int i;
	public void SharedMethod() {
		Thread t = Thread.currentThread();
		 
        for(i = 0; i <= 1000; i++)
        {
            System.out.println(t.getName()+" : "+i);
	}
	}
}
public class ThreadInterference2 {

	public static void main(String[] args) {
		SharedExample s1 = new SharedExample();
		
		final Thread t1 = new Thread() {
			public void run() {
				s1.SharedMethod();
			}
		};
		final Thread t2 = new Thread() {
			public void run() {
				s1.SharedMethod();
			}
		};
		
		t1.start();
		t2.start();
	}
}

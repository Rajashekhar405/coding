package ThreadsExample;

class Employee {
	synchronized void methodOne(Employee e) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + " is executing methodOne");
		System.out.println(t.getName() + " is calling methodTwo");
		e.methodTwo(this);
		System.out.println(t.getName() +" is finished executing methodOne");
	}
	
	synchronized void methodTwo(Employee e) {
		Thread t = Thread.currentThread();
		System.out.println(t.getName() + "is executing methodTwo");
		System.out.println(t.getName() + "is calling methodOne");
		e.methodOne(this);
		System.out.println(t.getId() +" is finished executing methodTwo");
	}
}

public class DeadLockExample {

	public static void main(String[] args) {
		final Employee e1 = new Employee();
		final Employee e2 =new Employee();
		Thread t1 = new Thread() {
			public void run() {
				e1.methodOne(e2);
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				e2.methodTwo(e1);
			}
		};
		
		t1.start();
		t1.getState();
		t2.start();
		t2.getState();
	}
}

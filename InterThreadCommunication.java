package com.multithreading;

// wait()   notify()    notifyAll()

class A {
	int num;
	boolean values = false;

	public synchronized void put(int number) {
		
		while (values) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Put: " + number);
		this.num = number;
		values = true;
		notify();
	}

	public synchronized void get() {
		while (!values) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Get: " + num);
		values = false;
		notify();
	}

}

class Producer implements Runnable {
	A aa;

	public Producer(A a) {
		this.aa = a;
		Thread t1 = new Thread(this, "Producer");
		t1.start();
	}
  
	@Override
	public void run() {
		int i = 0;
		while (true) {
			aa.put(i++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}

class Consumer implements Runnable {
	A obj1;

	public Consumer(A a) {
		this.obj1 = a;
		Thread t2 = new Thread(this, "Consumer");
		t2.start();
	}

	public void run() {

		while (true) {
			obj1.get();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class InterThreadCommunication {
	public static void main(String... args) {
		A a = new A();
		Producer p=new Producer(a);
		//p.startProducing();
		new Consumer(a);

	}

}

package com.multithreading;

//multiple task-- ms word typing  play music listen music 
//ms word whenever typing it check the spelling mistake
//sub process spell check this is called thread
//  use all different core  --instead of using one core in 8 secs
//use all 4 cores to complete the task in 2 secs
//  Asynctask to android
// web application-- client sent request to server using servlet..

// by default one thread that is main thread

class Counter {
	int count;
	public synchronized void increment() {
		count++;
	}
}

public class Multithreading {
	public static void main(String... args) throws InterruptedException{

		Counter c = new Counter();
		Thread t1 = new Thread(() -> {
			for (int index = 0; index < 1000; index++) {
				c.increment();
			}
		});
		
		
		Thread t2 = new Thread(() -> {
			for (int index = 0; index < 1000; index++) {
				c.increment();
			}
		});
		t1.start();
        t2.start();
		t1.join();t2.join();
        System.out.println("count: " + c.count);

//		Thread t = Thread.currentThread();
//		System.out.println(t.getName());
//		Runnable o2 = 
//			()-> 
//			{
//				for (int index = 0; index < 5; index++) {
//					System.out.println("hello");
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//					}
//				}
//			
//		};
//		Thread t1 = new Thread( ()-> {
//			for (int index = 0; index <= 5; index++) {
//				System.out.println("hii");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//				}
//			}
//		
//	});
//	t1.start();
//    try{t1.join();}catch(InterruptedException e) {}
//		Thread t2 = new Thread(o2);
//		t2.start();
//		System.out.println(t1.isAlive());
//		System.out.println(t.isAlive());
//      try{t2.join();}catch(InterruptedException e) {}
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println(t1.isAlive());
//		System.out.println(t.isAlive());
//		System.out.println("main thread is wait till both t1 and t2 to completes");

	}

}

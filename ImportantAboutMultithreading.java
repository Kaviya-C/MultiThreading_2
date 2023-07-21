package com.multithreading;

public class ImportantAboutMultithreading {
	public static void main(String... args) {
		Thread t1 = new Thread();
		t1.start();
		              // t1.start();//ILLEGALTHREADSTATEXCEPTION
		/*
		 * after starting the thread if change into daemon property or again trying to
		 * start the same thread then we will get IllegalThreadStateException
		 * 
		 * 
		 * Exception happens in thread wise not execution wise if thread-1 got exception
		 * mean that thread only terminated abruptly
		 * 
		 * Thread=2 will continue to execute its task
		 * 
		 * 
		 * 7 things about  threads
		 * 
		 * 
		 * Illegalthreadstate exception
		 * exception happens in thread wise not execution wise
		 * if we call run() it will be executed as normal method by main thread
		 * if multiple threads execute same task use Runnable
		 * if multiple threads execute different task
		 * setting priority of thread is not so effective
		 * every thread in java is member of threadgroup 
		 * main threadgroup contains main thread
		 * we can't move thread to new group after creating it
		 */

		Thread t2 = new Thread() {
			public void run() {
				String s = null;
				System.out.println("length: " + s.length());
			}
		};

		Thread t3 = new Thread() {
			public void run() {
				for (int index = 0; index < 6; index++) {
					System.out.println(index);
				}
			}
		};

		t2.start();
		t3.start();
		t3.run();
		
		Thread t4=Thread.currentThread();
		System.out.println(t4.getThreadGroup());

	}

}

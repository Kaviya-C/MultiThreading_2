package com.multithreading;

class MyThread extends Thread {
	private volatile boolean flag = true;

	public void stopRunning() {
		flag = false;
	}

	public void run() {
//		while (flag) {
//			System.out.println("i am running");
//		}
//		System.out.println("i am going to stop..");
		
		while (!Thread.interrupted()) {
			System.out.println("i am running");
		}
		System.out.println("stopped..");
	}
}

public class StopThreadHow {
	public static void main(String... args) {
		MyThread t = new MyThread();

		t.start();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//t.stopRunning();
		t.interrupt();
	}

}

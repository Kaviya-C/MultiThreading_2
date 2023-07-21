package com.multithreading;

// six thread states-- 

//new runnable blocked waiting timed_waiting terminated

class Shared {
	synchronized void method1(Shared s) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s.method2(this);
	}

	synchronized void method2(Shared s) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		s.method1(this);
	}
}

public class ThreadLifeCycle {
	public static void main(String... args) {
		Shared s = new Shared();
		Shared s1 = new Shared();

		Thread t1 = new Thread() {
			public void run() {
				s.method1(s1);
			}
		};

		Thread t2 = new Thread() {
			public void run() {
				s1.method2(s);
			}
		};

		t1.start();
		t2.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Thread.state is Thread inner class State
		// that state is an enum
		// that enum contains all the state of Thread that is thread life cycle

		Thread.State[] states = Thread.State.values();
		for (Thread.State each : states) {
			System.out.println(each);
		}
		Thread t = new Thread();

		System.out.println(t.getState());// NEW STATE

		t.start();

		System.out.println(t.getState());// RUNNABLE STATE

		System.out.println(t1.getState());// BLOCKED STATE

		System.out.println(t2.getState());// BLOCKED STATE
		// Both thread object acquire lock then we get bllocked state

		// -----------WAITING STATE----------------
		// wait() or join()
		Thread t3 = new Thread() {
			public void run() {

				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		Thread t4 = new Thread() {
			public void run() {

				try {
					t3.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t4.start();
		t3.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t4.getState());// WAITING STATE

//-----------TIMED WAITING--------------

		// sleep() wait()with timeout , join()with timeOut

		Thread t5 = new Thread() {
			public void run() {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		t5.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t5.getState());

		// TERMINATED

		Thread t6 = new Thread() 
		{
			public void run()
			{
				for(int index=1;index<10;index++)
				{
					System.out.println(index);
				}
			}

		};
		t6.start();
		
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(t6.getState());

	}

}

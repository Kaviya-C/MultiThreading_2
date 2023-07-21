package com.multithreading;

public class ThreadGroupInMultiThreading {
	public static void main(String... args) {
		ThreadGroup parent = new ThreadGroup("Parent Group");

		Thread t1 = new Thread(parent, "Thread 1");
		Thread t2 = new Thread(parent, "Thread-2");

		ThreadGroup child = new ThreadGroup(parent, "child group");

		Thread t3 = new Thread(child, "Thread-3");

		System.out.println(child.getParent());

		child.setDaemon(true);
		// parent.setDaemon(true);
		System.out.println(parent.isDaemon());
		System.out.println(child.isDaemon());

		parent.setMaxPriority(7);
		// System.out.println(parent.getMaxPriority());

		// active count ---> number of active threads in specified group

		// active group count ---> number of active thread groups in specified group

		ThreadGroup par = new ThreadGroup("my Parent");

		Thread t11 = new Thread(par, "Thread-1") {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};
		t11.start();

		Thread t12 = new Thread(par, "Thread-2") {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};
		t12.start();

		ThreadGroup chi = new ThreadGroup(par, "its child group");

		Thread t13 = new Thread(chi, "Thread-3") {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};
		t13.start();
		System.out.println(par.activeCount());

		System.out.println(par.activeGroupCount());

		System.out.println(chi.activeCount());

		System.out.println(chi.activeGroupCount());

		ThreadGroup pars = new ThreadGroup("my Parent");

		Thread t14 = new Thread(pars, "Thread-1") {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("I got interrupted");
				}
			}

		};
		t14.start();

		Thread t15 = new Thread(pars, "Thread-2") {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("I got interrupted");
				}
			}

		};
		t15.start();
		ThreadGroup chil = new ThreadGroup(pars, "own child");
		pars.interrupt();// interrupting the whole group
		pars.destroy();// destroy the whole

		System.out.println(pars.activeCount());

		System.out.println(pars.activeGroupCount());

		System.out.println("child thread count: " + chil.activeCount());

		System.out.println(chil.activeGroupCount());

		// enumerate() method
		// there are 4 versions in enumerate

		/*
		 * enumerate(Thread[] array) enumerate(Thread[] array,boolean value)
		 * enumerate(ThreadGroup[] array) enumerate(ThreadGroup[] array,boolean values)
		 */

		ThreadGroup tg = new ThreadGroup("Parent");
		Thread th = new Thread(tg, "Thread-1") {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();

				}
			}

		};

		th.start();
		Thread th1 = new Thread(tg, "Thread-2") {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();

				}
			}

		};

		

		ThreadGroup ch = new ThreadGroup(tg, "child");
		Thread th2 = new Thread(ch, "Thread-3") {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		th1.start();
		th2.start();
		
		System.out.println(tg.activeCount());
		
		Thread[] threads=new Thread[tg.activeCount()];
		int noOfActiveThreads=
				tg.enumerate(threads,true);
		System.out.println(noOfActiveThreads);
		for(Thread t:threads)
		{
			System.out.println(t.getName());
		}
		System.out.println(tg.activeGroupCount());
		ThreadGroup[] group=new ThreadGroup[tg.activeGroupCount()];
		int noOfActiveGroup=tg.enumerate(group,true);
		for(ThreadGroup t:group)
		{
			System.out.println(t.getName());
		}
  
	}

}

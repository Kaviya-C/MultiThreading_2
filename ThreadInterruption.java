package com.multithreading;

// thread interruption--- it is a mechanism where thread either sleeping or waiting 
// can be made to stop sleeping or waiting

public class ThreadInterruption
{
	public static void main(String...args)
	{
		Thread t=new Thread()
		{
			public void run()
			{
				
				System.out.println(interrupted());
				interrupt();
				System.out.println(isInterrupted());
				for(int i=0;i<5;i++)
				{
					System.out.println(i);				}
				try 
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println(isInterrupted());
			}
			
		};
		t.start();
//		try
//		{
//			Thread.sleep(1000);
//		}
//		catch(InterruptedException e)
//		{
//			e.printStackTrace();
//		}
		Thread.interrupted();
         t.interrupt();
		System.out.println(Thread.interrupted());
	}

}

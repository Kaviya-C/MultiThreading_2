package com.multithreading;

class OddThread extends Thread
{
	int limits;
	SharedPrinter prints;
	OddThread(int limit,SharedPrinter print)
	{
		this.limits=limit;
		this.prints=print;
	}
	@Override
	public void run()
	{
		int oddNumber =1;
		while(oddNumber <= limits)
		{
			prints.printOdd(oddNumber);
			oddNumber=oddNumber+2;
		}
	}
}

class EvenThread extends Thread
{
	int limits;
	SharedPrinter prints;
	public EvenThread(int limit,SharedPrinter print)
	{
		this.limits=limit;
		this.prints=print;
	}
	@Override
	public void run()
	{
		int even =2;
		while(even <= limits)
		{
			prints.printEven(even);
			even=even+2;
		}
	}
}

class SharedPrinter 
{
	boolean isOddPrinted=false;
	
	synchronized void printOdd(int num)
	{
		while(isOddPrinted)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"  : "+num);
		isOddPrinted=true;
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		notify();
	}
	synchronized void printEven(int num)
	{
		while(!isOddPrinted)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+"  : "+num);
		isOddPrinted=false;
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		notify();
	}
}
public class PrintOddEvenNumbersByTwoThreads
{
	public static void main(String...args)
	{
		SharedPrinter s=new SharedPrinter();
		OddThread od=new OddThread(20,s);
		od.setName(" Odd-Thread");
		EvenThread even=new EvenThread(20,s);
		even.setName(" even-thread");
		od.start();
		even.start();
	}

}

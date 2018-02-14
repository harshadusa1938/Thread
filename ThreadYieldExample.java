package com.statwithjava.threading;

public class ThreadYieldExample {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1("Thread1");
		Thread1 t2 = new Thread1("Thread2");
		
		t1.start();
		t2.start();

	}

}
class Thread1 extends Thread{
	public Thread1(String name) {
		super(name);
	}
	public void run() {
		Thread t = Thread.currentThread(); //Thread 1
	  // System.out.println(t.getName());
	   for(int i=0;i<=10;i++) {
			//System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(t.getName()+" "+i);
		}
	}
}

class Thread2 extends Thread{
	public Thread2(String name) {
		super(name);
	}
	public void run() {
		Thread t = Thread.currentThread(); //Thread 1
	  // System.out.println(t.getName());
	   for(int i=0;i<=20;i++) {
			//System.out.println(Thread.currentThread().getName());
			Thread.yield();
			System.out.println(t.getName()+" "+i);
		}
	}
}
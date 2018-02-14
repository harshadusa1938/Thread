package com.statwithjava.threading;
public class ThreadExampleByRunnable {
	public static void main(String[] args) {
		Thread.currentThread().setPriority(8);
		Thread th1 = new Thread(new TestThread());
		Thread th2 = new Thread(new TestThread());
		Thread th3 = new Thread(new TestThread());
		
		th1.setName("Mythread 1 ");
		th2.setName("Mythread 2");	
		th3.setName("Mythread 3");
		
		th1.start();
		th3.start();
		th2.start();
		
		
		
		System.out.println(Thread.currentThread().getName());
		
		for(int i=0;i<=10;i++) {
		//	System.out.println(Thread.currentThread().getName());
			System.out.println("Main Thread "+i);
		}
	}

}

class TestThread implements Runnable{
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		for(int i=0;i<=10;i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(t.getName()+" "+i+",Priority="+t.getPriority());
		}
	}
	
}
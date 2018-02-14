package com.statwithjava.threading;
class MyThread implements Runnable{
	public void run() {
		System.out.println("Thread Name="+Thread.currentThread().getName());
		for(int i=0;i<100;i++) {
			System.out.println("Child Thread="+i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
public class ThreadDemo {

	public static void main(String[] args) {
		Thread t = new Thread(new MyThread(),"Test");
		t.start();
	
		for(int i=0;i<50;i++) {
			t.interrupt();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Main Thread="+i);
		}
	}

}

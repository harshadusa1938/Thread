package com.statwithjava.threading;

public class ThreadJoinExample {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				Thread t = Thread.currentThread(); //Thread 1
			  // System.out.println(t.getName());
			   for(int i=0;i<=10;i++) {
					//System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(t.getName()+" "+i);
				}
			}
		});
		t1.setName("Thread 1");
		t1.start();
		
		Thread t = Thread.currentThread(); //Main Thread
		
		try {
			t1.join();
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int j=0;j<=10;j++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(t.getName()+" "+j);
		}
	}

}

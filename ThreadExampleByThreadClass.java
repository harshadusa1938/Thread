package com.statwithjava.threading;
public class ThreadExampleByThreadClass {
	public static void main(String[] args) {
		Harshad2 th = new Harshad2();
		//th.start();
	}
}
class Harshad2 extends Thread{
	public void run() {
		for(int i=0;i<=10;i++) {
			//System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Test Thread "+i);
		}
	}
}
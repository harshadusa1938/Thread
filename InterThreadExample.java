package com.statwithjava.threading;
public class InterThreadExample {
	public static void main(String[] args) {
		Buffer b = new Buffer();	
		Producer p = new Producer("Producer",b);
		Consumer c = new Consumer("Consumer",b);	
		
		p.start();
		c.start();
	}
}

class Buffer{
	private int x;
	private boolean produced=false;
	public synchronized void produce(int x) {
		if(produced) {
			System.out.println("Producer need to wait");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.x = x;
		System.out.println("Produce "+x);
		produced=true;
		notify();
	}
	public synchronized void consume() {
		if(!produced) {
			System.out.println("consume need to wait");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Consume "+x);
		produced=false;
		notify();
		
	}
}
class Producer extends Thread{
	Buffer b;
	public Producer(String name,Buffer b) {
		super(name);
		this.b=b;
	}
	public void run() {
		for(int i=1;i<=10;i++) {
		   b.produce(i);	
		}
	}
}
class Consumer extends Thread{
	Buffer b;
	public Consumer(String name,Buffer b) {
		super(name);
		this.b=b;
	}
	public void run() {
		for(int i=1;i<=10;i++) {
		   b.consume();	
		}
	}
}
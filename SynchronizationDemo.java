package com.statwithjava.threading;

class Account{
	private int balance;
	private int accNo;
	
	public Account(int accNo,int balance) {
		super();
		this.accNo=accNo;
		this.balance = balance;
		System.out.println("Account No="+accNo+" with balance "+balance);
	}
	public synchronized void debit(int amt) {
		System.out.println("A/C No="+accNo+" Deposit Amount="+amt);
		balance -=amt;
	}
	public synchronized void credit(int amt) {
		System.out.println("A/C No="+accNo+" Credit Amount="+amt);
		balance +=amt;
		System.out.println("A/C No="+accNo+" Total Balance="+balance);
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	
}
class DebitThread extends Thread{
	private int amt;
	private Account account;
	public DebitThread() {}
	public DebitThread(Account account,int amt) {this.amt=amt;this.account=account;}
	public void run() {
	  synchronized(account) {
		  System.out.println("A/C No="+account.getAccNo()+" Going to debit amount "+amt);
		  if(account.getBalance()<amt) {
			try {
				System.out.println("A/C No="+account.getAccNo()+" Balance is Less. Wait for Credit");
				account.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		 }
	  }	
	  account.debit(amt);
	  System.out.println("A/C No="+account.getAccNo()+" Your Balance is "+account.getBalance());
	}
}
class CreditThread extends Thread{
	private int amt;
	private Account account;
	public CreditThread() {}
	public CreditThread(Account account,int amt) {this.amt=amt;this.account=account;}
	public void run() {	
	 try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	 synchronized(account) {
		 account.credit(amt);
		 System.out.println("A/C No="+account.getAccNo()+" Credit added...");
		 account.notify();
	  }	
	}
}
public class SynchronizationDemo {

	public static void main(String[] args) {
		Account ac1 = new Account(12345,1000);
	//	Account ac2 = new Account(45623,5000);
		
		DebitThread d = new DebitThread(ac1,3000);
		CreditThread c = new CreditThread(ac1,5000);
		
		//DebitThread d2 = new DebitThread(ac2,1000);
		//CreditThread c2 = new CreditThread(ac2,5000);
		
		d.start();
		c.start();
		
		//d2.start();
		//c2.start();
	}

}

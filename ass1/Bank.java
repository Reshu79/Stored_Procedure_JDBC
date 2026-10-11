package ass1;

public class Bank {
	int balance=5000;
	
	synchronized void bank1(int amount) {
		
		if(amount<balance) {
		balance=balance-amount;
		System.out.println("Thread1 executes first");
		System.out.println("balance:"+balance);
		
		}
		else {
			System.out.println("Insufficient balance cant debit");
			System.out.println("balance:"+balance+" only");
		}
	}
	
public static void main(String args[]) {
	Bank b=new Bank();
	Thread a=new Thread(()->{
		b.bank1(4000);
	});
	
	Thread a1=new Thread(()->{
		b.bank1(4000);
	});
	a.start();
	a1.start();
}
}

package ass1;

public class Prod_cons {
	int product=0;
	synchronized void consumer() throws InterruptedException{
		
		System.out.println("consuming....");
		while(product==0) {
		System.out.println("im waiting...");
		wait();
		System.out.println("im unloacked");
		}
		
	}
	synchronized void producer() {
//		System.out.println("Producing....");
		product++;
		notify();
		System.out.println("now thread is unlocked...");
		notifyAll();
		System.out.println("now thread is unlocked...");
	}
	
	
	
	public static void main(String args[]) throws InterruptedException{
		Prod_cons pc=new Prod_cons();
		Thread t1=new Thread(()->{
			try {
				pc.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		Thread t2=new Thread(()->{
			pc.producer();
		});
		
		Thread t3=new Thread(()->{
			try {
				pc.consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();
		t2.start();
		t3.start();
	}

}

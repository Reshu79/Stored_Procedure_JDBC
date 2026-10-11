package ass1;

public class Notified {
	
	synchronized void customer() throws InterruptedException {
		
		
		System.out.println("customer:Food is not ready waiting....");
		wait();
		System.out.println("customer:Food is received.....!Yummy.....");
		}
	synchronized void chef() throws InterruptedException {
		System.out.println("chef:preparing food!!!");
		Thread.sleep(1000);
		notify();
		System.out.println("chef:now food is ready....");
		
		
	}
	
	public static void main(String args[]) throws InterruptedException {
		Notified n=new Notified();
		Thread t1=new Thread(()->{
			try {
				n.customer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();
		
		Thread t2=new Thread(()->{
			try {
				n.chef();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t2.start();
	}
	
	

}

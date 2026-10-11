package ass1;

public class School {
	
	synchronized void student1() throws InterruptedException {
		System.out.println("Waiting for result");
		wait();
		System.out.println("result is published...");
		
	}
	
	synchronized void student2() throws InterruptedException {
		System.out.println("Waiting for result");
		wait();
		System.out.println("result is published...");
	}
	
	synchronized void student3() throws InterruptedException {
		System.out.println("Waiting for result");
		wait();
		System.out.println("result is published...");
	}
	
	synchronized void Teacher() throws InterruptedException {
		System.out.println("Hello students...");
		Thread.sleep(2000);
		notifyAll();
		System.out.println("Im announced....");
		
	}
	
	

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		School s=new School();
		Thread t1=new Thread(()->{
			try {
				s.student1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		Thread t2=new Thread(()->{
			try {
				s.student2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread t3=new Thread(()->{
			try {
				s.student3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();
		t2.start();
		t3.start();
		
		Thread teach=new Thread(()->{
			try {
				s.Teacher();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		teach.start();
		
	}

}

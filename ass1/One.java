package ass1;

public class One extends Thread{
	
	synchronized void thing1() throws InterruptedException {
	    System.out.println("one");
	    System.out.println("two");
	    System.out.println("three");
	    
	  }
	
	synchronized void thing2() throws InterruptedException {
	    System.out.println("apple");
	    System.out.println("banana");
	    System.out.println("citrus");
	    
	  }
	
	public void sleeping() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("hello");
		
	}
	
    
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method 
		One o=new One();
		
		o.sleeping();
		System.out.println(o.getState());
		
		Thread t1=new Thread(()->{
			try {
				o.thing1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println("before start:"+t1.getState());
		
		t1.start();
		t1.join();
		System.out.println("after start:"+t1.getState());
		
		Thread t2=new Thread(()->{
			try {
				o.thing2();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println("Thread2 starts:"+t2.getState());
		t2.start();
        System.out.println("thread2 state:"+t2.getState());
        
        

	}

}

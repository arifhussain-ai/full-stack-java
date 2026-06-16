package Java.MULTITHREADING;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CustomerRequest implements Runnable{
	
	private int requestId;
	
	public CustomerRequest(int requestId) {
		this.requestId = requestId;
	}
	
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() +
					" Processing Request :" + requestId + " at " + LocalDateTime.now());
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()+" Completed Request : "+
					requestId);
		}catch(InterruptedException e) {
			System.out.println("Request Failed: " + requestId);
		}
	}
}

public class Online_Shopping_Requests {
	public static void main(String[] args) {
		ExecutorService thredPool = Executors.newFixedThreadPool(5);
		System.out.println("E-Commerce Server Started...\n");
		for (int i = 1; i <= 20; i++) {
			thredPool.submit(new CustomerRequest(i));
		}
		thredPool.shutdown();
	}

}

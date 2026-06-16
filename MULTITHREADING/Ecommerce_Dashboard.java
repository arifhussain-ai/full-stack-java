package Java.MULTITHREADING;

import java.util.concurrent.CompletableFuture;

public class Ecommerce_Dashboard {
	public static void main(String[] args) {
		  System.out.println("Loading Dashboard....\n");
		  
		  CompletableFuture<String> profileFuture = CompletableFuture.supplyAsync(() ->{
			  try {
				  Thread.sleep(2000);
			  }catch (Exception e) {}
			  return "Profile: Arif Khan";
		  });
		  
		  CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(() ->{
			 try {
				 Thread.sleep(3000);
			 }catch (Exception e) {} 
			 return "Orders : 25 Completed Orders";
		  });
		  
		  CompletableFuture<String> walletFuture = CompletableFuture.supplyAsync(()->{
			  try {
				  Thread.sleep(1500);
			  }catch(Exception e) {}
			  return "Wallet Balance : ₹2500";
		  });
		  
		  CompletableFuture<String> rewardFuture = CompletableFuture.supplyAsync(()->{
			 try {
				 Thread.sleep(1000);
			 }catch(Exception e) {}
			 return "Reward Point : ₹1500";
		  });
		  
		 CompletableFuture.allOf(
				 profileFuture,
				 orderFuture,
				 walletFuture,
				 rewardFuture
				 ).join();
		 
		 System.out.println(profileFuture.join());
		 System.out.println(orderFuture.join());
		 System.out.println(walletFuture.join());
		 System.out.println(rewardFuture.join());
		 
		 System.out.println("\nDashboard Loaded Successfully....");
	}

}

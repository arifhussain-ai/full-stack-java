package Java.Collections;

import java.util.concurrent.ConcurrentHashMap;

class Product {
	private int productID;
	private String productName;
	private int stock ;
	
	public Product(int productId,String productName,int stock) {
		this.productID = productId;
		this.productName = productName;
		this.stock = stock;
	}
	
	public int getProductId(){
		return productID;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public int getStock() {
		return stock;
	}
	
	public synchronized void reduceStock() {
		stock --;
	}
	
	public String toString() {
		return "Product_Id: "+productID+"| Product_Name: "+productName+"| Stock: "+stock;
	}
}

public class Product_Inventory {
	
	private static ConcurrentHashMap<Integer, Product> inventory = new ConcurrentHashMap<Integer, Product>();
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		inventory.put(101,new Product(101,"Laptop",10));
		inventory.put(102, new Product(102, "Mobile", 15));
		inventory.put(103, new Product(103, "Headphone", 20));
		
		Thread customer1 = new Thread(()->{
			Product product = inventory.get(101);
			product.reduceStock();
			System.out.println("Customer-1 Purchased Laptop.");
		});
		
		Thread customer2 = new Thread(()->{
			Product product = inventory.get(102);
			product.reduceStock();
			System.out.println("Customer-2 Purchased Mobile.");
		});
		
		Thread customer3 = new Thread(()->{
			Product product = inventory.get(103);
			product.reduceStock();
			System.out.println("Customer-3 Purchased Headphone.");
		});
		
		customer1.start();
		customer2.start();
		customer3.start();
		
		customer1.join();
		customer2.join();
		customer3.join();
		
		System.out.println("\nCurrent Inventory\n");
		
		inventory.forEach((id,product)->
		System.out.println(product));
	}
}

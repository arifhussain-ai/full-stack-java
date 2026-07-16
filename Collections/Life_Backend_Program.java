package Java.Collections;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
class ProductCache<K,V> extends LinkedHashMap<K,V>{
	private final int capcity;
	
	public ProductCache(int capcity) {
		super(capcity,0.75f,true);
		this.capcity = capcity;
	}
	
    @Override
	public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > capcity;
	}
}

public class Life_Backend_Program {

	public static void main(String[] args) {
		ProductCache<Integer, String> product = new ProductCache<>(3);
		product.put(101, "Laptop");
		product.put(102, "Mobile");
		product.put(103, "Headphone");
		
		System.out.println("Initial Cache: "+product);
		
		product.get(101);
		
		product.put(104, "Mouse");
		System.out.println("Final Cache: "+product);
		
	}
}

package Java.Collections;

import java.util.TreeMap;

class Student{
	private int rank;
	private String name;
	private double percentage;
	
	public Student(int rank, String name, double percentage) {
		this.rank = rank;
		this.name = name;
		this.percentage = percentage;
	}
	
	public String toString() {
		return "Rank: "+rank+"| Name: "+name+"| Percentage: "+percentage+"%";
	}
}

public class Student_Ranking_System {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		TreeMap<Integer, Student> ranking = new TreeMap<>();
		ranking.put(1,new Student(1, "Arif", 89.26));
		ranking.put(3,new Student(3, "Bob", 63.26));
		ranking.put(2,new Student(2, "Arun", 79.25));
		
		System.out.println("\t====Ranking List====");
		ranking.forEach((rank,student)->
		             System.out.println(student));
	}
}

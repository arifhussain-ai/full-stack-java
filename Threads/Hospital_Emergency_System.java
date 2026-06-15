package Java.Threads;

import java.util.PriorityQueue;

class Patient implements Comparable<Patient>{
	private String patient_name;
	private int priority;
	
	
	public Patient(String patient_name, int priority) {
		this.patient_name = patient_name;
		this.priority = priority;
	}
	
	public String getPatient_name() {
		return patient_name;
	}
	
	public int getPriority() {
		return priority;
	}

	@Override
	public int compareTo(Patient other) {
		return Integer.compare(this.priority, other.priority);	
	}
	
	public String toString() {
		return "Name: " + patient_name + " Priority: " + priority;
	}
}

public class Hospital_Emergency_System extends Thread{
	
	public static void main(String[] args) {
		PriorityQueue<Patient> patients = new PriorityQueue<Patient>();
		
		patients.add(new Patient("Arif", 1));
		patients.add(new Patient("Anas", 2));
		patients.add(new Patient("Gulam", 6));
		patients.add(new Patient("Vivek", 3));
		patients.add(new Patient("Krishna", 4));
		patients.add(new Patient("Mursheed", 5));
		
		System.out.println("======Emergency Queue======");
		while(!patients.isEmpty()) {
			Patient patient = patients.poll();
			System.out.println("Treating -> "+ patient);
		}
		
	}

}

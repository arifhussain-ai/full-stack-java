package Java.Collections;

import java.util.PriorityQueue;

class Patient implements Comparable<Patient>{
	private int patientId;
	private String patientName;
	private int priorty;
	
	public Patient(int patientId, String patientName, int priorty) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.priorty = priorty;
	}
	
	public int compareTo(Patient other) {
		return Integer.compare(this.priorty, other.priorty);
	}
	
	public String toString() {
		return "ID: "+patientId+"| PatientName: "+patientName+"| Priorty: "+priorty;
	}
}
public class Hospital_Queue {
	
	public static void main(String[] args) {
		PriorityQueue<Patient> patients = new PriorityQueue<>();
		patients.add(new Patient(101,"Arun",1));
		patients.add(new Patient(103,"Arif",3));
		patients.add(new Patient(104,"Krish",4));
		patients.add(new Patient(102,"Priya",2));
		
		System.out.println("====Emergency Queue====");
		
		while(!patients.isEmpty()) {
			Patient patient = patients.poll();
			System.out.println("Tresting Patient: "+patient);
		}
	}

}

package Java.ArrayList_MiniProject;

import java.util.ArrayList;
import java.util.Scanner;

public class To_Do_Lists_Project_With_ArrayList {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> tasks = new ArrayList<String>();
		boolean is_true = true;
		
		while(is_true) {
			System.out.println("\n---Menu---");
			System.out.println("1:---Add Task---");
			System.out.println("2:---View Task---");
			System.out.println("3:---Remove Task---");
			System.out.println("4:---Exit---");
			System.out.print("\nWhich Operation You Want To Perform: ");
			
			int choice = sc.nextInt();
			sc.nextLine();//Consume one line its only for nextInt()
			
			switch(choice) {
			case 1:
				System.out.print("\nEnter A Task = ");
				String task = sc.nextLine();
				tasks.add(task);
				System.out.println("\nTask Added....");
				break;
				
			case 2:
				System.out.println("\n---Your Tasks---");
				if(tasks.size() == 0) {
					System.out.println("\nList Is Empty....");
				}else {
					for(int i = 0; i < tasks.size(); i++) {
						System.out.println(tasks.get(i));
					}
				}
				break;
				
			case 3:
				System.out.print("\nEnter task number for delete =");
				int index = sc.nextInt();
				index = index - 1;
				if(index < 0 || index > tasks.size()) {
					System.out.println("\nInvail User Input...");
				}else {
					tasks.remove(index);
					System.out.println("\nTask Deleted....");
				}
				break;
			case 4:
				is_true = false;
				System.out.println("\nProgram Exist...");
				break;
				
			default:
				System.out.println("Invail User Input...");
			}
		}
		sc.close();
	}

}

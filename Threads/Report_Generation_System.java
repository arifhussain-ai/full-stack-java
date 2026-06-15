package Java.Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ReportGenerator implements Callable<String>{

	private String reportName;
	
	public ReportGenerator(String reportName) {
		this.reportName = reportName;
	}

	@Override
	public String call() throws Exception{
		Thread.sleep(3000);
		return reportName + " Generated Successfully ";
	}		
}

public class Report_Generation_System {
	public static void main(String[] args) {
		try {
			ExecutorService executor = Executors.newSingleThreadExecutor();
			
			//Object Callable
			ReportGenerator report = new ReportGenerator("Sales Report");
			
			//Submit task
			Future<String> future = executor.submit(report);
			System.out.println("Report is Generating...");
			
			//Get Result
			String result = future.get();
			System.out.println(result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

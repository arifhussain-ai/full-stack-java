package Java.Threads;

import java.time.LocalDateTime;

public class Background_Log_Cleaner extends Thread {
	
	public void run() {
		
		while(true) {
			try {
				System.out.println("[DAEMON] Cleaing Old Logs At: " + LocalDateTime.now());
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				System.out.println("[DEAMON] Cleanup Interrupted");	
			}
		}
	}
	
	public static void main(String[] args) {
		Background_Log_Cleaner cleanup = new Background_Log_Cleaner();
		cleanup.setDaemon(true);
		cleanup.start();
		try {
			for (int i = 1; i < 5; i++) {
				System.out.println("[User] processing request");
				Thread.sleep(2000);
			}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[DEAMON] Application Shutdown");
	}

}

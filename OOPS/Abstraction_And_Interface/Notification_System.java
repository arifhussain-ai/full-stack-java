/*Create an interface Notification with method send().
Implement Email, SMS, and PushNotification.*/

package Java.OOPS.Abstraction_And_Interface;

interface Notification{
	void send(String message);
}

class Email implements Notification{
	public void send(String message) {
		System.out.println("Email sent: " + message);
	}
}

class SMS implements Notification{
	public void send(String message) {
		System.out.println("SMS sent: " + message);
	}
}

class PushNotification implements Notification{
	public void send(String message) {
		String appname = "FlipCart";
		String type = "Alert";
		
		System.out.println("📱" + appname);
		System.out.println("Type: " + type);
		System.out.println("Push Notification: " + message);
		System.out.println("Time: " + java.time.LocalTime.now());
	}
}

public class Notification_System {
	public static void main(String[] args) {
		Notification n;
		
		/*n = new Email();
		n.send("Hello User..");
		
		n = new SMS();
		n.send("OTP 123");*/
		
		n = new PushNotification();
		n.send("Out For Deliverd.");

	}

}

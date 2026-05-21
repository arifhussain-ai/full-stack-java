/*Create a User class where constructor initializes 
username, email, and password. 
Ensure password is at least 6 characters.*/

package Java.OOPS.Constructors;

class User{
	String name;
	String email;
	String password;
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		
		if (password.length() >= 6) {
			this.password = password;
		}else {
			this.password = "defualt123";
		}
	}
	
	void display() {
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
		System.out.println("Password: "+password);
	}
}


public class User_Registration_System {
	public static void main(String[] args) {
		User obj = new User("Arif Khan", 
				"arifhussain-ai@gmail.com",
				"@Arifaiml1234");
		obj.display();
	}

   }

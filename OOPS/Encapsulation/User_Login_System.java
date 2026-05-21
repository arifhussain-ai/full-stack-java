/*Create a User class with username and password.
 *Password must be hidden.*/

package Java.OOPS.Encapsulation;

class User{
	private String username;
	private String password;
	
	public void setName(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		if (password.length() >= 6) {
			this.password = password;
		}else {
			this.password = "@Default123";
		}
	}
	
	public String getName() {
		return username;
	}
	
public String getPassword() {
		return "*******";
	}
}

public class User_Login_System {
	public static void main(String[] args) {
		User u = new User();
		
		u.setName("arifkhan_12");
		u.setPassword("arif@2027");
		
		System.out.println("User Name: " + u.getName());
		System.out.println("Password: "+ u.getPassword());
	}

}

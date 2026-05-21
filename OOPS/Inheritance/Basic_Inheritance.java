/*Create a class Animal with method sound().
Create a subclass Dog that overrides sound().
👉 Print:
Animal sound
Dog barks*/

package Java.OOPS.Inheritance;

class Animal{
	void sound() {
		System.out.println("Animal sound....");
	}
}

class Dog extends Animal{
	void sound() {
		System.out.println("Dog barks....");
	}
}

public class Basic_Inheritance {
	public static void main(String[] args) {
		Animal a = new Animal();
		a.sound();
		Dog d = new Dog();
		d.sound();

	}

}

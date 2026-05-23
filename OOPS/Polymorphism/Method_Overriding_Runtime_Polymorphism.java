/*Create a class Animal with method sound().
Create subclasses Dog and Cat that override this method.*/

package Java.OOPS.Polymorphism;

class Animal{
	void sound() {
		System.out.println("Animal Sound.");
	}
}

class Cat extends Animal{
	void sound() {
		System.out.println("Cat Sound.");
	}
}

class Dog extends Animal{
	void sound() {
		System.out.println("Dog Sound.");
	}
}

public class Method_Overriding_Runtime_Polymorphism {
	public static void main(String[] args) {
		Animal a;
		
		a = new Cat();
		a.sound();
		
		a = new Dog();
		a.sound();
	}

}

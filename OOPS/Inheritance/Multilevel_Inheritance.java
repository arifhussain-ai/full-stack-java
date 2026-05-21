/*Create 3 classes:
A → method display A
B extends A → display B
C extends B → display C*/

package Java.OOPS.Inheritance;

class A{
	void showA() {
		System.out.println("Class A");
	}
}

class B extends A{
	void showB() {
		System.out.println("Class B");
	}
}

class C extends B{
	void showC() {
		System.out.println("Class C");
	}
}
public class Multilevel_Inheritance {
	public static void main(String[] args) {
		C obj = new C();
		
		obj.showA();
		obj.showB();
		obj.showC();
	}

}

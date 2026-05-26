/*Override a method but also call parent method using super.*/

package Java.OOPS.Inheritance;

class Parent{
	void show() {
		System.out.println("Parent Class....");
	}
}

class Child extends Parent{
	void show() {
		super.show();
		System.out.println("Chlid Class....");
	}
}

public class Method_Overriding_super {
	public static void main(String[] args) {
		Child c = new Child();
		c.show();
	}

}

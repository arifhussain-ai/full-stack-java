/*Use parent reference to call child method.*/

package Java.OOPS.Polymorphism;

class Shape{
	void draw() {
		System.out.println("Draw Shape.");
	}
}

class Circle extends Shape{
	void draw() {
		System.out.println("Draw Circle.");
	}
}

public class Polymorphism_with_super_class_reference {
	public static void main(String[] args) {
		Shape obj = new Circle();
		obj.draw();

	}

}

package kk.oops.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();
        Square square = new Square();
        Triangle triangle = new Triangle();
        // Act of representing the same thing in multiple ways.
        shape.area();
        circle.area();
        square.area();
        triangle.area();


        Shape shape1 = new Circle();
        shape1.area();

    }
}

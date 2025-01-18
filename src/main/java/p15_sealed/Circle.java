package p15_sealed;

// Klasa finalna: nie może być rozszerzana
public final class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
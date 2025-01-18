package p15_sealed;

// Klasa sealed: nadal kontroluje dziedziczenie
public sealed class Rectangle extends Shape permits FilledRectangle {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
}
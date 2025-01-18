package p15_sealed;

// Klasa non-sealed: otwarta na dowolne dziedziczenie
public non-sealed class Square extends Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }
}

package p15_sealed;

public sealed class Shape permits Circle, Rectangle, Square {
    // Wspólna logika dla wszystkich kształtów
}
package p04_synchronizacja.v5_synchronizacja_na_zwyklych_obiektach;

public class BrakSrodkow extends Exception {
    private static final long serialVersionUID = 5262944731342409658L;

    public BrakSrodkow() {
        super();
    }

    public BrakSrodkow(String message) {
        super(message);
    }
}

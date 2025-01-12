package p04_synchronizacja.v0_brak_synchronizacji;

public class Konto {
    private final int numer;
    private String wlasciciel;
    private int saldo;

    public Konto(int numer, String wlasciciel, int saldo) {
        if(saldo < 0) {
            throw new IllegalArgumentException("Saldo ujemne");
        }
        this.numer = numer;
        this.setWlasciciel(wlasciciel);
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Konto nr " + numer + ", wł: " + wlasciciel + ", saldo: " + saldo;
    }

    public int getNumer() {
        return numer;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(String wlasciciel) {
        if(wlasciciel == null) {
            throw new IllegalArgumentException("Wlasciciel nieokreślony");
        }
        this.wlasciciel = wlasciciel;
    }

    public int getSaldo() {
        return saldo;
    }

    public void wplata(int kwota) {
        if(kwota <= 0) {
            throw new IllegalArgumentException("Kwota wpłaty nie jest dodatnia");
        }
        saldo += kwota;
    }

    public void wyplata(int kwota) throws BrakSrodkow {
        if(kwota <= 0) {
            throw new IllegalArgumentException("Kwota wypłaty nie jest dodatnia");
        }
        if(kwota > saldo) {
            throw new BrakSrodkow("Za mało środków na koncie nr " + numer);
        }
        saldo -= kwota;
    }

    public void przelew(Konto cel, int kwota) throws BrakSrodkow {
        if(kwota <= 0) {
            throw new IllegalArgumentException("Kwota przelewu nie jest dodatnia");
        }
        if(kwota > saldo) {
            throw new BrakSrodkow("Za mało środków na koncie nr " + numer);
        }
        this.saldo -= kwota;
        cel.saldo += kwota;
    }
}

package p01_klasy;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Osoba {
    private String imie;
    private String nazwisko;
    private LocalDate dataUrodzenia;

    public Osoba(String imie, String nazwisko, LocalDate dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
    }

    public Osoba(String imie, String nazwisko, String dataUrodzenia) {
        this(imie, nazwisko, LocalDate.parse(dataUrodzenia));
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(LocalDate dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public int getWiek() {
        Period czasZycia = Period.between(dataUrodzenia, LocalDate.now());
        return czasZycia.getYears();
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Osoba osoba = (Osoba) o;
        return Objects.equals(imie, osoba.imie) && Objects.equals(nazwisko, osoba.nazwisko) && Objects.equals(dataUrodzenia, osoba.dataUrodzenia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, nazwisko, dataUrodzenia);
    }
}

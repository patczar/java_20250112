package p01_klasy;

import java.time.LocalDate;

public class Program {

    public static void main(String[] args) {
        Osoba a = new Osoba("Ala", "Kowalska", LocalDate.of(1990, 1, 1));
        System.out.println(a);
        System.out.println(a.getImie());
        a.setImie("Alicja");
        System.out.println(a.getImie());
    }
}

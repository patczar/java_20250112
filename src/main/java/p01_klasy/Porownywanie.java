package p01_klasy;

import java.time.LocalDate;

public class Porownywanie {
    public static void main(String[] args) {
        Osoba a = new Osoba("Ala", "Kowalska", LocalDate.of(1990, 1, 1));
        Osoba b = new Osoba("Ala", "Kowalska", LocalDate.of(1990, 1, 1));
        Osoba c = new Osoba("Celina", "Malinowska", LocalDate.of(1990, 1, 1));
        Osoba r = a;

        System.out.println(a);
        System.out.println(r);
        System.out.println(b);
        System.out.println(c);
        System.out.println();

        // == sprawdza tożsamość obiektów, czyli porównuje adresy
        System.out.println("a == a   : " + (a == a));
        System.out.println("a == r   : " + (a == r));
        System.out.println("a == b   : " + (a == b));
        System.out.println("a == c   : " + (a == c));
        System.out.println();

        // .equals porównuje zgodnie z zasadami określonymi przez autora klasy
        // domyślnie (jeśli w klasie nie ma implementacji equals) działa tak jak ==
        System.out.println("a eq a   : " + a.equals(a));
        System.out.println("a eq r   : " + a.equals(r));
        System.out.println("a eq b   : " + a.equals(b));
        System.out.println("a eq c   : " + a.equals(c));
        System.out.println();

        System.out.println(a.hashCode());
        System.out.println(r.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println();

    }
}

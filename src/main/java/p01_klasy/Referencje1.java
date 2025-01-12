package p01_klasy;

import java.time.LocalDate;

public class Referencje1 {

    public static void main(String[] args) {
        Osoba ala = new Osoba("Ala", "Kowalska", LocalDate.of(2000, 2, 3));
        Osoba ola = new Osoba("Ola", "Malinowska", LocalDate.of(2000, 2, 3));
        Konto a = new Konto(1, 1000, ala);
        Konto b = new Konto(2, 2000, ola);

        System.out.println("a: " + a);
        System.out.println("b: " + b);

        Konto c = b;
        System.out.println("c: " + c);
        System.out.println();


        // zmiana wewnątrz obiektu - zmienna c "widzi" tę zmianę
        b.wplata(48);
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println();

        // zmiana samej zmiennej b. b wskazuje na inny obiekt,
        // ale to nie wpływa na c
        b = a;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println();

        // tracimy dowiązanie do konta nr 2
        c = b;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println();

        a = null;
        // teraz zmienna a nie wskazuje na żaden obiekt
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println();

        c = b = a;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);

    }
}

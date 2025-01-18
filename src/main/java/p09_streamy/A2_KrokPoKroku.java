package p09_streamy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class A2_KrokPoKroku {
    static boolean sprawdz(String s) {
        System.out.println("Sprawdzam " + s);
        return s.length() > 3;
    }

    static String mapuj(String s) {
        System.out.println("Mapuję " + s);
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Ala", "Barbara", "Łucja", "Marek", "Andrzej", "Ola", "Żaneta", "Tomasz", "Patryk", "Barbara"));
        System.out.println(list);
        System.out.println();

        // Zasadniczo chcemy uruchomić taki pipeline:
//        list.stream()
//                .filter(A2_KrokPoKroku::sprawdz)
//                .map(A2_KrokPoKroku::mapuj)
//                .forEach(System.out::println);

        // Ale w tym przykładzie wynik każdej kolejnej operacji na strumieniu zapisujemy w pomocniczych zmiennych.
        Stream<String> stream1 = list.stream();
        System.out.println("stream1: " + stream1);
        Stream<String> stream2 = stream1.filter(A2_KrokPoKroku::sprawdz);
        System.out.println("stream2: " + stream2);
        Stream<String> stream3 = stream2.map(A2_KrokPoKroku::mapuj);
        System.out.println("stream3: " + stream3);

        System.out.println("Dodaję dodatkowy element");
        list.add("Ostatni");

        System.out.println("\nTeraz wykonam forEach:\n");
        stream3.forEach(System.out::println);

        try {
            System.out.println("\nPróba ponownego uruchomienia tego samego strumienia:");
            stream3.forEachOrdered(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

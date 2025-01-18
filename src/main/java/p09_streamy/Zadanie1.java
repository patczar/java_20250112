package p09_streamy;

import java.util.List;
import java.util.stream.IntStream;

public class Zadanie1 {
    /* Utwórz listę liczb. Znajdź wszystkie liczby parzyste, podnieś je do kwadratu i zwróć w formie listy liczb.
     */

    public static void main(String[] args) {
        // wersja z listami. od Javy 9 mamy List.of()
        List<Integer> lista = List.of(10, 3, 13, 4, 10, 6, 33, 2, 9, 102, 3);
        System.out.println(lista);

        List<Integer> wyniki = lista.stream()
                .filter(x -> x % 2 == 0)
                .toList(); // w Java < 16  .collect(Collectors.toList()))
        System.out.println(wyniki);

        // wersja tylko na zasadzie utwórz i wypisz:
        // i to będzie na typie IntStream
        IntStream.of(10, 3, 13, 4, 10, 6, 33, 2, 9, 102, 3)
                .filter(x -> x % 2 == 0)
                .forEach(x -> System.out.print(x + ", "));
        System.out.println();
    }
}

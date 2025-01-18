package p09_streamy;

import java.util.stream.Stream;

public class C12b_FlaMapTekstu {

    public static void main(String[] args) {
        Stream<String> linie = Stream.of(
                "Ala ma kota",
                "Ola ma psa",
                "Sierotka ma rysia"
        );

// tutaj powstaje strumień 3 strumieni
//        linie.map(linia -> Stream.of(linia.split("\\s+")))
//                .forEach(System.out::println);

// tutaj powstaje strumień połączonych słów
        linie.flatMap(linia -> Stream.of(linia.split("\\s+")))
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}

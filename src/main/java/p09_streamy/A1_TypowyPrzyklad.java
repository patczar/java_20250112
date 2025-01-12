package p09_streamy;

import java.util.ArrayList;
import java.util.List;

public class A1_TypowyPrzyklad {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Ala", "Barbara", "Łucja", "Marek", "Andrzej", "Ola", "Żaneta", "Tomasz", "Patryk", "Barbara"));
        System.out.println(list);
        System.out.println();

        // To jest "pipeline", na który składają się:
        // - źródło danych
        // - operacje pośrednie (intermediate operation)
        // - operacja końcowa (terminal operation)
        list.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .sorted()
                .distinct()
                .forEach(System.out::println);
    }
}

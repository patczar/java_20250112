package p09_streamy;

import java.util.ArrayList;
import java.util.List;

public class A3_Limit_Par {
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

        list.parallelStream()
                .filter(A3_Limit_Par::sprawdz)
                .map(A3_Limit_Par::mapuj)
                .limit(5)
                .forEach(System.out::println);
        // limit bierze pod uwagę kolejność elementów i w końcowym zbiorze znajdują się wciąż te same osoby,
        // ale forEach nie zachowuje kolejności ich wypisywania
    }
}

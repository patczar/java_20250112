package p09_streamy;

import java.util.ArrayList;
import java.util.List;

public class A3_Limit_ParUnordered {
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
                .unordered()
                .filter(A3_Limit_ParUnordered::sprawdz)
                .map(A3_Limit_ParUnordered::mapuj)
                .limit(5)
                .forEach(System.out::println);
        // teraz limit ani forEach (nawet gdyby był Ordered) nie biorą pod uwagę kolejności
        // i zestaw imion wypisywanych na końcu może się różnić w kolejnych uruchomieniach
    }
}

package p08_lambdy;

/* Interfejs funkcyjny to taki, który ma jedną metodę abstrakcyjną
   (czyli pozbawioną implementacji).
   Można jednak definiować metody z domyślną implementacją (oznaczone default).

   Można też definiować metody statyczne.

   Wyrażenia lambda, które są zgodne z nagłówkiem tej metody,
   mogą służyć do tworzenia obiektów zgodnych z tym interfejsem.

   Przed interfejsem funkcyjnym MOŻEMY, ale nie musimy, wpisać adnotację @FunctionalInterface
 */
@FunctionalInterface
public interface FunkcjaLiczbowa {
    double oblicz(double arg);

    default int obliczJakoInt(double arg) {
        return (int)oblicz(arg);
    }

    static FunkcjaLiczbowa identycznosc() {
        return x -> x;
    }

    static double nicniezmieniaj(double x) {
        return x;
    }

    static FunkcjaLiczbowa constant(double value) {
        return x -> value;
    }
}

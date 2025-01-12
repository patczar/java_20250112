package p08_lambdy;

public class MojFrameworkFunkcyjny {

    /** Aplikuje podaną funkcję do każdego elementu podanej tablicy.
     * W tablicy w miejsce argumentów zapisywane są wynikowe wartości.
     * @param t
     * @param f
     */
    public static void zastosujDoTablicy(double[] t, FunkcjaLiczbowa f) {
        for(int i = 0; i < t.length; i++) {
            t[i] = f.oblicz(t[i]);
        }
    }
}

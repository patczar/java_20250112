package p08_lambdy;

import java.util.Arrays;

public class MojProgram {
    public static void main(String[] args) {
        double[] a = {0, 1, 2, 4.5, 18, 625.0/2, 0.125};

        System.out.println(Arrays.toString(a));
        MojFrameworkFunkcyjny.zastosujDoTablicy(a, x -> 2*x);
        System.out.println(Arrays.toString(a));
        MojFrameworkFunkcyjny.zastosujDoTablicy(a, Math::sqrt);
        System.out.println(Arrays.toString(a));
        MojFrameworkFunkcyjny.zastosujDoTablicy(a, x -> x*x);
        System.out.println(Arrays.toString(a));
        MojFrameworkFunkcyjny.zastosujDoTablicy(a, FunkcjaLiczbowa.identycznosc());
        System.out.println(Arrays.toString(a));
        MojFrameworkFunkcyjny.zastosujDoTablicy(a, FunkcjaLiczbowa::nicniezmieniaj);
        System.out.println(Arrays.toString(a));
        MojFrameworkFunkcyjny.zastosujDoTablicy(a, FunkcjaLiczbowa.constant(5));
        System.out.println(Arrays.toString(a));
    }
}

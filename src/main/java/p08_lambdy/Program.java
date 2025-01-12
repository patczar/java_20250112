package p08_lambdy;

public class Program {
    public static void main(String[] args) {
        ProstaFunkcjaKwadratowa kw1 = new ProstaFunkcjaKwadratowa();
        FunkcjaLiczbowa kw2 = new ProstaFunkcjaKwadratowa();
        System.out.println(kw1.oblicz(5));
        System.out.println(kw2.oblicz(6));
        System.out.println();

        FunkcjaLiczbowa f3 = arg -> arg*arg;
        System.out.println(f3.oblicz(7));
        System.out.println("Obiekt f3: " + f3);
        System.out.println("Klasa obiektu: " + f3.getClass().getName());

        // skoro lambda lest obiektem, to mogę wpisać do zmiennej typu Object
        Object o = f3;
        // System.out.println(o.oblicz(8));
        if(o instanceof FunkcjaLiczbowa) {
            System.out.println("Tak, to jest ten typ.");
        }
        // Jednak nie mogę wpisać lambdy bezpośrednio do zmiennej o
        // bo kompilator nie wie w tym miejscu, do jakiego interfejsu ma pasować ta lambda.
        // o = y->y-1;

        // Aby użyć wyrażenia lambda, z kontekstu musi wynikać, jakiego typu oczekujemy.
        o = (FunkcjaLiczbowa) y->y-1;

        System.out.println();

        FunkcjaLiczbowa f4 = x -> 10*x;
        FunkcjaLiczbowa f5 = Math::sqrt;
        System.out.println(f4.oblicz(9));
        System.out.println(f5.oblicz(16));
        System.out.println(f5.oblicz(11));
        System.out.println(f5.obliczJakoInt(11));
    }
}

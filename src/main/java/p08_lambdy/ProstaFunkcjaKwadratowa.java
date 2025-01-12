package p08_lambdy;

// implementacja funckji jako x²
public class ProstaFunkcjaKwadratowa implements FunkcjaLiczbowa {

    @Override
    public double oblicz(double arg) {
        return arg*arg;
    }

    public String nazwa() {
        return "kwadrat";
    }
}

package p14_nowosci_javy;

public class BlokiTekstowe {
    public static void main(String[] args) {
        String napis = """
                 Ala ma kota.
                    Ola ma psa.
                Ela ma "chomika", \ttak tak.
                """;
        System.out.println(napis.length());
        System.out.println(napis);
    }
}

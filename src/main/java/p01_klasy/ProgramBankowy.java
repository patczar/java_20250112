package p01_klasy;

import java.util.Scanner;

public class ProgramBankowy {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        Osoba ala = new Osoba("Ala", "Kowalska", "1985-05-05");

        System.out.print("Podaj początkową kwotę: ");
        int kwota = sc.nextInt();
        sc.nextLine(); // wymuszenie przejścia do nowej linii

        Konto konto = new Konto(1, kwota, ala);
        System.out.println(konto);

        petla:
        while(true) {
            try {
                System.out.println("Co chcesz zrobić?  W - wpłata, Y - wypłata, K - koniec");
                String wybor = sc.nextLine().toUpperCase();
                switch(wybor) {
                    case "K", "Q" -> {
                        break petla; // przejście do Koniec programu
                    }
                    case "W" -> {
                        System.out.print("Podaj kwotę wpłaty: ");
                        kwota = sc.nextInt();
                        sc.nextLine();
                        konto.wplata(kwota);
                        System.out.println("Pieniądze zostały wpłacone");
                    }
                    case "Y" -> {
                        System.out.print("Podaj kwotę wypłaty: ");
                        kwota = sc.nextInt();
                        sc.nextLine();
                        konto.wyplata(kwota);

                        // ta linia wykona się tylko jeśli nie było wyjątku:
                        System.out.println("Pieniądze zostały wypłacone");
                    }
                    default -> {
                        System.out.println("Nieznane polecenie");
                        continue petla; // Przejście do Co chcesz zrobić
                    }
                }
            // Jeśli o różnych sytuacjach błędnych będą informować wyjątki różnych klas,
            // to w programie możemy te sytuacje rozróżnić i obsłużyć w różnych catchach
            } catch(IllegalArgumentException e) {
                System.out.println("Niepoprawny argument: " + e.getMessage());
            } catch(BrakSrodkow e) {
                System.out.println(e.getMessage());
            } catch(Exception e) {
                System.out.println("Inny błąd: " + e);
            }
            System.out.println();
            System.out.println(konto);
            System.out.println();
        }
        System.out.println("Koniec programu");
    }
}

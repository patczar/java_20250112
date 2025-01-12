package p03_watki;

public class A_PierwszyPrzyklad {

    public static void main(String[] args) {
        System.out.println("Początek main");

        Thread watekA = new Thread(() -> {
            System.out.println("A początek");
            for(int i = 1; i <= 1000; i++) {
                System.out.println("A " + i);
            }
            System.out.println("A koniec");
        });
        Thread watekB = new Thread(() -> {
            System.out.println("B początek");
            for(int i = 1; i <= 1000; i++) {
                System.out.println("B " + i);
            }
            System.out.println("B koniec");
        });

        watekA.start();
        watekB.start();

        System.out.println("Koniec main");
    }
}

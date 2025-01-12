package p03_watki;

public class Watek4_Lambda {

	public static void main(String[] args) {
		System.out.println("Początek main");
        Thread watek = new Thread(() -> {
            System.out.println("Startuje wątek 4. id = " + Thread.currentThread().getId());
            for(int i = 1; i <= 1000; i++) {
                System.out.println("Wątek 4: " + i);
            }
            System.out.println("Koniec wątek 4.");
        });
		watek.start();
		System.out.println("Koniec main");
	}
}

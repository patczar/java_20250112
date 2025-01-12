package p03_watki;

public class Watek3_KlasaAnonimowa {

	public static void main(String[] args) {
		System.out.println("Początek main");
        Thread watek = new Thread(new Runnable() {
			public void run() {
				System.out.println("Startuje wątek 3. id = " + Thread.currentThread().getId());

				for(int i = 1; i <= 1000; i++) {
					System.out.println("Wątek 3: " + i);
				}
				System.out.println("Koniec wątek 3.");
			}
		});
		watek.start();
		System.out.println("Koniec main");
	}
}

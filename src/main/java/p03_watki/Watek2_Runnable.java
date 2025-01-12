package p03_watki;

public class Watek2_Runnable implements Runnable {
	// Drugie podejście do definiowania wątków - interfejs Runnable

	@Override
	public void run() {
		System.out.println("Startuje wątek 2. id = " + Thread.currentThread().getId());
		
		for(int i = 1; i <= 1000; i++) {
			System.out.println("Wątek 2: " + i);
		}
		
		System.out.println("Koniec wątek 2.");
	}

	public static void main(String[] args) {
		System.out.println("Początek main");
		Runnable przepisNaDzialanie = new Watek2_Runnable();
		Thread watek = new Thread(przepisNaDzialanie);
		watek.start();
		System.out.println("Koniec main");
	}
}

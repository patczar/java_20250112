package p11_daty;

import java.time.LocalTime;

public class ProstyCzas {

	public static void main(String[] args) {
		
		LocalTime czas1 = LocalTime.now();  // ustawia z dokladnoscia do milisekundy
		System.out.println(czas1);
		
		// uwaga: można utworzyć czas nie podając sekund
		LocalTime czas2 = LocalTime.of(12, 15);
		System.out.println(czas2);
		
		LocalTime czas3 = LocalTime.of(12, 15, 33);
		System.out.println(czas3);
		
		// uwaga: nanosekumdy podajemy jako liczbę całkowitą (int)
		LocalTime czas4 = LocalTime.of(12, 15, 33, 333222111);
		System.out.println(czas4);

		// to oznacza jedną nanosekundę (miliardową część sekundy),
		// a nie jedną dizesiątą sekundy
		LocalTime czas5 = LocalTime.of(12, 15, 33, 1);
		System.out.println(czas5);
	}
}

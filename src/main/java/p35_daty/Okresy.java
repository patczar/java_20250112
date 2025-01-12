package p35_daty;

import java.time.LocalDate;
import java.time.Period;

public class Okresy {

	public static void main(String[] args) {
		
		LocalDate d1 = LocalDate.parse("2015-05-13");
		LocalDate d2 = LocalDate.parse("2016-09-11");
		
		Period p1 = Period.between(d1, d2);
		System.out.println(p1);

		Period p2 = Period.of(3, 14, 44);
		System.out.println(p2);
		
		LocalDate dzisiaj = LocalDate.now();
		LocalDate przyszlosc1 = dzisiaj.plus(p2);
		System.out.println(przyszlosc1);

		LocalDate przyszlosc2 = (LocalDate) p2.addTo(dzisiaj);
		System.out.println(przyszlosc2);
		
		Period p3 = p2.normalized();
		System.out.println(p3); // miesiące są normalizowane (miesiące powyżej 12 są zamieniane na lata), ale dni nie, bo się nie da
		System.out.println();
		
		Period p4 = Period.parse("P3M2W10D");  // tygodnie od razu przeliczają się na dni, ale miesiące nie przeliczają się na lata
		System.out.println(p4);

		Period p5 = Period.ofWeeks(3);
		System.out.println(p5);

		Period p6 = Period.ofDays(50);
		System.out.println(p6);
	}

}

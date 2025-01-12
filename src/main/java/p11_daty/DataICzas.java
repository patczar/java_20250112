package p11_daty;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;

public class DataICzas {

	public static void main(String[] args) {
		
		// Która godzina jest w innej strefie czasowej
		LocalDateTime dt2 = LocalDateTime.now(ZoneId.of("UTC-4"));
		System.out.println(dt2);
		
		
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		
		// Metody "with" modyfikują wybrane pole i zwracają wmieniony obiekt
		dt.with(ChronoField.HOUR_OF_DAY, 17);
		System.out.println(dt); // nie widać zmiany, bo dato-czasy są immutable
		
		// przypisanie na zmienną dt zapisuje zmieniony obiekt
		dt = dt.with(ChronoField.HOUR_OF_DAY, 17);
		System.out.println(dt);

		dt = dt.withDayOfMonth(13);
		System.out.println(dt);

		dt = dt.withDayOfYear(200);
		System.out.println(dt);

		dt = dt.with(ChronoField.SECOND_OF_DAY, 12360);
		System.out.println(dt);

		try {
			dt = dt.with(ChronoField.OFFSET_SECONDS, 7200);
			System.out.println(dt);
		} catch (Exception e) {
			System.out.println("Był wyjątek " + e.getClass() + " " + e.getMessage());
		}

		dt = LocalDateTime.now();
		System.out.println(dt);
		OffsetDateTime przesuniety = dt.atOffset(ZoneOffset.ofHours(5));
		System.out.println(przesuniety);
		
		dt = LocalDateTime.parse("2019-05-08T14:55:04.360");
		System.out.println(dt);
		
		dt = LocalDateTime.parse("2019-05-08T14:55");
		System.out.println(dt);

		dt = LocalDateTime.parse("2019-05-08T14:55:00");
		System.out.println(dt); // sekundy równe zero w ogóle się nie wypisują

	}
}

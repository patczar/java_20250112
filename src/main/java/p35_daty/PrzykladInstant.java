package p35_daty;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class PrzykladInstant {

	public static void main(String[] args) {
		Instant czas = Instant.now();
		System.out.println(czas);
		
		ZonedDateTime uNas = czas.atZone(ZoneId.systemDefault());
		System.out.println(uNas);
		
		ZonedDateTime zoned = ZonedDateTime.now();
		System.out.println(zoned);
	}

}

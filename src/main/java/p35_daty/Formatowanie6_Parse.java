package p35_daty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatowanie6_Parse {

	public static void main(String[] args) {
		LocalDateTime data = LocalDateTime.now();

		DateTimeFormatter df = DateTimeFormatter.ofPattern("EEEE,yyyyMMdd HH@mm");
		System.out.println(data.format(df));
		System.out.println(data);
		System.out.println();
		
		data = LocalDateTime.parse("wtorek,19981208 12@13", df);
		System.out.println(data);
	}
}

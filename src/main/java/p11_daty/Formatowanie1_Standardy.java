package p11_daty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Formatowanie1_Standardy {

	public static void main(String[] args) {
		LocalDateTime teraz = LocalDateTime.now();
		
		DateTimeFormatter[] formats = {
				DateTimeFormatter.BASIC_ISO_DATE,
				DateTimeFormatter.ISO_DATE,
				DateTimeFormatter.ISO_DATE_TIME,
				DateTimeFormatter.ISO_LOCAL_DATE_TIME,
				DateTimeFormatter.ISO_ORDINAL_DATE,
				DateTimeFormatter.ISO_WEEK_DATE,
		};
		
		System.out.println("Format domyslny:");
		System.out.println(teraz.toString());
		System.out.println(LocalDate.now().toString());
		System.out.println(LocalTime.now().toString());
		System.out.println();
		
		for (DateTimeFormatter df : formats) {
			// formatowanie można wywoływać na dwa sposoby
			System.out.println(teraz.format(df));
			System.out.println(df.format(teraz));
		}
	}
}

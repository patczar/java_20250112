package p11_daty;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatowanie2_Jezykowo {

	public static void main(String[] args) {
		ZonedDateTime teraz = ZonedDateTime.now();
		
		DateTimeFormatter df = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.FULL)
				.withLocale(new Locale("ru", "RU"));

		System.out.println(teraz.format(df));
	}
}

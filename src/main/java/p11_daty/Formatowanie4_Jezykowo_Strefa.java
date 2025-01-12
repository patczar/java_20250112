package p11_daty;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Formatowanie4_Jezykowo_Strefa {

	public static void main(String[] args) {
		ZonedDateTime teraz = ZonedDateTime.now();
		
		Locale[] locales = {
			new Locale("pl", "PL"),
			new Locale("pl"),
			new Locale("fr", "FR"),
			new Locale("de", "DE"),
			new Locale("es", "ES"),
			new Locale("it", "IT"),
			new Locale("ru", "RU"),
			new Locale("ja", "JP"),
			new Locale("ar", "EY"),
			new Locale("en", "GB"),
			new Locale("en", "US"),
			new Locale("en")
		};
		
		FormatStyle[] styles = {
			FormatStyle.FULL,
			FormatStyle.LONG,
			FormatStyle.MEDIUM,
			FormatStyle.SHORT
		};
		
		for(Locale locale : locales) {
			System.out.println("\nLOCALE " + locale);
			for(FormatStyle style : styles) {
				DateTimeFormatter df = DateTimeFormatter
						.ofLocalizedDateTime(style)
						.withLocale(locale);
				System.out.println(teraz.format(df));
				System.out.println(df.format(teraz));
			}
		}		
	}
}

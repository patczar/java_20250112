package p11_daty;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

	public class StareFormatowanieDat {

		public static void display(Date date, Locale locale) {
			DateFormat df;

			df = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
			System.out.println("Date DEFAULT: " + df.format(date));

			df = DateFormat.getDateInstance(DateFormat.FULL, locale);
			System.out.println("Date FULL: " + df.format(date));

			df = DateFormat.getDateInstance(DateFormat.LONG, locale);
			System.out.println("Date LONG: " + df.format(date));

			df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
			System.out.println("Date MEDIUM: " + df.format(date));

			df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
			System.out.println("Date SHORT: " + df.format(date));

			df = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
			System.out.println("Time DEFAULT: " + df.format(date));

			df = DateFormat.getTimeInstance(DateFormat.FULL, locale);
			System.out.println("Time FULL: " + df.format(date));

			df = DateFormat.getTimeInstance(DateFormat.LONG, locale);
			System.out.println("Time LONG: " + df.format(date));

			df = DateFormat.getTimeInstance(DateFormat.MEDIUM, locale);
			System.out.println("Time MEDIUM: " + df.format(date));

			df = DateFormat.getTimeInstance(DateFormat.SHORT, locale);
			System.out.println("Time SHORT: " + df.format(date));

			//Tu już tylko przykładowo
			df = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, locale);
			System.out.println("DateTime DEFAULT DEFAULT: " + df.format(date));

			df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, locale);
			System.out.println("DateTime LONG SHORT: " + df.format(date));

		}

		public static void main(String[] args) {
			Locale[] all = {
				new Locale("pl", "PL"),
				new Locale("pl"),
				new Locale("de", "DE"),
				new Locale("fr", "FR"),
				new Locale("ru", "RU"),
				new Locale("es", "ES"),
				new Locale("it", "IT"),
				new Locale("ja", "JP"),
				new Locale("ar", "EY"),
				new Locale("en", "GB"),
				new Locale("en", "US"),
				new Locale("en") };

			Date now = Calendar.getInstance().getTime();

			DateFormat df = DateFormat.getInstance();
			System.out.println("domyślnie: " + df.format(now));

			for (Locale locale : all) {
				System.out.println("Dla locali " + locale.toString());
				display(now, locale);
				System.out.println();
			}
		}

	}

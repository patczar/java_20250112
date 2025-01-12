package p35_daty;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Formatowanie5_Pattern {

	public static void main(String[] args) {
		ZonedDateTime teraz = ZonedDateTime.now();
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		System.out.println(teraz.format(df));

		df = DateTimeFormatter.ofPattern("dd.MM.YY");
		System.out.println(teraz.format(df));

		df = DateTimeFormatter.ofPattern("dd.MM.YYY");
		System.out.println(teraz.format(df));

		df = DateTimeFormatter.ofPattern("d M Y");
		System.out.println(teraz.format(df));

		df = DateTimeFormatter.ofPattern("dd MM YY");
		System.out.println(teraz.format(df));

		df = DateTimeFormatter.ofPattern("e dd MMM");
		System.out.println(teraz.format(df));

		df = DateTimeFormatter.ofPattern("EEE, dd MMMM");
		System.out.println(teraz.format(df));

		df = DateTimeFormatter.ofPattern("EEEE, dd MMMMM");
		System.out.println(teraz.format(df));
	}
}

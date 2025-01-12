package p35_daty;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class ProsteDaty {

	public static void main(String[] args) {
		LocalDate data1 = LocalDate.now();
		System.out.println(data1);
		
		LocalDate data2 = LocalDate.of(2016, 12, 5);
		System.out.println(data2);

		LocalDate data3 = LocalDate.of(2016, Month.DECEMBER, 5);
		System.out.println(data3);

		LocalDate data4 = LocalDate.parse("2016-12-05");
		System.out.println(data4);

		LocalDate data5 = LocalDate.parse("2016-02-29");
		System.out.println(data5);

//		LocalDate data6 = LocalDate.parse("2015-02-29");
//		System.out.println(data6);

		// najpierw starsza potem pozniejsza
		Period czasTrwania = Period.between(data4, data1);
		System.out.println(czasTrwania);
		
		System.out.println(czasTrwania.getDays());
	}
}

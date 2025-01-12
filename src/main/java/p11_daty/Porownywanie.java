package p11_daty;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Porownywanie {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.of(2016, 12, 7);
		LocalDate d3 = LocalDate.parse("2016-04-04");
		
		System.out.println(d1.equals(d2)); // T
		System.out.println(d1.equals(d3)); // F
		
		if(d1.compareTo(d3) > 0) {
			System.out.println("d1 później niż d3");
		} else {
			System.out.println("d1 wcześniej niż d3");			
		}

		if(d1.isAfter(d3)) {
			System.out.println("d1 później niż d3");
		} else {
			System.out.println("d1 wcześniej niż d3");			
		}
		
		ArrayList<LocalDate> daty = new ArrayList<>();
		daty.add(LocalDate.of(2015, 12, 24));
		daty.add(LocalDate.of(2016, 9, 24));
		daty.add(LocalDate.of(2015, 3, 11));
		daty.add(LocalDate.of(2016, 8, 8));

		System.out.println(daty);		
		Collections.sort(daty);
		System.out.println(daty);
	}

}

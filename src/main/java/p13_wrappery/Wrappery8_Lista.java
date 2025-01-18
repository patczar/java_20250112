package p13_wrappery;

import java.util.ArrayList;
import java.util.List;

public class Wrappery8_Lista {

	public static void main(String[] args) {
		List<String> napisy = new ArrayList<>();
		napisy.add("Ala");
		napisy.add("Ola");
		napisy.add("Ela");
		napisy.add("Ula");
		System.out.println(napisy);
		napisy.remove(2); // usuwa według indeksu, zwraca referencję do usuwanego obiektu
		System.out.println(napisy);
		napisy.remove("Ala"); // usuwa wg wartości, zwraca boolean mówiący czy element został usunięty
		System.out.println(napisy);
		System.out.println();
		
		List<Integer> liczby = new ArrayList<>();
		liczby.add(4);
		liczby.add(8);
		liczby.add(1);
		liczby.add(5);
		liczby.add(13);
		liczby.add(12);
		liczby.add(5);
		liczby.add(1);
		System.out.println(liczby);
		
		// liczby.remove(12); // traktowane jako pozycja
		Integer co = liczby.remove(0); // traktowane jako pozycja
		// System.out.println(liczby);
		
		// traktowane jako obiekt - czyli wartość wpisu
		boolean czy = liczby.remove((Object)13);
		liczby.remove(new Integer(12));
		liczby.remove(Integer.valueOf(5));
		System.out.println(liczby);
	}
}

package p13_wrappery;

import java.util.ArrayList;
import java.util.List;

public class Wrappery2_Zastosowania {

	public static void main(String[] args) {
		// Zastosowania wrapperów.
		// 1) Stałe i metody statyczne zdefiniowane w klasie
		String liczbaTekstowo = "12345";
		int liczba = Integer.parseInt(liczbaTekstowo);
		Integer obiekt = Integer.valueOf(liczbaTekstowo);
		System.out.println(liczba * 2);
		
		System.out.printf("Typ %s ma %d bajty, czyli %d bity, minimalna wartość to %d, a maksymalna %d\n",
				Integer.TYPE.getSimpleName(), Integer.BYTES, Integer.SIZE, Integer.MIN_VALUE, Integer.MAX_VALUE);
		
		// 2) Obiekt jako "wartość opcjonalna".
		//    Zmienna/funkcja typu int MUSI mieć/zwracać jakąś wartość. Każdy ciąg bitów w zmiennej typu prostego oznacza jakąś konkretną wartość.
		//    Zmienna typu obiektowego może wskazywać na obiekt LUB mieć wartość null. null może być traktowany jako dodatkowa wartość oznaczająca brak danych/brak wyniku
		//    Współcześnie bardziej zalecane do tego celu jest używanie klas Optional (np. OptionalInt), ale tradycyjnie używało się wrapperów i w wielu miejscach to pozostało.
		
		int[] a = {13, 7, 14, 3, 12};
		int[] b = {13, 7, 3, 9, -5};
		Integer wynik1 = pierwszaParzysta(a);
		if(wynik1 != null) {
			System.out.println("pierwszy wynik: " + wynik1);
		} else {
			System.out.println("brak pierwszego wyniku");
		}
		Integer wynik2 = pierwszaParzysta(b);
		if(wynik2 != null) {
			System.out.println("drugi wynik: " + wynik2);
		} else {
			System.out.println("brak drugiego wyniku");
		}
		
		// 3) Kolekcje i bardziej ogólnie deklaracje typów generycznych.
		// nie da rady: List<int> listaLiczb1 = new ArrayList<>();

		List<Integer> listaLiczb = new ArrayList<>();
		for(int x : a) {
			listaLiczb.add(x);
		}
		System.out.println(listaLiczb);
	}

	public static Integer pierwszaParzysta(int[] tab) {
		for(int x : tab) {
			if(x % 2 == 0) {
				return x;
			}
		}
		return null;
	}
	
}

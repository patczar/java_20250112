package p08_lambdy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ReferencjeDoMetod {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("Ala");
		lista.add("Ola");
		lista.add("Ela");
		
		
		// Jeśli istnieje metoda, której chcemy użyć, to zamiast pisać taką trywialną lambdę
		FunkcjaLiczbowa f1 = x -> Klasa.aaa(x);
		System.out.println(f1.oblicz(10));
		
		// możemy bezpośrednio wskazać tę metodę
		// Opcja 1: wskazujemy metodę statyczną poprzez klasę
		FunkcjaLiczbowa f2 = Klasa::aaa;
		System.out.println(f2.oblicz(10));
		System.out.println();
		
		
		// Opcja 2: wskazujemy metodę instancyjną poprzez obiekt
		Klasa obiekt = new Klasa(50);
		FunkcjaLiczbowa f3 = obiekt::bbb;
		System.out.println(f3.oblicz(10));
		FunkcjaLiczbowa f4 = x -> obiekt.bbb(x);
		System.out.println(f4.oblicz(10));
		System.out.println();
		
		
		// Opcja 3: wskazujemy metodę instancyjną poprzez klasę.
		// Wówczas this jest traktowany jak pierwszy argument funkcji.
		
		UnaryOperator<String> naDuzeLitery = String::toUpperCase;
		System.out.println(naDuzeLitery.apply("Ala ma kota"));
		System.out.println();
		
		lista.stream()
			.map(naDuzeLitery)
			.forEach(System.out::print);
		System.out.println();
		
		lista.stream()
			.map(String::toUpperCase)
			.forEach(System.out::print);
		System.out.println();

		lista.stream()
			.map(x -> x.toUpperCase())
			.forEach(System.out::print);
		System.out.println();
		System.out.println();

		
		Comparator<String> komp1 = (s1, s2) -> s1.compareTo(s2);
		Comparator<String> komp2 = String::compareTo;
		// jakby        (this, argument) -> this.compareTo(argument);
		
		lista.stream().sorted(String::compareTo).forEachOrdered(System.out::println);
	}
	
	
	static class Klasa {
		private int wartosc;
		
		public Klasa(int x) {
			this.wartosc = x;
		}

		static double aaa(double x) {
			return x+1;
		}
		
		double bbb(double x) {
			return x+wartosc;
		}
	}

}

package p08_lambdy;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class SkladniaLambd {
	static int globalna = 0;

	public static void main(String[] args) {
		FunkcjaLiczbowa f1 = (double arg) -> {
			System.out.println("obliczam...");
			double z = arg * arg;
			globalna++;
			return z + 5;
		};
		
		System.out.println("a kuku");
		double wynik = f1.oblicz(7);
		System.out.println(wynik);
		
		
		// pomijam typ argumentu
		FunkcjaLiczbowa f2 = (arg) -> {return arg + 5;};
		
		//NK FunkcjaLiczbowa f2 = (arg) -> return arg + 5;
		
		// jeśli prawa strona sprowadza się do jednego return, można od razu pisać wynim bez klamerek i bez return:
		FunkcjaLiczbowa f3 = (arg) -> arg + 5;
		// tutaj średnik należy do instrukcji przypisania, a nie jest częścią lambdy
		FunkcjaLiczbowa f3a = (     (arg) -> arg + 5    )  ;
		
		// jeśli po lewej stronie jest jeden argument bez typu, to można pominąć nawiasy
		FunkcjaLiczbowa f4 = arg -> arg + 5;
		
		// Consumer jest typu T -> void   czyli nie zwraca wyniku
		Consumer<String> cs1 = s -> {System.out.println(s);};
		
		// nawet jeśli metoda nie zwraca wyniku, ale jest zbudowana z jednego polecenia, można pominąć nawiasy klamrowe
		Consumer<String> cs2 = s -> System.out.println(s)    ;
		
		Function<String, Integer> ff = s -> s.length();
		
		UnaryOperator<String> un = s -> s.toUpperCase();
		
		IntUnaryOperator iun = i -> 10*i;
		
		int x = 15;
		int y = -x; // minus jest "operatorem unarnym", stąd się wzięła nazwa dla funkcji przyjmujących jeden argument
		
		
		// Jeśli parametrów jest więcej niż 1, to musimy wziąć je w nawiasy
		// Albo podajemy typy wszystkich parametrów, albo żadnego
		
		// Comparator<String> komp = x, y -> x.compareToIgnoreCase(y);
		Comparator<String> komp1 = (String s1, String s2) -> s1.compareToIgnoreCase(s2);
		Comparator<String> komp2 = (s1, s2) -> s1.compareToIgnoreCase(s2);
		//NK Comparator<String> komp3 = (String s1, s2) -> s1.compareToIgnoreCase(s2);


		// Jeśli metoda nie przyjmuje parametrów, to po lewej stronie strzałki piszemy puste nawiasy
		Runnable r1 = () -> {};

		Runnable r2 = () -> {System.out.println("Hello world");};
		//NK Runnable r2a = (void) -> {System.out.println("Hello world");};

		// nawet jeśli funkcja jest typu void (nie zwraca wyniku), a treść ogranicza się do jednej instrukcji,
		// to tę instrukcję możemy napisać bez klamerek
		Runnable r3 = () -> System.out.println("Hello world");

		Runnable r4 = () -> globalna = 103;

		System.out.println("gloalna przed: " + globalna);
		r4.run();
		System.out.println("gloalna przed: " + globalna);
		
		Consumer<String> cs4 = napis -> System.out.println(napis.length());
		
		Supplier<String> dajDate = () -> LocalTime.now().toString();
		
		
		// nazwami parametrów w lambdach nie mogą być zajęte nazwy zmiennych lokalnych
		// Comparator<String> komp2 = (x, y) -> x.compareToIgnoreCase(y);
		System.out.println();
		for(int i = 0; i < 10; i++)
			System.out.println(dajDate.get());
		
	}

}

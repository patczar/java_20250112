package p09_streamy;

import java.util.stream.Stream;

/* collect i reduce to dwa schematy służące do agregacji danych strumienia,
 * czyli "zbierania danych" tak, aby na podstawie całego zestawu danych uzyskać pojedynczy wynik.
 * 
 * collect i Collectory - schemat agregacji wykorzystujący klasy mutowalne,
 *   jako krok operacji podaje się metodę typu void
 *
 * reduce - schemat agregacji wykorzystujący klasy niemutowalne lub wartości liczbowe
 *   jako krok operacji podaje się metodę zwracającą wynik
 */

public class Collect_i_Reduce {

	public static void main(String[] args) {
		String[] imiona = {"Ala", "Ola", "Ela"};
		
		{
			StringBuilder wynik = Stream.of(imiona).collect(
				StringBuilder::new, // supplier - tworzy początkową "pustą" wartość
				StringBuilder::append, // accumulator - aktualizuje wartość na podstawie elementu strumienia
				StringBuilder::append); // combiner - łączy częściowe wyniki (które mogą się pojawić gdy mamy parallelStream)
		
			System.out.println("1: " +wynik);
		}
		
		// w przypadku strumienia sekwencyjnego można to przetłumaczyć na taką pętlę:
		{
			StringBuilder wynik = new StringBuilder();
			for (String s : imiona) {
				wynik.append(s);  // tylko wywołanie, wynik tej metody nie jest brany pod uwagę, może być void
			}
			System.out.println("2: " + wynik);
		}
		
		// #################
		// Klasa, o którą się opieramy, musi być mutowalna, a operacja (w tym przypadku append)
		// musi zmieniać obiekt, na którym jest wołana
		
		// To nie zadziała:
		{
			String wynik = Stream.of(imiona).collect(
				String::new,
				String::concat, // concat nie zmienia Strina, na którym jest wołany - więc nie będzie efektu
				String::concat);
		
			System.out.println("3: " + wynik);
		}

		// Dla klas niemutowalnych (i typów prostych) właściwym schematem jest reduce:
		{
			String wynik = Stream.of(imiona).reduce(
				"",
				String::concat);
			System.out.println("4: " + wynik);
		}
		
		// to tłumaczy się na taką pętlę:
		{
			String wynik = "";
			for (String s : imiona) {
				wynik = wynik.concat(s); // przypisanie / podmiana wyniku !!!
			}
			System.out.println("5: " + wynik);
		}	

		// Gdyby "combiner" częściowych wyników różnił się od "accumulatora" pojedynczych wartości,
		// podajemy go jako trzeci parametr
		{
			String wynik = Stream.of(imiona).reduce(
					"",
					String::concat,
					String::concat);
			System.out.println("6: " + wynik);
		}
		
		// Tu jest taka sytuacja, bo na wejściu mamy strumień Stringów,
		// a wynikiem jest int
		// pierwsza funkcja jest typu (int, String) -> int
		// a druga jest typu (int, int) -> int
		{
			int wynik = Stream.of(imiona).reduce(
					0,
					(suma, str) -> suma + str.length(),
					Math::addExact);
			System.out.println("7: " + wynik);
		}	

		// te ostatnie funkcje ("combiner") są używane tylko gdy parallelStream
	}

}

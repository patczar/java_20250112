package emps.streamy;

import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;

public class DaneOpcjonalne {

	public static void main(String[] args) throws FileNotFoundException {
		// Użytkownik podaje nazwę miasta, a program filtruje dane wczytane z pliku
		// i oblicza średnią pensję oraz znajduje najbogatszego i najbiedniejszego pracownika.
		// Przykład ma pokazać, jak można wykorzystać wyniki typu Optional.
		Scanner scanner = new Scanner(System.in);
		System.out.print("Podaj nazwę miasta: ");
		String miasto = scanner.nextLine();
		
		List<Employee> emps = ObslugaCSV.wczytaj();
		
		OptionalDouble srednia = emps.stream()
				.filter(emp -> emp.getCity().equals(miasto))
				.mapToInt(Employee::getSalary)
				.average();

		Optional<Employee> min = emps.stream()
				.filter(emp -> emp.getCity().equals(miasto))
				.min(Comparator.comparingInt(Employee::getSalary));
		
		Optional<Employee> max = emps.stream()
				.filter(emp -> emp.getCity().equals(miasto))
				.max(Comparator.comparingInt(Employee::getSalary));
		
		System.out.println("średnia" + srednia);
		System.out.println("min: " + min);
		System.out.println("max: " + max);
		System.out.println();

		// Za pomocą isPresent / isEmpty można sprawdzać, czy obiekt zawiera wartość
		if(srednia.isPresent()) {
			// aby wydobyć liczbę z obiektu, piszemy getAsDouble (w przypadku pustego Optionala kończy się to błędem)
			System.out.println("Średnia pensja = " + srednia.getAsDouble());
		} else {
			System.out.println("Brak danych");
		}
		System.out.println();
		
		if(min.isPresent()) {
			// aby dostać się do obiektu wewnątrz Optionala, piszemy get(); w razie braku danych powoduje to błąd
			Employee emp = min.get();
			System.out.println("Najbiedniejszy: " + emp.getFirstName() + " " + emp.getLastName() + " z pensją " + emp.getSalary());
		} else {
			System.out.println("Brak danych");			
		}
		
		if(max.isEmpty()) {
			System.out.println("Brak danych");	
		} else {
			Employee emp = max.get();
			System.out.println("Najbogatszy: " + emp.getFirstName() + " " + emp.getLastName() + " z pensją " + emp.getSalary());
		}
		System.out.println();
		
		// Operacja orElse zwraca wartość z wnętrza Optionala, a w razie braku danych zwraca wartość alternatywną podaną w nawiasach
		System.out.println("srednia.orElse(0) = " + srednia.orElse(0));
		System.out.println("srednia.orElse(NaN) = " + srednia.orElse(Double.NaN));

		// W przypadku obiektów użycie orElse wymagałoby posiadania "domyślnego pracownika", ew. można wstawić nulla
		Employee fejkowy = new Employee(0, "Fejkowy", "Pracownik", "nikt", -1, null, "", "", "", "", "nieznany kraj");
		System.out.println("najbiedniejszy lub zmyślony:");
		System.out.println(min.orElse(fejkowy));
		
		System.out.println("najbogatszy lub null:");
		System.out.println(max.orElse(null));
		System.out.println();
		
		// Domyślnym wyjątkiem wyrzucanym w razie braku danych gdy robimy get jest NoSuchElementException
		// System.out.println("Najbogatsza osoba to " + max.get().getLastName());

		// ale możemy wyrzuć własny dedykowany wyjątek
		// Podajemy to w formie lambdy, aby kod tworzący wyjątek został wykonany tylko wtedy, gdy jest naprawdę potrzebny
//		String nazwisko = max.orElseThrow(() -> new RuntimeException("wielka bieda")).getLastName();
//		System.out.println("Najbogatsza osoba to " + nazwisko);
		
		// Na obiektach Optional (i w mniejszym stoniu na ich wersjach liczbowych) można wykonywać operacje
		// przypominające operacje na strumieniach.
		// Operacja map z Optionala jednego typu jest w stanie utworzyc Optional innego typu
		// Na podstawie Optional<Employee> utworzymy Optional<String> zawierający dane pracownika
		Optional<String> minTXT = min.map(emp -> "Najbiednieszy jest " + emp.getFirstName() + " " + emp.getLastName());
		// Jeśli min był pusty, to minTXT też będzie pusty
		// Jeśli min zawierał dane pracownika, to minTXT będzie zawierał tekst z imieniem i nazwiskiem pracownika
		System.out.println("Optional<String>: " + minTXT);
		
		// Można to wykorzystać w zapisie typu pipeline w taki sposób:
		String maxTXT = emps.stream()
				.filter(emp -> emp.getCity().equals(miasto))
				.max(Comparator.comparingInt(Employee::getSalary))
				.map(emp -> "Najbogatszy jest " + emp.getFirstName() + " " + emp.getLastName())
				.orElse("Brak danych najbogatszego");
		
		System.out.println("maxTXT: " + maxTXT);
		
		// czasami może się zdarzyć, że wartość alternatywna jest obliczana w trakcie działania programu
		// aby uniknąć niepotrzebnego obliczania (aby robić to tylko w przypadku braku danych), można podać wyrażenie lambda tworzące ten wynik
		
		String maxTXT2 = emps.stream()
				.filter(emp -> emp.getCity().equals(miasto))
				.max(Comparator.comparingInt(Employee::getSalary))
				.map(emp -> "Najbogatszy jest " + emp.getFirstName() + " " + emp.getLastName())
				.orElseGet(() -> "Brak najbogatszego w mieście " + miasto);
		
		System.out.println("maxTXT2: " + maxTXT2);
		
		// Można też podać akcję, która zostanie wykonana tylko, gdy optional nie jest pusty
		min.ifPresent(emp -> System.out.println("Znaleziony najbiedniejszy pracownik! - " + emp.getFirstName() + " " + emp.getLastName()));
		
		// wersja z else (co zrobić w razie braku danych)
		max.ifPresentOrElse(
				emp -> System.out.println("Znaleziony najbogatszy pracownik! - " + emp.getFirstName() + " " + emp.getLastName()),
				() -> System.out.println("Nie znaleziomo najbogatszego!"));
		
		// oczywiście można to zastosować na końcu pipeline
		emps.stream()
				.filter(emp -> emp.getCity().equals(miasto))
				.mapToInt(Employee::getSalary)
				.average()
				.ifPresentOrElse(
						avg -> System.out.println("Jest średnia " + avg),
						() -> System.out.println("Nie ma średniej"));
	}

}

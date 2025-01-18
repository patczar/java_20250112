package p14_nowosci_javy;

import java.io.File;
import java.time.LocalDate;

public class SwitchNaObiektach {

	/* W Java 21 pojawiły się kolejne możliwości switcha:
	https://openjdk.org/jeps/441 
 	* - case null jako legalny warunek
 	* - rozróżnianie obiektów wg ich typu
 	* - klauzula when z warunkiem logicznym
 	*/

	public static void main(String[] args) {
		Object jakisObiekt;
//    	jakisObiekt = "owca";
//    	jakisObiekt = "koza";
//    	jakisObiekt = "";
//    	jakisObiekt = new File("sciezka/do/pliku.txt");
    	jakisObiekt = LocalDate.of(1997, 8, 19);
   	 
    	switch(jakisObiekt) {
        	case String s when s.startsWith("o") -> System.out.println("To jest napis na o:" + s);
        	case String s when s.startsWith("k") -> System.out.println("To jest napis na k:" + s);
        	case String s when s.equalsIgnoreCase("java") -> System.out.println("To jest napis JAVA");
        	case String s -> System.out.println("To jest inny napis: " + s);
        	case File f -> System.out.println("To jest plik " + f.getAbsolutePath());
        	case LocalDate dt -> System.out.println("To jest data " + dt + " (dzień tygodnia " + dt.getDayOfWeek() +")");
        	case null -> System.out.println("Nie ma nic");
        	default -> System.out.println("Nie wiem co to jest. Ale klasą jest " + jakisObiekt.getClass());
    	}
	}

}



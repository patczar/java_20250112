package p12_http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Pobieranie1_URL {

	public static void main(String[] args) {
		final String adres = "http://api.nbp.pl/api/exchangerates/tables/A/?format=json";

		try {
			URL url = new URL(adres);
			// Od Java 21 bardziej zalecane jest:
			// URI uri = new URI(adres);
			// URL url = uri.toURL();
			try(InputStream input = url.openStream()) {
				// z input stream dane można czytać porcjami jako ciągi bajtów
				// byte[] tablica_bajtow = new byte[1024];
				// int ile = input.read(tablica_bajtow);
				// System.out.println(new String(tablica_bajtow, 0, ile));
				// ale tutaj całość pobrnaych danych zapiszemy do pliku
				Files.copy(input, Path.of("waluty.json"), StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Gotowe");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package p12_http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DownloadURL {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://api.nbp.pl/api/exchangerates/tables/A/");
			try(InputStream wejscie = url.openStream()) {
				Path wyjscie = Paths.get("kursy.json");
				Files.copy(wejscie, wyjscie, StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Gotowe");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

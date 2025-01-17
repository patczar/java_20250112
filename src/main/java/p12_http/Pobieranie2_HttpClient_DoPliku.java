package p12_http;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Pobieranie2_HttpClient_DoPliku {

	public static void main(String[] args) {
		final String adres = "http://api.nbp.pl/api/exchangerates/tables/A/?format=json";

		try {
			URI uri = new URI(adres);
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(uri).build();
			HttpResponse<InputStream> response = client.send(request, BodyHandlers.ofInputStream());
			System.out.println("response: " + response);
			System.out.println("status: " + response.statusCode());
			System.out.println("Content-Type: " + response.headers().firstValue("content-type").orElse("--"));
			if(response.statusCode() != 200) {
				return;
			}
			// body jest takiego typu, jaki wynika z użytego BodyHandler
			try(InputStream input = response.body()) {
				Files.copy(input, Path.of("waluty.json"), StandardCopyOption.REPLACE_EXISTING);
				System.out.println("Gotowe");
			}
		} catch (IOException | URISyntaxException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}

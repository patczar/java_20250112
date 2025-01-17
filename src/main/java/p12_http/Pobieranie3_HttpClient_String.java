package p12_http;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Pobieranie3_HttpClient_String {

	public static void main(String[] args) {
		final String adres = "http://api.nbp.pl/api/exchangerates/tables/A/?format=json"; // spróbuj xml

		try {
			URI uri = new URI(adres);
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder(uri).build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			System.out.println("response: " + response);
			System.out.println("status: " + response.statusCode());
			System.out.println("Content-Type: " + response.headers().firstValue("content-type").orElse("--"));
//			if(response.statusCode() != 200) {
//				return;
//			}
			// body jest takiego typu, jaki wynika z użytego BodyHandler
			String body = response.body();
			System.out.println("Długość stringa: " + body.length());
			System.out.println(body);
		} catch (IOException | URISyntaxException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}

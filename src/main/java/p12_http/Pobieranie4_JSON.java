package p12_http;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

public class Pobieranie4_JSON {

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
			// parsowanie JSONa z pomocą biblioteki Jakarta JSON (utworzone w Java EE 7 i dalej rozwijane)
			// alternatywy: GSON, org.json, Jackson
			
			JsonArray json;
			try(JsonReader reader = Json.createReader(response.body())) {
				json = reader.readArray();				
			} // tutaj już zamykamy połączenie
			// zerowym (i jedynym) elementem tablicy jest {obiekt JSONowy} odpowiadający tabeli walut
			JsonObject tabela = json.getJsonObject(0);
			// bezpośrednio w tym obiekcie są takie pola, jak numer i data
			System.out.println("Numer tabeli: " + tabela.getString("no"));
			System.out.println("Data: " + tabela.getString("effectiveDate"));
			// w polu rates znajduje się tablica zawierająca dane poszczególnych walut
			JsonArray rates = tabela.getJsonArray("rates");
			System.out.println("Liczba walut: " + rates.size());
			System.out.println();
			for(JsonValue rate : rates) {
				// System.out.println(rate);
				JsonObject rateObj = rate.asJsonObject();
				String nazwa = rateObj.getString("currency");
				String kod = rateObj.getString("code");
				BigDecimal kurs = rateObj.getJsonNumber("mid").bigDecimalValue();
				System.out.println(kod + " " + nazwa + ": " + kurs);
			}
		} catch (IOException | URISyntaxException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}

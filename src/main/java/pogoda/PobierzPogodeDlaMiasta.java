package pogoda;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

public class PobierzPogodeDlaMiasta {
	private Scanner scanner = new Scanner(System.in);
	private double lat;
	private double lon;
	private String miasto;
	

	public static void main(String[] args) {
		new PobierzPogodeDlaMiasta().run();
	}

	public void run() {
		try {
		System.out.print("Podaj nazwę miasta: ");
		String szukane = scanner.nextLine();
		if(znajdzMiasto(szukane)) {
			pobierzIWypiszPogode();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean znajdzMiasto(String szukane) throws IOException {
		URL url = new URL("https://geocoding-api.open-meteo.com/v1/search?name=" + szukane);
		try(InputStream input = url.openStream();
			JsonReader reader = Json.createReader(input)) {
			JsonObject json = reader.readObject();
			JsonArray results = json.getJsonArray("results");
			if(results.isEmpty()) {
				System.out.println("Brak znalezionych lokalizacji");
				return false;
			}
			System.out.println("Znalezione lokalizacje:");
			int i = 0;
			for(JsonValue result : results) {
				JsonObject resulto = result.asJsonObject();
				//System.out.print(result);
				System.out.printf("%2d: <%+.3f %+.3f> → %s, %s%n", i++,
						resulto.getJsonNumber("latitude").doubleValue(),
						resulto.getJsonNumber("longitude").doubleValue(),
						resulto.getString("name"), resulto.getString("country"));
			}
			System.out.print("Wybierz numer lokalizacji: ");
			i = scanner.nextInt();
			if(i < 0 || i >= results.size()) {
				return false;
			}
			JsonObject loc = results.getJsonObject(i);
			lat = loc.getJsonNumber("latitude").doubleValue();
			lon = loc.getJsonNumber("longitude").doubleValue();
			miasto = loc.getString("name");
			return true;
		}
	}
	
	private void pobierzIWypiszPogode() throws IOException {
		URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude="+ lon +"&current_weather=true&hourly=temperature_2m");
		try(InputStream input = url.openStream();
			JsonReader reader = Json.createReader(input)) {
			JsonObject json = reader.readObject();
			JsonObject weather = json.getJsonObject("current_weather");
			
			System.out.printf("Bieżąca pogoda dla miasta %s:%n", miasto);
			System.out.println(weather);
			System.out.printf("Temperatura %.1f °C%n", weather.getJsonNumber("temperature").doubleValue());
			System.out.printf("Wiatr:      %.1f km/h%n", weather.getJsonNumber("windspeed").doubleValue());
		}
	}
	
}

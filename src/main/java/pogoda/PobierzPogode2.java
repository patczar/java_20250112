package pogoda;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Pobieramy pogodę dla konkretnej lokalizacji (współrzędne Warszawy)
// parsujemy JSONa i wyciągamy informację o temperaturze
public class PobierzPogode2 {

    public static void main(String[] args) {
        String adres = "https://api.open-meteo.com/v1/forecast?latitude=52&longitude=21&current_weather=true";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(new URI(adres)).build();
            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

            JsonReader reader = Json.createReader(response.body());
            JsonObject json = reader.readObject();
            System.out.println("Cały JSON: " + json);
            JsonObject weather = json.getJsonObject("current_weather");
            System.out.println("weather: " + weather);
            double temperatura = weather.getJsonNumber("temperature").doubleValue();
            System.out.println("temperatura: " + temperatura);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

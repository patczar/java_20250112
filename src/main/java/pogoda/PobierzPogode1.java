package pogoda;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Pobieramy pogodę dla konkretnej lokalizacji (współrzędne Warszawy)
// i wypisujemy surowe dane JSON.
public class PobierzPogode1 {

    public static void main(String[] args) {
        String adres = "https://api.open-meteo.com/v1/forecast?latitude=52&longitude=21&current_weather=true";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(new URI(adres)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String tekstJSON = response.body();
            System.out.println(tekstJSON);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

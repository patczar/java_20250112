package p12_http;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClient1_PobierzIWypisz {

    public static void main(String[] args) {
        final String ADRES = "http://api.nbp.pl/api/exchangerates/tables/a/";

        try {
            System.out.println("Startujemy...");
            URI uri = new URI(ADRES);
            HttpClient httpClient = HttpClient.newHttpClient();
            System.out.println("Mam klienta: " + httpClient);
            System.out.println("Wysyłam zapytanie...");
            HttpRequest request = HttpRequest.newBuilder(uri).build();
            HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
            System.out.println("Mam odpowiedź: " + response);
            System.out.println("Kod: " + response.statusCode());
            System.out.println("Content-Type: " + response.headers().firstValue("Content-Type").orElse("--nieokreślony--"));
            String body = response.body();
            System.out.println("Rozmiar treści: " + body.length());
            System.out.println(body.substring(0, 80));
            System.out.println("Gotowe.");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}

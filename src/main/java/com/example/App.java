package com.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public final class App {
    private static final String URL = "https://imdb-api.com/en/API/Top250Movies/k_5w2djuhi";

    public static void main(String[] args) {
        try {
            HttpRequest request = HttpRequest.newBuilder(new URI(URL))
                    .version(HttpClient.Version.HTTP_2)
                    .GET()
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> httpResponse = httpClient.send(request, BodyHandlers.ofString());

            System.out.println("Result: \n" + httpResponse.body());

        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}

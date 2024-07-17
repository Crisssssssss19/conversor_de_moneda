package com.cris.conversor.moneda;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ValorMoneda {


    public String buscarMoneda(String moneda) throws IOException, InterruptedException {
        String url = "https://v6.exchangerate-api.com/v6/898f7b8a600af08d156bc830/latest/"+moneda;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        return json;
    }

    public Double valorConversion(int cantidad, Double valor){
        return valor * cantidad;
    }
}

package br.com.ProjectATFinal.Util;

import br.com.ProjectATFinal.Exception.ResourceNotFoundException;
import br.com.ProjectATFinal.Model.Personagem;
import br.com.ProjectATFinal.Model.Planeta;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PlanetaUtil {
    public Planeta getById(int id) {
        String url = "https://dragonball-api.com/api/planets/" + id;
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .version(HttpClient.Version.HTTP_2)
                    .uri(new URI(url))
                    .build();

            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 400){
                throw new ResourceNotFoundException(response.body());
            }
            System.out.println("Status code:" + response.statusCode());
            ObjectMapper objectMapper = new ObjectMapper();
            Planeta planeta = objectMapper.readValue(response.body(), Planeta.class);
            return planeta;


        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
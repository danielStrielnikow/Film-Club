package pl.danielstrielnikow.filmclub.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.danielstrielnikow.filmclub.api.dto.FilmApiDto;
import pl.danielstrielnikow.filmclub.domain.film.Film;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class FilmApi {
    private final ObjectMapper objectMapper;

    @Value("${api.key}")
    private String API_KEY;


    public FilmApi(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public List<FilmApiDto> fetchFilmFromApi() throws IOException, InterruptedException {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://imdb236.p.rapidapi.com/imdb/top250-movies"))
                    .header("x-rapidapi-key", API_KEY)
                    .header("x-rapidapi-host", "imdb236.p.rapidapi.com")
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(
                    response.body(),
                    new TypeReference<>() {
                    }
            );

    }


}

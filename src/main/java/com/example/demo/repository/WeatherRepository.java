package com.example.demo.repository;

import com.example.demo.model.WeatherDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Repository
public class WeatherRepository {
    private final WebClient webClient;

    @Value("${weatherapi.token}")
    private String token;

    public WeatherRepository(WebClient.Builder builder) {
        webClient = builder.baseUrl("https://api.openweathermap.org/data/2.5").build();
    }

    public Mono<WeatherDetails> getWeatherDetails() {
        return webClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weather")
                        .queryParam("lat", "35.794238297241435")
                        .queryParam("lon", "-78.69940445049596")
                        .queryParam("units", "metric")
                        .queryParam("appid", token)
                        .build())
                .retrieve()
                .bodyToMono(WeatherDetails.class);

    }
}

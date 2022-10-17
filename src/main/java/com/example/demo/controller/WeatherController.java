package com.example.demo.controller;

import com.example.demo.model.WeatherDetails;
import com.example.demo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WeatherController {
    @Autowired
    public WeatherService service;

    @GetMapping("/get_weather_details")
    public Mono<WeatherDetails> getWeatherDetails() {
        return service.getWeatherDetails();
    }
}

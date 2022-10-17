package com.example.demo.service;

import com.example.demo.model.WeatherDetails;
import com.example.demo.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WeatherService {

    @Autowired
    public WeatherRepository repository;

    public Mono<WeatherDetails> getWeatherDetails() {
        return repository.getWeatherDetails();
    }
}

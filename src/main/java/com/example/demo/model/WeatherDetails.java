package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherDetails {
    @JsonProperty("base")
    public String base;
    @JsonProperty("visibility")
    public Integer visibility;
}

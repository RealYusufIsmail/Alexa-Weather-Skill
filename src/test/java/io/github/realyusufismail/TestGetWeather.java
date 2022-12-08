package io.github.realyusufismail;

import io.github.realyusufismail.utils.WeatherRetriever;

public class TestGetWeather {
    public static void main(String[] args) {
        var weather = WeatherRetriever.getWeather("London");
        System.out.println(weather);
    }
}

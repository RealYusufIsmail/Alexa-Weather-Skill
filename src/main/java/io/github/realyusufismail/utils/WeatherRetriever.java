package io.github.realyusufismail.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class WeatherRetriever {
    public static String getWeather(String city) {
        OkHttpClient client = new OkHttpClient();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/weatherdata/forecast").newBuilder();
        urlBuilder.addQueryParameter("aggregateHours", "24")
                .addQueryParameter("contentType", "json")
                .addQueryParameter("unitGroup", "metric")
                .addQueryParameter("locationMode", "single")
                .addQueryParameter("key", "1PYNQ6AWUDJE9AFERDCHJHSXK")
                .addQueryParameter("locations", city + ",Uk");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        JsonNode jsonNode = null;
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            jsonNode = new ObjectMapper().readTree(Objects.requireNonNull(response.body()).string());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if (jsonNode==null) {
            System.out.printf("No weather forecast data returned%n");
            return null;
        }

        JsonNode days = jsonNode.get("locations").get(city + ",Uk").get("values");
        JsonNode day = days.get(0);
        return day.get("conditions").asText();
    }
}

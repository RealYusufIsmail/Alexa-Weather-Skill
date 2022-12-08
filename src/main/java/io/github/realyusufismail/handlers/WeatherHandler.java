package io.github.realyusufismail.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import io.github.realyusufismail.utils.WeatherRetriever;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class WeatherHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput) {
        return handlerInput.matches(intentName("WeatherIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        final var city = handlerInput.getRequestEnvelope().getRequest().getLocale();
        final var weather = WeatherRetriever.getWeather(city);
        final var speechText = "The weather in " + city + " is " + weather;
        return handlerInput.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("Weather", speechText)
                .build();
    }
}

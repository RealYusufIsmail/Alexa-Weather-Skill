package io.github.realyusufismail.handlers.basic;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;

public class LaunchRequestHandler implements com.amazon.ask.dispatcher.request.handler.impl.LaunchRequestHandler {
    @Override
    public boolean canHandle(HandlerInput input, LaunchRequest launchRequest) {
        return input.matches(requestType(LaunchRequest.class));
    }

    @Override
    public Optional<Response> handle(HandlerInput input, LaunchRequest launchRequest) {
        return input.getResponseBuilder()
                .withSpeech("Welcome to the weather skill, you can ask me for the weather in a city located in the United Kingdom")
                .build();
    }
}

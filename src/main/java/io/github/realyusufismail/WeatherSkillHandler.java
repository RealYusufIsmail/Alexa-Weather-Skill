package io.github.realyusufismail;

import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

import io.github.realyusufismail.handlers.WeatherHandler;
import io.github.realyusufismail.handlers.basic.LaunchRequestHandler;
import io.github.realyusufismail.handlers.basic.WelcomeRequestHandler;

@SuppressWarnings("unused")
public class WeatherSkillHandler extends SkillStreamHandler {

    public WeatherSkillHandler() {
        super(Skills.standard()
                .addRequestHandlers(new WelcomeRequestHandler(), new LaunchRequestHandler(), new WeatherHandler())
                .build());
    }
}
package com.aopdemo.configs;

import com.aopdemo.SkiCoach;
import com.aopdemo.SwimCoach;
import com.aopdemo.services.Coach;
import com.aopdemo.services.FortuneService;
import com.aopdemo.services.SadFortuneService;
import com.aopdemo.services.SnowFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("sport.properties")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }

    @Bean
    public FortuneService snowFortuneService() {
        return new SnowFortuneService();
    }

    @Bean
    public Coach skiCoach() {
        return new SkiCoach(snowFortuneService());
    }
}

package org.example.spring.annotationExample;

import org.example.spring.annotationExample.Calculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProgramConfig {
    @Bean
    public Calculator getCalculatorBean() {
        return new Calculator();
    }
}

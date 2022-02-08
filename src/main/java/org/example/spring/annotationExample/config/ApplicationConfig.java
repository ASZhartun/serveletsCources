package org.example.spring.annotationExample.config;

import org.example.spring.annotationExample.MessageBox;
import org.example.spring.annotationExample.ProgramConfig;
import org.example.spring.annotationExample.TextGenerator;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "org.example.spring.polymorphizm")
@Import(ProgramConfig.class)
public class ApplicationConfig {
    @Bean("textGeneratorBean")
    @Scope("prototype")
    public TextGenerator getTextGeneratorBean() {
        return new TextGenerator();
    }

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public MessageBox getMessageBox() {
        return new MessageBox(getTextGeneratorBean());
    }

}

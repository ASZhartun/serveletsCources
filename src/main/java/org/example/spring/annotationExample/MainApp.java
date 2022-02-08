package org.example.spring.annotationExample;

import org.example.spring.annotationExample.config.ApplicationConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MessageBox messageBox = context.getBean(MessageBox.class);
        messageBox.printMessage();
        Calculator bean = context.getBean(Calculator.class);
        System.out.println(bean.subtract(10,9));
    }
}

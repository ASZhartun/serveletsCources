package org.example.spring.polymorphizm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("common-beans.xml");
        Drawer drawer = (Drawer) context.getBean("drawer");
        drawer.paintAsADream();
    }
}

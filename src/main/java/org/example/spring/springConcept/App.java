package org.example.spring.springConcept;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("common-beans.xml");
        Calculator calculatorBean = (Calculator) context.getBean("calculatorBean");
        int add = calculatorBean.add(5, 3);
        System.out.println(calculatorBean.summa);

        Calculator calculatorBean2 = (Calculator) context.getBean("calculatorBean");
        int add2 = calculatorBean2.add(5, 3);
        System.out.println(calculatorBean2.summa);

        Calculator calculatorBean3 = (Calculator) context.getBean("calculatorBean");
        int add3 = calculatorBean3.add(5, 3);
        System.out.println(calculatorBean3.summa);


        int result = calculatorBean.add("three", "four");
        System.out.println(result);

    }
}

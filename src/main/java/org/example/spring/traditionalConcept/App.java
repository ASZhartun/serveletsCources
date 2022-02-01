package org.example.spring.traditionalConcept;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int add = calculator.add(5, 3);
        System.out.println(add);

        int add1 = calculator.add("two", "three");
        System.out.println(add1);
    }
}

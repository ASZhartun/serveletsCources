package org.example.spring.traditionalConcept;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(String a, String b) {
        Translator translator = new Translator();
        return translator.translate(a) + translator.translate(b);
    }
}

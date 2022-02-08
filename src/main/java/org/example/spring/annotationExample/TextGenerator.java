package org.example.spring.annotationExample;

public class TextGenerator {
    public TextGenerator() {
        System.out.println("TextGenerator constructor.");
    }

    public String generate(){
        String text = "something types and another word for this example...";
        return text;
    }
}

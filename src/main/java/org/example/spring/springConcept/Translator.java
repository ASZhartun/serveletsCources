package org.example.spring.springConcept;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("translatorBean")
@Scope("singleton")
public class Translator {
    public int translate(String word) {
        if (word.equals("one")) {
            return 1;
        } else if (word.equals("two")) {
            return 2;
        } else if (word.equals("three")) {
            return 3;
        } else if (word.equals("four")) {
            return 4;
        } else if (word.equals("five")) {
            return 5;
        } else return 0;
    }
}
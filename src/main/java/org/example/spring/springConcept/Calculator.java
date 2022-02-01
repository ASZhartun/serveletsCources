package org.example.spring.springConcept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("calculatorBean")
@Scope("prototype")
public class Calculator {

    @Autowired
    Translator translatorObj;

//    public Translator getTranslatorObj() {
//        return translatorObj;
//    }
//
//    public void setTranslatorObj(Translator translatorObj) {
//        this.translatorObj = translatorObj;
//    }


    public Calculator(Translator translatorObj) {
        this.translatorObj = translatorObj;
    }

    public int summa = 100;

    public int add(int a, int b) {
        int result = a + b;
        summa += result;
        return result;
    }

    public int add(String a, String b) {
        return translatorObj.translate(a) + translatorObj.translate(b);
    }


    public void myInitMethod(){
        System.out.println("Pupa");
    }


    public void myDestroyMethod(){
        System.out.println("Lupa");
    }

}

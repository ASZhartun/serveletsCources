package org.example.spring.annotationExample;

import org.springframework.beans.factory.annotation.Autowired;

public class MessageBox {
    private TextGenerator textGenerator;


    public MessageBox(TextGenerator textGenerator) {
        System.out.println("MessageBox constructor with 1 parameter");
        this.textGenerator = textGenerator;
    }

    public MessageBox() {

    }

    public void printMessage(){
        String generate = textGenerator.generate();
        System.out.println(generate);
    }

    public void initMethod() {
        System.out.println("INIT");
    }

    public void destroyMethod() {
        System.out.println("DESTROY");
    }
}

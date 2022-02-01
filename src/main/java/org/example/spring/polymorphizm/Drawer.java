package org.example.spring.polymorphizm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Drawer {


    @Autowired
    @Qualifier("triangle")
    Figure figure;


    public void paintAsADream() {
        figure.drawLeft();
        figure.drawCenter();
        figure.drawLeft();
        figure.drawCenter();
        figure.drawRight();
        figure.drawRight();
        figure.drawRight();
        figure.drawCenter();
    }
}

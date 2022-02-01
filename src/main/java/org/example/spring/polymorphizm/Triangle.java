package org.example.spring.polymorphizm;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Figure{
    @Override
    public void drawLeft() {
        System.out.println("     #       ");
        System.out.println("    ###      ");
        System.out.println("  #######    ");
        System.out.println(" #########   ");
        System.out.println("###########  ");
    }

    @Override
    public void drawCenter() {
        System.out.println("                     #       ");
        System.out.println("                    ###      ");
        System.out.println("                  #######    ");
        System.out.println("                 #########   ");
        System.out.println("                ###########  ");
    }

    @Override
    public void drawRight() {
        System.out.println("                                        #       ");
        System.out.println("                                       ###      ");
        System.out.println("                                     #######    ");
        System.out.println("                                    #########   ");
        System.out.println("                                   ###########  ");
    }
}

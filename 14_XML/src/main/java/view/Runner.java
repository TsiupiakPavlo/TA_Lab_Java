package view;

import controller.Collection;

public class Runner {

    public static void main(String[] args) {
        Collection.getInstance();
        new MainMenu();
    }

}

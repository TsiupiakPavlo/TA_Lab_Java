package view;

import controller.*;
import model.Sites;

import java.io.File;

public class MainMenu {
    private ClassLoader classLoader = getClass().getClassLoader();
    private File file = new File(classLoader.getResource("xml/sites.xml").getFile());

    public MainMenu() {
        Menu mainMenu = new Menu(new String[]{"SAX", "DOM", "StAX",
                "Show collection", "Exit"});
        boolean notExit = true;
        while (notExit) {
            mainMenu.print();
            try {
                switch (mainMenu.getChoise()) {
                    case 1: {
                        SAXController sax = new SAXController();
                        sax.parse(file);
                        System.out.println("SAX work out");
                        break;
                    }
                    case 2: {
                        DOMController dom = new DOMController(file.getAbsolutePath());
                        dom.parse(file);
                        System.out.println("DOM work out");
                        break;
                    }
                    case 3: {
                        StAXController stax = new StAXController();
                        stax.parse(file);
                        System.out.println("StAX work out");
                        break;
                    }
                    case 4: {
                        for (Sites sites : Collection.getArrayList()) {
                            System.out.println(sites);
                            System.out.println();
                        }
                        break;
                    }
                    case 5: {
                        notExit = false;
                        break;
                    }
                    default: {
                        System.out.println("Wrong command");
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

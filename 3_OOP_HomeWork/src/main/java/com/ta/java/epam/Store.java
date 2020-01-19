package com.ta.java.epam;

import com.ta.java.epam.entity.materials.Hruntovky;
import com.ta.java.epam.entity.santekhnika.ColorOfVanna;
import com.ta.java.epam.entity.santekhnika.Vanna;
import com.ta.java.epam.entity.santekhnika.zmishucavhi.Zmishuvachi;
import com.ta.java.epam.entity.santekhnika.zmishucavhi.ZmishuvachiKukhnia;

public class Store {
    public static void main(String[] args) {
        Hruntovky hruntovky = new Hruntovky("VD404", 300, 35, "Deep", "Grud");
        System.out.println(hruntovky.getName());

        Vanna vanna = new Vanna("Apollo", 3000, "Italy", 1, "circle", ColorOfVanna.WHITE);
        System.out.println(vanna.getColorOfVanna());

        Zmishuvachi zmishuvachi = new ZmishuvachiKukhnia("Hravi", 550, "Germany", 3, "first", "podvodka");
        System.out.println(zmishuvachi.getMechanism());
    }
}

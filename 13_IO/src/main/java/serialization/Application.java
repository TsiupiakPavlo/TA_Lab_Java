package serialization;

import org.apache.log4j.Logger;
import serialization.model.Droid;
import serialization.model.Ship;

import java.io.*;

public class Application {

    static File SHIP_SERIALIZATION = new File("ship.ser");
    final static Logger LOGGER = Logger.getLogger(String.valueOf(Application.class));

    public static void main(String[] args) {

        Ship droidShip = new Ship();
        droidShip.addDroid(new Droid("Droid1", 1));
        droidShip.addDroid(new Droid("Droid2", 1));
        droidShip.addDroid(new Droid("Droid3", 2));
        LOGGER.info(droidShip);

        //SERIALIZATION
        try {
            FileOutputStream fos = new FileOutputStream(SHIP_SERIALIZATION);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(droidShip);

            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //DESERIALIZATION
        Ship droidShipDeserialized;

        try {
            FileInputStream fis = new FileInputStream(SHIP_SERIALIZATION);
            ObjectInputStream ois = new ObjectInputStream(fis);

            droidShipDeserialized = (Ship) ois.readObject();
            LOGGER.info(droidShipDeserialized);

            fis.close();
            ois.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

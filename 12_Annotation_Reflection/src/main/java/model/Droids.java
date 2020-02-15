package model;

import annotation.ControlledObject;
import annotation.StartObject;
import annotation.StopObject;
import annotation.ValueObject;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@ControlledObject(name = "droid")
public class Droids {

    final static Logger LOGGER = Logger.getLogger(Droids.class);

    @StartObject
    public void createDroid() {
        LOGGER.info("Create droid");
    }

    @StopObject
    public void removeDroid() {
        LOGGER.info("Remove droid");
    }

    @ValueObject(time = 15)
    public void getValue() throws NoSuchMethodException {
        Droids droids = new Droids();
        Class c = droids.getClass();
        Method m = c.getMethod("getValue");
        ValueObject valueObject = m.getAnnotation(ValueObject.class);
        LOGGER.info(valueObject.time());
    }

    /*public void getAnnotationValue() {
        for (Field f : Droids.class.getFields()) {
            ControlledObject column = f.getAnnotation(ControlledObject.class);
            if (column != null) {
                LOGGER.info(column.name());
            }
        }
    }*/
}
package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethodInvokeExample {

    private static void processString(String str) {
        System.out.println("processing " + str);
    }

    private static void processInt(int num) {
        System.out.println("processing " + num);
    }

    private static void processDouble(double num) {
        System.out.println("processing " + num);
    }

    public static void main(String... args) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        Method mString = ReflectMethodInvokeExample.class.getDeclaredMethod("processString", String.class);
        Object rvString = mString.invoke(null, "test");
        //System.out.println(rvString);

        Method mInt = ReflectMethodInvokeExample.class.getDeclaredMethod("processInt", int.class);
        Object rvInt = mInt.invoke(null, 10);
        //System.out.println(rvInt);

        Method mDouble = ReflectMethodInvokeExample.class.getDeclaredMethod("processDouble", double.class);
        Object rvDouble = mDouble.invoke(null, 1.1);
        //System.out.println(rvDouble);
    }
}
import model.Droids;

public class Application {
    public static void main(String[] args) throws NoSuchMethodException {
        Droids droids = new Droids();
        droids.createDroid();
        droids.removeDroid();
        //droids.getAnnotationValue();
        droids.getValue();
    }
}

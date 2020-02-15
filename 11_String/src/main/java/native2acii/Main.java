package native2acii;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter native text");
        Converter converter = new Converter();
        System.exit(converter.convert(args) ? 0 : 1);
    }
}

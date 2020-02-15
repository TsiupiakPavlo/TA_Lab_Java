package string_utils;

public class Model {
    String definition;
    int num;

    public Model(String definition, int num) {
        this.definition = definition;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Model{" +
                "definition='" + definition + '\'' +
                ", num=" + num +
                '}';
    }
}

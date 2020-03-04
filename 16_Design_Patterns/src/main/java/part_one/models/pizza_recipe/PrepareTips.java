package part_one.models.pizza_recipe;

public class PrepareTips {
    public static void appendWithNewLine(StringBuilder stringBuilder, String string) {
        stringBuilder.append(string);
        stringBuilder.append(System.lineSeparator());
    }

    public void prepareDoughTips() {
        StringBuilder tips = new StringBuilder();
        appendWithNewLine(tips, "Taking out the pizza dough from the refrigerator...");
        appendWithNewLine(tips, "Covering it and let it warm up to room temperature...");
        appendWithNewLine(tips, "Covering the dough keeps the surface from drying out and forming a crust...");
        System.out.print(tips.toString());
    }

    public void stretchDoughTips() {
        StringBuilder tips = new StringBuilder();
        appendWithNewLine(tips, "Stretching and flattening the dough on a floured work surface...");
        System.out.print(tips.toString());
    }

    public void addSauceTips() {
        StringBuilder tips = new StringBuilder();
        appendWithNewLine(tips, "Spreading the sauce evenly over the dough...");
        System.out.print(tips.toString());
    }
}

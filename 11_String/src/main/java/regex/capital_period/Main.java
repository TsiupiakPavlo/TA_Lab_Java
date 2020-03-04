package regex.capital_period;

import org.apache.log4j.Logger;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);

    public boolean checkStartCapitalEndPeriod(String s) {
        return s.matches("^[A-Z].*\\.$");
    }

    public static void main(String[] args) {
        Main main = new Main();
        logger.info(main.checkStartCapitalEndPeriod("Start and end."));
    }
}

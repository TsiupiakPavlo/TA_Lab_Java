package string_utils;

import org.apache.log4j.Logger;

public class StringUtils {
    final static Logger logger = Logger.getLogger(StringUtils.class);

    static String concat(Object... arg) {
        StringBuilder builder = new StringBuilder();
        for (Object object : arg)
            builder.append(object).append(" ");
        return builder.toString();
    }

    public static void main(String[] args) {
        StringUtils utils = new StringUtils();
        String[] arrString = {"1", "2", "3"};
        logger.info(utils.concat(arrString));
        Model[] arrModel = {new Model("num", 32), new Model("num", 14)};
        logger.info(utils.concat(arrModel));
    }
}

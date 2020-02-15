package regex.replaceAll;

import org.apache.log4j.Logger;
import string_utils.StringUtils;

import java.util.Scanner;

public class Main {
    final static Logger logger = Logger.getLogger(StringUtils.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str.replaceAll("[aeiou]", "_");
        logger.info(str);
    }
}

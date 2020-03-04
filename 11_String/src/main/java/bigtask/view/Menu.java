package bigtask.view;

import bigtask.model.Regex;
import bigtask.model.Sentence;
import bigtask.model.Word;
import bigtask.utils.parser.TextFileParsing;
import org.apache.log4j.Logger;

import java.io.*;

public class Menu {
    final static Logger LOGGER = Logger.getLogger(Menu.class);

    final static String PATH = "fileTest.txt";

    private TextFileParsing fileParsing = new TextFileParsing();
    private Sentence interrogativeSentences = new Sentence();
    private Word words = new Word();

    public Menu() {
        ClassLoader classLoader = getClass().getClassLoader();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice = -1;

        File file = new File(classLoader.getResource(PATH).getFile());

        while (choice != 0) {
            LOGGER.info("\nChoose one of the options:");
            LOGGER.info("1. Parse text");
            LOGGER.info("2. Remove spaces and tabs");
            LOGGER.info("3. Find emails");
            LOGGER.info("4. Find Phones");
            LOGGER.info("5. Find interrogative sentences");
            LOGGER.info("6. Find words of a given length in interrogative sentences");
            LOGGER.info("0. Exit");

            try {
                choice = Integer.parseInt(bufferedReader.readLine());
            } catch (IOException e) {
                System.out.println("Invalid option");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    fileParsing.parsing(file);
                    LOGGER.info(fileParsing.getText());
                    break;

                case 2:
                    fileParsing.setText(fileParsing.replaceTab(fileParsing.getText()));
                    LOGGER.info(fileParsing.getText());
                    break;

                case 3:
                    LOGGER.info(words.findInString(fileParsing.getText(), Regex.EMAILS.getRegex()));
                    break;

                case 4:
                    LOGGER.info(words.findInString(fileParsing.getText(), Regex.PHONES.getRegex()));
                    break;

                case 5:
                    interrogativeSentences.setSentences(interrogativeSentences.findInString(fileParsing.getText(), Regex.INTERROGATIVE_SENTENCES.getRegex()));
                    interrogativeSentences.printArraySentences(interrogativeSentences.getSentences());
                    break;

                case 6:
                    int length = 0;
                    System.out.println("Enter the length of words to search");
                    try {
                        length = Integer.parseInt(bufferedReader.readLine());
                    } catch (IOException e) {
                        System.out.println("Invalid option");
                        choice = 0;
                    }
                    words.setWords(words.findInList(interrogativeSentences.getSentences(), Regex.WORDS.getRegex()));
                    words.printSetWords(words.findByLength(words.getWords(), length));
                    break;

                case 0:
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.exit(0);
                    break;

                default:
                    break;
            }
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


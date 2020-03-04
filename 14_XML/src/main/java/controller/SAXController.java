package controller;

import model.Sites;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class SAXController {

    private File file;

    public SAXController(String path) {
        file = new File(path);
    }

    public List<Sites> parseDoc(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        SAXHandler handler = new SAXHandler();
        try {
            Objects.requireNonNull(parser).parse(file, handler);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return handler.getCandies();
    }
}

package controller;

import model.Sites;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SAXController {

    private File file;

    public SAXController(String path) {
        file = new File(path);
    }

    public List<Sites> parseDoc() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        List<Sites> sites = new ArrayList<>();
        return sites;
    }
}

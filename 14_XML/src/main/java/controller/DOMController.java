package controller;

import model.Chars;
import model.Sites;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DOMController {

    private Document document;

    public DOMController(String path) {
        document = getDocument(path);
    }

    private Document getDocument(String path) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = Objects.requireNonNull(builder).parse(path);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public void parse(File xmlFile) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory
                    .newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document
                    .getElementsByTagName(document.getDocumentElement()
                            .getChildNodes().item(1).getNodeName());
            Collection.clear();
            for (int i = 0; i < nodeList.getLength(); i++) {
                List<Chars> chars = new ArrayList<>();
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Sites sites = new Sites();
                    sites.setTitle(element.getElementsByTagName("title").item(0)
                            .getChildNodes().item(0).getNodeValue());
                    sites.setSiteType(element.getElementsByTagName("site_type").item(0)
                            .getChildNodes().item(0).getTextContent());
                    NodeList nodeListChars = document.getElementsByTagName("chars");
                    for (int j = 0; j < nodeListChars.getLength(); j++) {
                        Node nodeChars = nodeList.item(i);
                        if (nodeChars.getNodeType() == Node.ELEMENT_NODE) {
                            Element elementChars = (Element) nodeChars;
                            Chars charsElement = parseChar(elementChars.getElementsByTagName("chars"), j);
                            chars.add(charsElement);
                        }
                    }
                    sites.setAuthAccess(Boolean.parseBoolean(element.getElementsByTagName("auth_access").item(0).getNodeValue()));
                    Collection.add(sites);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    private Chars parseChar(NodeList node, int counter) {
        Chars c = new Chars();
        if (node.item(counter).getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node.item(counter);
            c.setMailPresence(Boolean.parseBoolean(element.getElementsByTagName("mailPresence").
                    item(0).getTextContent()));
            c.setNewsPresence(Boolean.parseBoolean(element.getElementsByTagName("newsPresence").
                    item(0).getTextContent()));
            c.setVote(String.valueOf(element.getElementsByTagName("vote").item(0).getTextContent()));
            c.setPayment(Boolean.parseBoolean(element.getElementsByTagName("payment").
                    item(0).getTextContent()));
        }
        return c;
    }
}

package controller;

import com.sun.jdi.Value;
import model.Chars;
import model.Sites;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class StAXController {
    private File file;

    public StAXController(String path) {
        file = new File(path);
    }

    public List<Sites> parseDoc() throws FileNotFoundException {
        List<Sites> sites = new ArrayList<>();
        Sites site = null;
        Value value = null;
        Chars chars = null;
        List<Chars> charsList = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory
                    .createXMLEventReader(new FileInputStream(file));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    String name = startElement.getName().getLocalPart();
                    switch (name) {
                        case "site":
                            site = new Sites();
                            Attribute siteTitle = startElement.getAttributeByName(new QName("title"));
                            if (siteTitle != null) {
                                site.setTitle(xmlEvent.asCharacters().getData());
                            }
                            break;
                        case "site_type":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert site != null;
                            site.setSiteType(xmlEvent.asCharacters().getData());
                            break;
                        case "chars":
                            xmlEvent = xmlEventReader.nextEvent();
                            chars = new Chars();
                            break;
                        case "mailPresence":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert chars != null;
                            chars.setMailPresence(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                            break;
                        case "newsPresence":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert chars != null;
                            chars.setNewsPresence(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                            break;
                        case "archivePresence":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert chars != null;
                            chars.setArchivePresence(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                            break;
                        case "vote":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert chars != null;
                            chars.setVote(xmlEvent.asCharacters().getData());
                            break;
                        case "payment": {
                            xmlEvent = xmlEventReader.nextEvent();
                            assert chars != null;
                            chars.setPayment(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                            break;
                        }
                        case "auth_access":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert site != null;
                            site.setAuthAccess(Boolean.parseBoolean(xmlEvent.asCharacters().getData()));
                            break;
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("site")) {
                        //Objects.requireNonNull(site).setValue(value);
                        site.setChars(charsList);
                        sites.add(site);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println("Parser failed!");
        }
        return sites;
    }
}

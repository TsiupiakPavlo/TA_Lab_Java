package controller;

import com.sun.jdi.Value;
import model.*;

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
        List<Sites> candies = new ArrayList<>();
        Sites sites = null;
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
                        case "candy":
                            candy = new Candy();
                            Attribute candyId = startElement.getAttributeByName(new QName("candyId"));
                            if (candyId != null) {
                                candy.setCandyId(Integer.parseInt(candyId.getValue()));
                            }
                            break;
                        case "candyName":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert candy != null;
                            candy.setCandyName(xmlEvent.asCharacters().getData());
                            break;
                        case "energy":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert candy != null;
                            candy.setEnergy(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "type":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert candy != null;
                            candy.setType(Type.valueOf(xmlEvent.asCharacters().getData()));
                            break;
                        case "value":
                            xmlEvent = xmlEventReader.nextEvent();
                            value = new Value();
                            break;
                        case "protein":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert value != null;
                            value.setProtein(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "fat":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert value != null;
                            value.setFat(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "carbohydrate":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert value != null;
                            value.setCarbohydrate(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "productionName":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert candy != null;
                            candy.setProductionName(xmlEvent.asCharacters().getData());
                            break;
                        case "charsList": {
                            xmlEvent = xmlEventReader.nextEvent();
                            charsList = new ArrayList<>();
                            break;
                        }
                        case "ingredient":
                            xmlEvent = xmlEventReader.nextEvent();
                            ingredient = new Ingredient();
                            break;
                        case "ingredientName":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert ingredient != null;
                            ingredient.setIngredientName(xmlEvent.asCharacters().getData());
                            break;
                        case "weight":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert ingredient != null;
                            ingredient.setWeight(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            Objects.requireNonNull(charsList).add(ingredient);
                            break;
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("candy")) {
                        Objects.requireNonNull(candy).setValue(value);
                        candy.setIngredients(charsList);
                        candies.add(candy);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            System.out.println("Parser failed!");
        }
        return candies;
    }
}

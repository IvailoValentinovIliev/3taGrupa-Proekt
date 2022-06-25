package bg.tu_varna.sit;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class XML {

    public void saveXML(ArrayList<Products> productsArrayList) {
        try {

            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document document = build.newDocument();

            Element root = document.createElement("Sklad");
            document.appendChild(root);

            for (Products products : productsArrayList) {

                Element product = document.createElement("product");
                root.appendChild(product);

                Element productName = document.createElement("productName");
                productName.appendChild(document.createTextNode(String.valueOf(products.getName())));
                product.appendChild(productName);

                Element expireDate = document.createElement("expireDate");
                expireDate.appendChild(document.createTextNode(String.valueOf(products.getExpire())));
                product.appendChild(expireDate);

                Element takeInDate = document.createElement("takeInDate");
                takeInDate.appendChild(document.createTextNode(String.valueOf(products.getDate())));
                product.appendChild(takeInDate);

                Element manufactName = document.createElement("manufactName");
                manufactName.appendChild(document.createTextNode(String.valueOf(products.getManufactName())));
                product.appendChild(manufactName);

                Element weight = document.createElement("weight");
                weight.appendChild(document.createTextNode(String.valueOf(products.getWeight())));
                product.appendChild(weight);

                Element quantity = document.createElement("quantity");
                quantity.appendChild(document.createTextNode(String.valueOf(products.getQuantity())));
                product.appendChild(quantity);

                Element location = document.createElement("location");
                location.appendChild(document.createTextNode(String.valueOf(products.getLocation())));
                product.appendChild(location);

            }

            try {
                // location and name of XML file
                FileWriter fos = new FileWriter("sklad.xml");
                StreamResult result = new StreamResult(fos);

            } catch (IOException e) {

                e.printStackTrace();
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new FileWriter("sklad.xml"));

            transformer.transform(domSource, streamResult);

            System.out.println("Project name:" + document.getDocumentElement().getNodeName() + "\n");
            NodeList nodeList = document.getElementsByTagName("product");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Product name:"
                            + element.getElementsByTagName("productName").item(0).getTextContent());
                    System.out.println("Expire date:"
                            + element.getElementsByTagName("expireDate").item(0).getTextContent());
                    System.out.println("Take in date:"
                            + element.getElementsByTagName("takeInDate").item(0).getTextContent());
                    System.out.println("Manufact name:"
                            + element.getElementsByTagName("manufactName").item(0).getTextContent());
                    System.out.println("Product weight:"
                            + element.getElementsByTagName("weight").item(0).getTextContent());
                    System.out.println("Product quantity:"
                            + element.getElementsByTagName("quantity").item(0).getTextContent());
                    System.out.println("Product location:"
                            + element.getElementsByTagName("location").item(0).getTextContent());
                    System.out.println("--------------------------------------");
                }
            }
        } catch (ParserConfigurationException | TransformerException | IOException pce) {
            pce.printStackTrace();
        }
    }

    public void openXML() {

        File file = new File("sklad.xml");
        if (file.exists()) {
            try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = docFactory.newDocumentBuilder();
                Document document = builder.parse(file);
            } catch (IOException | ParserConfigurationException | org.xml.sax.SAXException e) {
                e.printStackTrace();
            }
        } else {
            try {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = dbf.newDocumentBuilder();
                Document document = builder.newDocument();

                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer trans = tFactory.newTransformer();

                Element root = document.createElement("Sklad");
                document.appendChild(root);

                DOMSource source = new DOMSource(document);

                try {
                    FileWriter fileWriter = new FileWriter("sklad.xml");
                    StreamResult result = new StreamResult(fileWriter);
                    trans.transform(source, result);
                } catch (IOException | TransformerException e) {
                    e.printStackTrace();
                }
            } catch (ParserConfigurationException | TransformerConfigurationException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void closeXML() {
        try {
            File file = new File("sklad.xml");
            BufferedReader bf = new BufferedReader(new FileReader(file));
            bf.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
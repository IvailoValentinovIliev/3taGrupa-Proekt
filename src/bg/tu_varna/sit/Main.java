package bg.tu_varna.sit;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Products> productsArrayList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String choice;
        do {
            System.out.println("What would you like to do: ");
            System.out.println("Print all products: ");
            System.out.println("Add product");
            System.out.println("Create and print a XML file");
            System.out.println("Remove product");
            System.out.println("Quit");
            choice = scan.nextLine();
            switch (choice) {
                case "Print":
                    System.out.println("Printing all products!");
                    System.out.println(productsArrayList);
                    System.out.println("You chose:" + choice);
                    break;
                case "Add":
                    System.out.println("You started adding an item." + "\n");
                    System.out.println("Enter product name:");
                    String name = scan.nextLine();
                    System.out.println("Enter product expire date:");
                    double expire = Double.parseDouble(scan.nextLine());
                    System.out.println("Enter take in date of the product:");
                    double date = Double.parseDouble(scan.nextLine());
                    System.out.println("Enter the manufacture name of the product:");
                    String manufactoreName = scan.nextLine();
                    System.out.println("Enter the weight of the product:");
                    int weightOfProduct = Integer.parseInt(scan.nextLine());
                    System.out.println("Enter quantity of product:");
                    int quantityOfProduct = Integer.parseInt(scan.nextLine());
                    System.out.println("Enter location of product:");
                    String locationOfProduct = scan.nextLine();
                    System.out.println("You just added an item!" + "\n");
                    productsArrayList.add((new Products(name,expire,date,manufactoreName,weightOfProduct,quantityOfProduct,locationOfProduct)));
                    System.out.println("You chose:" + choice);
                    break;
                case "XML":
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

                        System.out.println("Done creating XML File" + "\n");

                        System.out.println("Project name:" + document.getDocumentElement().getNodeName() + "\n");
                        NodeList nodeList = document.getElementsByTagName("product");
                        for(int i=0; i<nodeList.getLength();i++)
                        {
                            Node node = nodeList.item(i);

                            if(node.getNodeType()== Node.ELEMENT_NODE)
                            {
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
                    System.out.println("You chose:" + choice);
                    break;
                case "Remove":
                    System.out.println("Please input the name of the product you`d like to remove:");
                    String ch = scan.nextLine();
                    for (int i = 0; i < productsArrayList.size(); i++) {
                        Products p = productsArrayList.get(i);
                        if (Objects.equals(ch, p.getName())) {
                            productsArrayList.remove(p);
                            System.out.println("Product removed!");
                            System.out.println("This product was located at:" + p.getLocation());
                        }
                        /*else {
                            System.out.println("Incorrect name!");
                        }*/
                    }
                    System.out.println("You choce:" + choice);
                    break;
                case "Quit":
                    System.out.println("Exiting the program.");
                    System.out.println("You choce:" + choice);
                    break;
            }
        } while (!choice.equals("Quit"));
    }
}
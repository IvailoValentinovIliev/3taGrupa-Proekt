package bg.tu_varna.sit;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    public void mainMenu(){
        XML xml = new XML();
        AddProducts addProducts = new AddProducts();
        PrintProducts printProducts = new PrintProducts();
        RemoveProducts removeProducts = new RemoveProducts();
        QuitTheProgram quitTheProgram = new QuitTheProgram();
        SubMenu subMenu = new SubMenu();
        ArrayList<Products> productsArrayList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String choice;
        boolean ocf = true;
        do {
            if(ocf) {

                subMenu.subMenu();
                choice = scan.nextLine();
                switch (choice) {
                    case "Print":
                        printProducts.printProducts(productsArrayList);
                        System.out.println("You chose:" + choice);
                        break;
                    case "Add":
                        addProducts.addProducts(productsArrayList);
                        System.out.println("You chose:" + choice);
                        break;
                    case "Remove":
                        removeProducts.removeProducts(productsArrayList);
                        System.out.println("You choce:" + choice);
                        break;
                    case "Open":
                        xml.openXML();
                        ocf = false;
                        System.out.println("Successfully opened sklad.xml \n");
                        break;
                    case "Quit":
                        quitTheProgram.quitTheProgram();
                        System.out.println("You choce:" + choice);
                        break;
                }
            }
            else{
                choice = scan.nextLine();
                switch (choice){
                   case "Help":
                        System.out.println("The following commands are supported:\n" + "Open <file> opens <file> \n" +
                                "Close closes currently opened file \n" +
                                "Save saves the currently open file \n" +
                                "Saveas <file> saves the currently open file in <file> \n" +
                                "Help prints this information \n" +
                                "Quit exists the program \n");
                        break;
                    case "Close":
                        xml.closeXML();
                        ocf = true;
                        System.out.println("Successfully closed sklad.xml \n");
                        break;
                    case"Save":
                        xml.saveXML(productsArrayList);
                        System.out.println("Successfully saved sklad.xml \n");
                        break;
                    case"SaveAs":
                        xml.saveXML(productsArrayList);
                        System.out.println("Successfully saved another sklad.xml\n");
                        break;
                    default:break;
                }
            }
        } while (!choice.equals("Quit"));
    }
}

package bg.tu_varna.sit;

import java.util.ArrayList;
import java.util.Scanner;

public class AddProducts {
    Scanner scan = new Scanner(System.in);
    public void addProducts(ArrayList<Products>productsArrayList){
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
    }
}

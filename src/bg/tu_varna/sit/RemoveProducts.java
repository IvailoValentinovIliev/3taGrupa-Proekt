package bg.tu_varna.sit;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RemoveProducts {
    Scanner scan = new Scanner(System.in);
    public void removeProducts(ArrayList<Products> productsArrayList){
        System.out.println("Please input the name of the product you`d like to remove:");
        String ch = scan.nextLine();
        for (int i = 0; i < productsArrayList.size(); i++) {
            Products p = productsArrayList.get(i);
            if (Objects.equals(ch, p.getName())) {
                productsArrayList.remove(p);
                System.out.println("Product removed!");
                System.out.println("This product was located at:" + p.getLocation());
                break;
            }
                        /*else {
                            System.out.println("Incorrect name!");
                        }*/
                    }
    }
}

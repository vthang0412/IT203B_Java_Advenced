package Session09.Btth;

import java.util.Scanner;

public class ProductFactory {
    public static Product createProduct(int type , Scanner sc){
        System.out.print("Nhap id: ");
        String id = sc.nextLine();
        System.out.print("Nhap name: ");
        String name = sc.nextLine();
        System.out.print("Nhap price: ");
        double price = Double.parseDouble(sc.nextLine());

        if(type == 1){
            System.out.println("Nhập weight: ");
            double weight = Double.parseDouble(sc.nextLine());
            return new PhysicalProduct(id, name, price, weight);
        }else {
            System.out.println("Nhập size: ");
            double size = Double.parseDouble(sc.nextLine());
            return new DigitalProduct(id, name, price, size);
        }
    }
}

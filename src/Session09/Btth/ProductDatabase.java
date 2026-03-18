package Session09.Btth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductDatabase {
    private static ProductDatabase instance;
    private List<Product> products;

    private ProductDatabase() {
        products = new ArrayList<>();
    }
    public static ProductDatabase getInstance() {
        if (instance == null) {
            instance = new ProductDatabase();
        }
        return instance;
    }
    public void addProduct(Product p) {
        products.add(p);
    }
    public void display(){
        if(products.isEmpty()){
            System.out.println("Danh sach rong");
            return;
        }
        for(Product p : products){
            p.displayInfo();
        }
    }
    public void deleteProduct(String id){
        products.removeIf(p -> p.id.equals(id));
    }

    public void updateProduct(String id, Scanner sc){
        for(Product p : products){
            if(p.id.equals(id)){
                System.out.println("Nhap ten moi:");
                p.name = sc.nextLine();
                System.out.println("Nhap gia tien moi:");
                p.price = Double.parseDouble(sc.nextLine());

                if (p instanceof PhysicalProduct) {
                    System.out.println("Nhap weight moi: ");
                    ((PhysicalProduct) p).weight = Double.parseDouble(sc.nextLine());
                } else if (p instanceof DigitalProduct) {
                    System.out.println("Nhap size moi: ");
                    ((DigitalProduct) p).size = Double.parseDouble(sc.nextLine());
                }

                System.out.println("Cap nhat thanh cong");
                return;
            }
        }
        System.out.println("Khong tim thay id de cap nhat");
    }
}

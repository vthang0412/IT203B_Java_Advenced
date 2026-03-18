package Session09.Btth;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();

        do{
            System.out.println("\n------ QUAN LY SAN PHAM ------");
            System.out.println("1. Them san pham");
            System.out.println("2. Xem danh sach");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                    case 1:
                        System.out.println("1. Physical");
                        System.out.println("2. Digital");
                        int type = Integer.parseInt(sc.nextLine());
                        Product p = ProductFactory.createProduct(type, sc);
                        db.addProduct(p);
                        break;
                    case 2:
                        db.display();
                        break;
                    case 3:
                        System.out.print("Nhap id can sua: ");
                        String idUpdate = sc.nextLine();
                        db.updateProduct(idUpdate, sc);
                        break;

                    case 4:
                        System.out.print("Nhap id can xoa: ");
                        String idDelete = sc.nextLine();
                        db.deleteProduct(idDelete);
                        break;

                    case 5:
                        System.out.println("Thoat chuong trinh");
                        return;
                    default:
                        System.out.println("Lua chon khong hop le.");
            }
        }while (true);
    }
}

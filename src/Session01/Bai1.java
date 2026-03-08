package Session01;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Nhap nam sinh:");
            String input = scanner.nextLine();
            int year = Integer.parseInt(input);
            System.out.println("Tuoi cua ban la: " + (2026 - year));
        } catch (NumberFormatException e) {
            System.err.println("Loi: vui long nhap nam sinh bang so");
        } finally {
            scanner.close();
            System.out.println("Thuc hien don dep tai nguyen trong finally...");
        }
    }
}

package Session11.Btth.utils;

public class Main {
    public static void main(String[] args) {
        System.out.println("Chuẩn bị kết nối");
        DatabaseConnection.openConnection();
        System.out.println("Đã kết nối thành công");
    }
}

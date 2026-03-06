import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class DemoException {
    public static void main(String[] args) {
        // Exception
        // Checked Exception:
//        File file = new File("D://Learning//test.txt");
//        try {
//            FileReader fileReader = new FileReader(file);
//            fileReader.read();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
        Scanner scanner = new Scanner(System.in);
        do{
            try{
                System.out.println("Nhập vào số:");
                int number = scanner.nextInt();
                System.out.println(number);
                return;
            }catch (Exception e){
                System.err.println("Nhập lại");
            }
        }while(true);

    }
}

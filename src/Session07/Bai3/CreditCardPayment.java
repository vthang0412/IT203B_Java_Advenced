package Session07.Bai3;

// Lớp xử lý thanh toán thẻ tín dụng
public class CreditCardPayment implements CardPayable {

    @Override
    public void processCreditCard(double amount) {

        System.out.println("Xử lý thanh toán thẻ tín dụng: " + amount + " - Thành công");

    }
}

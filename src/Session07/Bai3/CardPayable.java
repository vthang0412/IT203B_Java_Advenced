package Session07.Bai3;

// Interface thanh toán thẻ tín dụng
public interface CardPayable extends PaymentMethod {

    void processCreditCard(double amount);

}

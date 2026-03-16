package Session07;

public class CreditCard implements PaymentMethod {
    public void pay(double amount){
        System.out.println("Thanh toán bằng Credit Card: " + amount);
    }
}

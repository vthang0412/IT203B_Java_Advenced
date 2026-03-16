package Session07;

public class Paypal implements PaymentMethod {
    public void pay(double amount){
        System.out.println("Thanh toán bằng PayPal: " + amount);
    }
}

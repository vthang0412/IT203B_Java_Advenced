package Session07.Bai3;

// Interface cho ví điện tử
public interface EWalletPayable extends PaymentMethod {

    void processEWallet(double amount);

}

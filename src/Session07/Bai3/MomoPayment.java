package Session07.Bai3;

// Lớp xử lý thanh toán ví MoMo
public class MomoPayment implements EWalletPayable {

    @Override
    public void processEWallet(double amount) {

        System.out.println("Xử lý thanh toán MoMo: " + amount + " - Thành công");

    }
}

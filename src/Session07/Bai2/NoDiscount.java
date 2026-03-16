package Session07.Bai2;

// Không áp dụng giảm giá
public class NoDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double totalAmount) {

        return totalAmount;
    }
}
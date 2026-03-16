package Session07.Bai2;

// Giảm giá ngày lễ 15%
public class HolidayDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double totalAmount) {

        return totalAmount * 0.85;
    }
}
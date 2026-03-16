package Session07.Bai2;

// Lớp tính toán đơn hàng
public class OrderCalculator {

    private DiscountStrategy discountStrategy;

    public OrderCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateTotal(double totalAmount) {

        // áp dụng giảm giá
        return discountStrategy.applyDiscount(totalAmount);
    }
}

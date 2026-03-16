package Session07.Bai2;

// Interface định nghĩa cách áp dụng giảm giá
public interface DiscountStrategy {

    // nhận tổng tiền và trả về số tiền sau giảm
    double applyDiscount(double totalAmount);
}
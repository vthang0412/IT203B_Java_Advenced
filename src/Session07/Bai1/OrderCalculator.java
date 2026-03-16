package Session07.Bai1;

// Lớp tính tổng tiền đơn hàng
public class OrderCalculator {

    public double calculateTotal(Order order) {

        double total = 0;

        for (OrderItem item : order.getItems()) {
            total += item.getSubtotal();
        }

        order.setTotal(total);

        return total;
    }
}
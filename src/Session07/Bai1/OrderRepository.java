package Session07.Bai1;

// Lớp lưu đơn hàng
public class OrderRepository {

    public void save(Order order) {

        System.out.println("Đã lưu đơn hàng " + order.getOrderId());
    }
}

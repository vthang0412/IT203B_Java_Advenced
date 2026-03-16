package Session07.Bai4;

// Interface định nghĩa cách lưu trữ đơn hàng
public interface OrderRepository {

    void save(Order order);

    void findAll();
}
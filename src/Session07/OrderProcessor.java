package Session07;;

public class OrderProcessor {

    private Database db;
    private PaymentMethod paymentMethod;
    private Notification notification;

    public OrderProcessor(Database db, PaymentMethod paymentMethod, Notification notification) {
        this.db = db;
        this.paymentMethod = paymentMethod;
        this.notification = notification;
    }

    public void processOrder(Order order) {

        db.save(order);

        paymentMethod.pay(order.getAmount());

        notification.send("Đơn hàng đã xử lý thành công");
    }
}


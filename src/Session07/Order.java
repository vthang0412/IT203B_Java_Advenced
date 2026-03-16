package Session07;

public class Order {

    private int id;
    private String customerEmail;
    private double amount;

    public Order(int id, String customerEmail, double amount) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public double getAmount() {
        return amount;
    }
}

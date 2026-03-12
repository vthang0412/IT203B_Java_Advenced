package Session05.model;

public class Drink extends MenuItem {
    private String size; // S, M, L

    public Drink(String id, String name, double basePrice, String size) {
        super(id, name, basePrice);
        this.size = size.toUpperCase();
    }

    @Override
    public double calculatePrice() {
        // Logic đa hình: Giá thay đổi dựa trên Size
        switch (size) {
            case "M":
                return getBasePrice() + 5.0; // Size M cộng thêm 5 đơn vị tiền
            case "L":
                return getBasePrice() + 10.0; // Size L cộng thêm 10 đơn vị tiền
            default:
                return getBasePrice(); // Size S hoặc mặc định
        }
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Size: %s", size);
    }
}
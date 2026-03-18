package Session09.Btth;

public class PhysicalProduct extends Product {
    double weight;
    public PhysicalProduct(String id,String name,double price, double weight) {
        super(id,name,price);
        this.weight = weight;
    }
    void displayInfo(){
        System.out.println("Physical | ID: " + id + " | Name: " + name + " | Price: " + price + " | Weight: " + weight);
    }
}

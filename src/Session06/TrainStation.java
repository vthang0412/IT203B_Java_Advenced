package Session06;

public class TrainStation {
    private int quantity;

    public TrainStation(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public synchronized boolean sellTicket(String boxOffice){
        if(quantity > 0){
            System.out.println("Số lượng vé trong kho = " + quantity);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.err.println(e.getMessage());
            }
            quantity--;
            System.out.println("✔ " + boxOffice + " đã bán 1 vé. Số vé còn lại: " + quantity);
            return true;
        }else{
            System.out.println("❌ " + boxOffice + " thông báo: Đã hết vé!");
            return false;
        }
    }
}
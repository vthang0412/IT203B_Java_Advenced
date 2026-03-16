package Session07;

public class SMSSender implements Notification {
    public void send(String message){
        System.out.println("Gửi SMS: " + message);
    }
}
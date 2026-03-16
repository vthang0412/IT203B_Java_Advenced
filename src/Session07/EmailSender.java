package Session07;

public class EmailSender implements Notification {
    public void send(String message){
        System.out.println("Gửi Email: " + message);
    }
}

package Session07.Bai4;

// Implementation gửi thông báo qua Email
public class EmailService implements NotificationService {

    @Override
    public void send(String message, String recipient) {

        System.out.println("Gửi email: " + message);

    }
}
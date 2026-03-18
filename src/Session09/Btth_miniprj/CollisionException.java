package Session09.Btth_miniprj;

// Exception khi có va chạm (trường hợp lock fail)
public class CollisionException extends Exception {

    public CollisionException(String message) {
        super(message);
    }
}
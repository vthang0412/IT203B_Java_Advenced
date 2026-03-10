package Session03;

import java.util.Arrays;
import java.util.List;

public class Bai1 {
    public record User (String userName, String email, String status){}
    public static void main(String[] args) {
        List<User> user = Arrays.asList( new User("alice", "","Active"),
                new User("bob", "","Inactive"),
                new User("charlie", "","Active"));
        user.forEach(System.out::println);

    }
}

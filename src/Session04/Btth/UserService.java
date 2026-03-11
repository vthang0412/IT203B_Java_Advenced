package Session04.Btth;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> users = new ArrayList<>();

    public void addUser(User user){
        if(user.getUsername().isBlank()){
            throw new IllegalArgumentException("Username cannot be empty");
        }
        users.add(user);
    }

    public User findUserById(int id){
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean isvalidEmail(String email){
        String regexEmail = "[a-zA-Z0-9]+[a-zA-Z]+\\.[a-zA-Z]{2,4}";
        return email.matches(regexEmail);
    }
}

package Session03.Btth;

import java.util.List;
import java.util.stream.Collectors;

public class UserService{

    public List<User> getVerifiedUsers(List<User> users){
        return users.stream()
                .filter(User::isVerified)
                .collect(Collectors.toList());
    }

    public Tier classifyTier(long months){
        return switch((int)months){
            case 25,26,27,28,29,30,31,32,33,34,35,36 -> new Gold();
            default -> switch((int)months){
                case 13,14,15,16,17,18,19,20,21,22,23,24 -> new Silver();
                default -> new Bronze();
            };
        };
    }
}

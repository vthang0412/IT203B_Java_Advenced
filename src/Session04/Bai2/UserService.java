package Session04.Bai2;

public class UserService {
    public static boolean checkRegistrationAge(int age){
        if(age < 0){
            throw new IllegalArgumentException("Tuổi không được âm");
        } else if (age < 18) {
            return false;
        }
        return true;
    }
}

package Session02.Bai3;

@FunctionalInterface
interface Authenticatable{

    String getPassword();

    default boolean isAuthenticated(){
        return getPassword()!=null && !getPassword().isEmpty();
    }

    static String encrypt(String rawPassword){
        return "ENC_"+rawPassword;
    }
}

class User implements Authenticatable{

    String password;

    User(String password){
        this.password=password;
    }

    public String getPassword(){
        return password;
    }
}

public class Bai3{
    public static void main(String[] args){

        User u=new User(Authenticatable.encrypt("123456"));

        System.out.println(u.isAuthenticated());

        System.out.println(Authenticatable.encrypt("mypassword"));
    }
}

package Session02.Bai4;

import java.util.*;
import java.util.function.*;

class User{
    String username;

    User(){
        this.username="default";
    }

    User(String username){
        this.username=username;
    }

    public String getUsername(){
        return username;
    }
}

public class Bai4{
    public static void main(String[] args){

        List<User> users=new ArrayList<>();
        users.add(new User("thang"));
        users.add(new User("dat"));
        users.add(new User("dai"));

        Function<User,String> f=User::getUsername;

        Consumer<String> c=System.out::println;

        Supplier<User> s=User::new;

        for(User u:users){
            c.accept(f.apply(u));
        }

        User newUser=s.get();
        c.accept(newUser.getUsername());
    }
}

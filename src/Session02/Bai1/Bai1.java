package Session02.Bai1;

import java.util.function.*;

class User{
    String username;
    String role;

    User(String username,String role){
        this.username=username;
        this.role=role;
    }

    public String getUsername(){
        return username;
    }

    public String getRole(){
        return role;
    }

    public String toString(){
        return "username: "+username+" role: "+role;
    }
}

public class Bai1{
    public static void main(String[] args){

        User u1=new User("thang","admin");

        Predicate<User> isAdmin=u->u.getRole().equalsIgnoreCase("admin");

        Function<User,String> userToString=u->u.getUsername();

        Consumer<User> printUser=u->System.out.println(u);

        Supplier<User> createUser=()->new User("defaultUser","user");

        System.out.println(isAdmin.test(u1));

        System.out.println(userToString.apply(u1));

        printUser.accept(u1);

        User newUser=createUser.get();
        System.out.println(newUser);
    }
}
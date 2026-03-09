package Session02.Bai5;

interface UserActions{
    default void logActivity(String activity){
        System.out.println("user action: "+activity);
    }
}

interface AdminActions{
    default void logActivity(String activity){
        System.out.println("admin action: "+activity);
    }
}

class SuperAdmin implements UserActions,AdminActions{

    public void logActivity(String activity){
        UserActions.super.logActivity(activity);
        AdminActions.super.logActivity(activity);
    }
}

public class Bai5{
    public static void main(String[] args){

        SuperAdmin sa=new SuperAdmin();

        sa.logActivity("delete user");
    }
}

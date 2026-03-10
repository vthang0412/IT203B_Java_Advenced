package Session03.Btth;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args){

        List<User> users=List.of(
                new User("U1","a@gmail.com","123",true,LocalDate.of(2022,1,10)),
                new User("U2","b@gmail.com","123",false,LocalDate.of(2023,5,5)),
                new User("U3","c@gmail.com","123",true,LocalDate.of(2021,3,20)),
                new User("U4","d@gmail.com","123",true,LocalDate.of(2024,1,1)),
                new User("U5","e@gmail.com","123",false,LocalDate.of(2020,8,15))
        );

        UserService service=new UserService();

        List<User> verified=service.getVerifiedUsers(users);

        List<PublicUser> publicUsers=verified.stream()
                .map(u->{
                    long months=Period.between(u.getCreatedAt(),LocalDate.now()).toTotalMonths();
                    Tier tier=service.classifyTier(months);
                    return new PublicUser(u.getId(),u.getEmail(),tier);
                })
                .collect(Collectors.toList());

        System.out.println("""
                ==== BAO CAO USER ====
                """);

        publicUsers.forEach(u->System.out.println("""
                ID: %s
                Email: %s
                Tier: %s
                ---------------------
                """.formatted(u.id(),u.email(),u.tier())));
    }
}

package sem3_OOP.lesson3.Task4;

import java.util.Scanner;
import java.util.function.Supplier;

//Interface Supplier <T> {
//    T get();
//        }


public class Lambda6 {
    public static void main(String[] args) {
        Supplier<User> supplier = () -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            return new User(name);
        };
        User user1 = supplier.get();
        User user2 = supplier.get();

        System.out.println(user1.getName());
        System.out.println(user2.getName());
    }
}
class User {
    String name;

    User(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}

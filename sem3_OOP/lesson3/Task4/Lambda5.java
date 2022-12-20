package sem3_OOP.lesson3.Task4;

import java.util.function.Consumer;

//Interface Consumer<T> {
//    void accept(T t);
//  }

public class Lambda5 {
    public static void main(String[] args) {
        Consumer<Integer> consumer = x -> System.out.println("долларов " + x);
        consumer.accept(45);
    }
}
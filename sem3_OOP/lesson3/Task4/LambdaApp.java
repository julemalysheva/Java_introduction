package sem3_OOP.lesson3.Task4;

import java.util.function.Predicate;
//Interface Predicate<T> {
//    boolean test(T t)
//        }

public class LambdaApp {
    public static void main(String[] args) {
        Predicate<Integer> predicate = (x) -> x > 0;
        System.out.println(predicate.test(5));
        System.out.println(predicate.test(-7));
    }
}

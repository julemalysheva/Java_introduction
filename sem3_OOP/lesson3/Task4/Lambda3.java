package sem3_OOP.lesson3.Task4;

import java.util.function.UnaryOperator;

//Interface UnaryOperator<T> {
//    T apply(T t);
//        }
public class Lambda3 {
    public static void main(String[] args) {
        UnaryOperator<Integer> unaryOperator = (z) -> z * z;
        System.out.println(unaryOperator.apply(4));
    }
}

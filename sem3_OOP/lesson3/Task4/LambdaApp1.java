package oop.lesson3.Task4;

import java.util.function.BinaryOperator;

//Interface BinaryOperator<T> {
//    T apply(T t, T t1);
//        }
public class LambdaApp1 {
    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;
        System.out.println(binaryOperator.apply(3, 5));
    }
}

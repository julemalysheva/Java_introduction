package oop.lesson3.Task4;

import java.util.function.Function;

//Interface Function<T,V> {
//    V apply(T t);
//        }
public class Lambda4 {
    public static void main(String[] args) {
        Function<Integer, String> function = (x) -> String.valueOf(x) + " доллары";
        System.out.println(function.apply(100));
    }
}

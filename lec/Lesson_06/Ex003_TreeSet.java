package lec.Lesson_06;

import java.util.Arrays;
import java.util.TreeSet;

public class Ex003_TreeSet {
    public static void main(String[] args) {
        var a = new TreeSet<>(Arrays.asList(1,7,2,3,6,4,5));
        var b = new TreeSet<>(Arrays.asList(13,3,17,7,2,11,5));

        System.out.println(a); // [1, 2, 3, 4, 5, 6, 7]
        System.out.println(b); // [2, 3, 5, 7, 11, 13, 17]
        System.out.println(a.headSet(4)); // [1, 2, 3] перед указанным
        System.out.println(a.tailSet(4)); // [4, 5, 6, 7] после, включая указанный
        System.out.println(a.subSet(3, 5)); // [3, 4] от нижнего включая до верхнего, не включая
        System.out.println(a.first()); //1
        System.out.println(b.last()); //17
        System.out.println(b.higher(10));//11 эл-т следующий больше чем указанный
        System.out.println(a.lower(5));//4 след.меньший, чем указанный
        //удалить первый/последнй
        System.out.println("1: " + a.pollFirst()+ " end: " + b.pollLast());

    }

}

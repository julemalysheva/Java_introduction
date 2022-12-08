package lec.Lesson_06;

import java.util.Arrays;
import java.util.HashSet;

public class Ex002_MathSet {
    public static void main(String[] args) {
        var a = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
        var b = new HashSet<>(Arrays.asList(2,3,5,7,11,13,17));
        var u = new HashSet<Integer>(a); u.addAll(b); //меняет тот, откуда вызывается
        var r = new HashSet<Integer>(a); r.retainAll(b);
        var s = new HashSet<Integer>(a); s.removeAll(b);
        System.out.println(a); // [1, 2, 3, 4, 5, 6, 7]
        System.out.println(b); // [17, 2, 3, 5, 7, 11]
        System.out.println(u); // [1, 17, 2, 3, 4, 5, 6, 7, 11, 13] после объединение - уникальные из каждого
        System.out.println(r); // [2, 3, 5, 7] после пересечения - встречаются в том и другом
        System.out.println(s); // [1, 4, 6] после разности - те что есть в a, но нет в b
        boolean res = a.addAll(b);//метод объединяет и возвращает bool, получилось ли это сделать
        System.out.println(res);

    }

}

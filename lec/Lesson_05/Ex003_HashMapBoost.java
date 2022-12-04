package lec.Lesson_05;

import java.util.*;

public class Ex003_HashMapBoost {
    public static void main(String[] args) {
        //конструктор без явного указания - будет по умолчанию
        Map<Integer,String> map1 = new HashMap<>();
        //можно явно указать, если примерно знаем и на каждом этапе будет увеличиваться в несколько раз
        Map<Integer,String> map2 = new HashMap<>(30);
        //здесь второе значение процент, от которого будет удвоение элементов
        //т.е. при 80% заполнении количество эл-тов в памяти будет увеличено
        Map<Integer,String> map3 = new HashMap<>(30, 0.8f);
    }
}
package lec.Lesson_05;

import java.util.*;
//работа с парами
public class Ex002_HashMapEntry {
    public static void main(String[] args) {
        Map<Integer, String> db = new HashMap<>();
        db.putIfAbsent(1, "один");
        db.put(2, "два");
        db.put(3, "три");
        System.out.println(db); 
//через entrySet определяем итератор для hashMap и внутри вызываем ключ и значение
        for (var item : db.entrySet()) {
            System.out.printf("[%d: %s]\n", item.getKey(), item.getValue());
        }
    }
}
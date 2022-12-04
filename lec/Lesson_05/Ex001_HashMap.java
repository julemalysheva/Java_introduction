package lec.Lesson_05;

import java.util.*;
 
public class Ex001_HashMap {
    public static void main(String[] args) {
        //пишем интерфейс Map, далее закрываем в обобщение типы ключ/значения
        Map<Integer, String> db = new HashMap<>();
        //в некоторых случаях при создании своей иерархии типов правильнее указать
        // в правой части конструктора также тип данных

        db.putIfAbsent(1, "один"); //добавляет с проверкой, если нет такого
        db.put(2, "два"); //добавляем ключ/значение - если нет - перезатрет новое значение
        db.put(null, "!null"); //может использоваться null
        System.out.println(db); // {null=!null, 1=один, 2=два}
        System.out.println(db.get(44)); //получаем по ключу
        //db.remove(null); 
        System.out.println(db); // {1=один, 2=два}
        //проверка содержания ключа или значения
        System.out.println(db.containsValue("один")); // true
        System.out.println(db.containsValue(1)); // false
        System.out.println(db.containsKey("один")); // false
        System.out.println(db.containsKey(1)); // true
        //получить все ключи и значения
        System.out.println(db.keySet());
        System.out.println(db.values());

    }
}
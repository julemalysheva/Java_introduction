package lec.Lesson_05;

import java.util.*;

public class Ex006_HashTable {
    public static void main(String[] args) {
        //устаревшая версия,в своих проектах можно не использовать
        //но может где-то встретиться
        Map<Integer,String> table = new Hashtable<>();
        table.put(1, "два");
        table.put(11, "один один");
        table.put(2, "один");
        System.out.println(table); // {2=один, 1=два, 11=один один}
        // table.put(null, "один"); //  java.lang.NullPointerException
        //не позволяет хранить null
        //методы такие-же как в любой коллекции
    }
}

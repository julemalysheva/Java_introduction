package lec.Lesson_05;

import java.util.*;

public class Ex004_TreeMap {
    public static void main(String[] args) {
        //в процессе добавления пары будут упорядочены по ключу
        //при работе со ссылочными типами/классами - обязательно
        //определять логику упорядочивания, каким образом сравнивать
        //и что значит равны и пр.(метод equals кокое ему здесь место?)
        TreeMap<Integer,String> tMap = new TreeMap<>();
        tMap.put(1,"один"); System.out.println(tMap); 
        // {1=один}
        tMap.put(6,"шесть"); System.out.println(tMap);
        // {1=один, 6=шесть}
        tMap.put(4,"четыре"); System.out.println(tMap);
        // {1=один, 4=четыре, 6=шесть}
        tMap.put(3,"три"); System.out.println(tMap);
        // {1=один, 3=три, 4=четыре, 6=шесть}
        tMap.put(2,"два"); System.out.println(tMap);
        // {1=один, 2=два, 3=три, 4=четыре, 6=шесть}
    }
}

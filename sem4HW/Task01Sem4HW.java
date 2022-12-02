package sem4HW;
/*Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.*/

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Task01Sem4HW {
    public static void main(String[] args) {
        LinkedList<Integer> intList = new LinkedList<>();
        intList.add(1); intList.add(5); intList.add(85); intList.add(4);
        intList.add(458); intList.add(47); intList.add(15); intList.add(203);
        System.out.println("Задан список: " + intList);
        intList = invertedList(intList);
        System.out.println("\"перевернутый” список: " + intList);
        System.out.println("\"перевернутый” 2вариант: ");
        reverseList(intList);
        System.out.println(intList);
        System.out.println("\"перевернутый” 3вариант: ");
        listReverse(intList);
        System.out.println(intList);

    }

    static LinkedList<Integer> invertedList(LinkedList<Integer> list){
        LinkedList<Integer> newList = new LinkedList<>();
        //забираем с конца списка, добавляя в начало нового
        while (!list.isEmpty()){
            newList.add(list.removeLast());
        }
        return newList;
    }

    static void reverseList(LinkedList<Integer> list){
        for (int i = 0, j=list.size()-1; i < list.size()/2; i++, j--) {
//            System.out.println("Меняем " + i + "на" + j);
            Integer temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    static void  listReverse(List<Integer> list){
        ListIterator<Integer> fl = list.listIterator();
        ListIterator<Integer> pl = list.listIterator(list.size());
        for (int i=0; i<list.size()/2; i++) {
            Integer temp = fl.next();
            fl.set(pl.previous());
            pl.set(temp);
        }
    }

}

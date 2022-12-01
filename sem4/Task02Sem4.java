package sem4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/*Реализовать консольное приложение, которое:
Принимает от пользователя и “запоминает” строки.
Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
Если введено revert, удаляет предыдущую введенную строку из памяти.
*/
public class Task02Sem4 {
    public static void main(String[] args) {
        boolean chInput = false;
        LinkedList<String> stringLinkedList = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (!chInput){
            System.out.println("Введите строку: ");
            String str = sc.nextLine();
            if(str.equals("print")){
                printDescending(stringLinkedList);
                chInput = true;
            } else if (str.equals("revert")) {
                String el = stringLinkedList.removeLast();
                System.out.println("Удалена строка: "+ el);
                System.out.println("Список после удаления: "+ stringLinkedList);
                chInput = true;
            }
            else stringLinkedList.add(str);
        }
        sc.close();
    }

    static void printDescending(LinkedList<String> stringLinkedList){
        Iterator<String> strIterator = stringLinkedList.descendingIterator();
        while (strIterator.hasNext()) {
            String str = strIterator.next();
            System.out.println(str);
        }
    }


}

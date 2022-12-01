package sem4;

import java.util.*;

/*
1) Написать метод, который принимает массив элементов,
помещает их в стэк и выводит на консоль содержимое стэка.
2) Написать метод, который принимает массив элементов,
помещает их в очередь и выводит на консоль содержимое очереди.

*/
public class Task03Sem4 {
    public static void main(String[] args) {
        ArrayList<Integer> arrInt = new ArrayList<>(List.of(1,5,85,4,458,47));
        System.out.println("Задан массив: "+ arrInt);
        System.out.println("Stack:");
        arrPrintToStack(arrInt);
        System.out.println("Queue:");
        arrPrintToQueue(arrInt);
    }

    static void arrPrintToStack(ArrayList<Integer> arrInt){
        Stack<Integer> integerStack = new Stack<>();
        integerStack.addAll(arrInt);
//        for (Integer el: arrInt) {
//            integerStack.push(el);
//        }
        while (!integerStack.isEmpty()){
            System.out.println(integerStack.pop());
        }
    }

    static void arrPrintToQueue(ArrayList<Integer> arrInt){
        Queue<Integer> integerQueue = new LinkedList<>(arrInt);
        while (!integerQueue.isEmpty()){
            System.out.println(integerQueue.remove());
        }
    }

}

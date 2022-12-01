package lec.myTestCollection;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        /*Создание приоритетной очереди
Давайте создадим Приоритетную очередь целых чисел и добавим в нее несколько целых чисел.
 После добавления целых чисел мы будем удалять их одно за другим из очереди приоритетов
 и смотреть, как сначала удаляется наименьшее целое число, затем следующее наименьшее целое число и так далее.*/

        // Create a Priority Queue
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        // Add items to a Priority Queue (ENQUEUE)
        numbers.add(750);
        numbers.add(500);
        numbers.add(900);
        numbers.add(100);

        // Remove items from the Priority Queue (DEQUEUE)
        while (!numbers.isEmpty()) {
            System.out.println(numbers.remove());
        }
        //Давайте посмотрим на тот же пример с приоритетной очередью элементов String.
        // Create a Priority Queue
        PriorityQueue<String> namePriorityQueue = new PriorityQueue<>();

        // Add items to a Priority Queue (ENQUEUE)
        namePriorityQueue.add("Lisa");
        namePriorityQueue.add("Robert");
        namePriorityQueue.add("John");
        namePriorityQueue.add("Chris");
        namePriorityQueue.add("Angelina");
        namePriorityQueue.add("Joe");

        // Remove items from the Priority Queue (DEQUEUE)
        while (!namePriorityQueue.isEmpty()) {
            System.out.println(namePriorityQueue.remove());
        }
        /*# Output
Angelina
Chris
Joe
John
Lisa
Robert
В этом случае наименьшая строка в соответствии с естественным порядком строк удаляется первой.*/



    }
}

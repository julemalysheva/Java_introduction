package lec.myTestCollection;
/*Очередь — это структура данных «первым пришел — первым обслужен» (FIFO).
* https://www.callicoder.com/java-queue/
*
* */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class JavaQueueTest {
    public static void main(String[] args) {
/*Создание очереди и выполнение основных операций, таких как постановка в очередь и удаление из очереди*/
// Create and initialize a Queue using a LinkedList
        Queue<String> waitingQueue = new LinkedList<>();

        // Adding new elements to the Queue (The Enqueue operation)
        waitingQueue.add("Rajeev");
        waitingQueue.add("Chris");
        waitingQueue.add("John");
        waitingQueue.add("Mark");
        waitingQueue.add("Steven");

        System.out.println("WaitingQueue : " + waitingQueue);

        // Removing an element from the Queue using remove() (The Dequeue operation)
        // The remove() method throws NoSuchElementException if the Queue is empty
        String name = waitingQueue.remove();
        System.out.println("Removed from WaitingQueue : " + name + " | New WaitingQueue : " + waitingQueue);

        // Removing an element from the Queue using poll()
        // The poll() method is similar to remove() except that it returns null if the Queue is empty.
        name = waitingQueue.poll();
        System.out.println("Removed from WaitingQueue : " + name + " | New WaitingQueue : " + waitingQueue);

        /*Загляните внутрь очереди
Проверьте, пуста ли очередь.
Найдите размер очереди.
Поиск элемента в очереди.
Получите элемент в начале очереди, не удаляя его.*/
        Queue<String> waitingQueue2 = new LinkedList<>();

        waitingQueue2.add("Jennifer");
        waitingQueue2.add("Angelina");
        waitingQueue2.add("Johnny");
        waitingQueue2.add("Sachin");

        System.out.println("WaitingQueue : " + waitingQueue2);

        // Check if a Queue is empty
        System.out.println("is waitingQueue empty? : " + waitingQueue2.isEmpty());

        // Find the size of the Queue
        System.out.println("Size of waitingQueue : " + waitingQueue2.size());

        // Check if the Queue contains an element
        String name2 = "Johnny";
        if(waitingQueue2.contains(name2)) {
            System.out.println("WaitingQueue contains " + name2);
        } else {
            System.out.println("Waiting Queue doesn't contain " + name2);
        }

        // Get the element at the front of the Queue without removing it using element()
        // The element() method throws NoSuchElementException if the Queue is empty
        String firstPersonInTheWaitingQueue =  waitingQueue2.element();
        System.out.println("First Person in the Waiting Queue (element()) : " + firstPersonInTheWaitingQueue);

        // Get the element at the front of the Queue without removing it using peek()
        // The peek() method is similar to element() except that it returns null if the Queue is empty
        firstPersonInTheWaitingQueue = waitingQueue2.peek();
        System.out.println("First Person in the Waiting Queue : " + firstPersonInTheWaitingQueue);

        /*Итерация по очереди в Java
Пример в этом разделе показывает различные способы перебора очереди:

Итерация по очереди с использованием метода Java 8 forEach().
Перебрать очередь с помощью iterator().
Перебор очереди с использованием iterator() и метода Java 8 forEachRemaining().
Итерация по очереди с использованием простого цикла for-each.
Порядок итерации в очереди такой же, как порядок вставки.*/
        Queue<String> waitingQueue3 = new LinkedList<>();

        waitingQueue3.add("John");
        waitingQueue3.add("Brad");
        waitingQueue3.add("Angelina");
        waitingQueue3.add("Julia");

        System.out.println("=== Iterating over a Queue using Java 8 forEach() ===");
        waitingQueue3.forEach(name3 -> {
            System.out.println(name3);
        });

        System.out.println("\n=== Iterating over a Queue using iterator() ===");
        Iterator<String> waitingQueueIterator = waitingQueue3.iterator();
        while (waitingQueueIterator.hasNext()) {
            String name3 = waitingQueueIterator.next();
            System.out.println(name3);
        }

        System.out.println("\n=== Iterating over a Queue using iterator() and Java 8 forEachRemaining() ===");
        waitingQueueIterator = waitingQueue3.iterator();
        waitingQueueIterator.forEachRemaining(name3 -> {
            System.out.println(name3);
        });

        System.out.println("\n=== Iterating over a Queue using simple for-each loop ===");
        for(String name3: waitingQueue3) {
            System.out.println(name3);
        }
    }
}

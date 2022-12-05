package sem4HW;
/*Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.*/

import java.util.LinkedList;
//делаю без явного указания типа данных
//может, я не так поняла задачу - кажется очевидным по поводу методов

public class Task02Sem4HW {
    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add("first"); linkedList.add("two"); linkedList.add("free");
        linkedList.add("four"); linkedList.add("five"); linkedList.add("six");

        System.out.println("Задан LinkedList: " + linkedList);
        //enqueue() - помещает элемент в конец очереди,
        enqueue(linkedList, "seven");
        System.out.println("Добавлен элемент: " + linkedList);
        enqueue(linkedList, "eight");
        System.out.println("Добавлен элемент: " + linkedList);
        //dequeue() - возвращает первый элемент из очереди и удаляет его,
        Object element = dequeue(linkedList);
        System.out.println("Удален из очереди: " + element);
        System.out.println("Очередь после изъятия: " + linkedList);
        //first() - возвращает первый элемент из очереди, не удаляя.
        element = first(linkedList);
        System.out.println("Первый в очереди: " + element);
        System.out.println("Очередь: " + linkedList);

    }

    static void enqueue(LinkedList<Object> list, Object o){
//        list.addLast(o);// по идее существует метод добавления в конец
        //либо так?
        list.add(list.size(),o);
    }

    static Object dequeue(LinkedList<Object> list){
        Object el;
        if (list.isEmpty()) el = null;
        else {
          // el = list.removeFirst(); //встроенный метод LinkedList возврата и удаления первого элемента
            el = list.remove(0);
        }
    return el;
    }

    static Object first(LinkedList<Object> list){
        Object el;
        if (list.isEmpty()) el = null;
        else {
//            el = list.getFirst(); //встроенный метод LinkedList возврата первого элемента
            el = list.get(0);
        }
        return el;
    }

}

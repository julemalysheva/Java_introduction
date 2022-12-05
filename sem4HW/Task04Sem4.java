package sem4HW;

import java.util.Arrays;

/*Задача с семинара
Реализовать стэк с помощью массива.
Нужно реализовать методы:
size(), empty(), push(), peek(), pop().
*/
public class Task04Sem4 {
//    так как метод pop() предполагает возврат удаленного элемента, не нашла др.варианта, как обяъвить массив
//    здесь для возможности его изменения. Таким образом, метод не принмиает аргументы.
//    В остальных методах не стала менять, массив передается в метод
    static Object[] objects = new Object[0];

    public static void main(String[] args) {
//        Object[] objects = new Object[0];
        System.out.println("Задан массив: " + Arrays.toString(objects));
        System.out.println("Size: " + size(objects));
        System.out.println("Empty? " + empty(objects));
        objects = push(objects, 4);
        objects = push(objects, "item");
        objects = push(objects, 50);
        objects = push(objects, "element");
        System.out.println("Добавлены элементы: " + Arrays.toString(objects));
        System.out.println("Empty? " + empty(objects));
        System.out.println("Верхний элемент: " + peek(objects));
        System.out.println("Изъят верхний элемент: " + pop());
        System.out.println("Массив после удаления: " + Arrays.toString(objects));
        System.out.println("Size: " + size(objects));

    }
    static int size(Object[] objects){
        //не совсем понятно, что нужно в этом методе, из очевидных
//        return objects.length;
        int size = 0;
        for (Object o: objects) {
            size++;
        }
        return size;
    }
    static boolean empty(Object[] objects){
        return size(objects) == 0;
    }

    static Object[] push(Object[] objects, Object o){
        int length = objects.length;
        Object[] temp = new Object[length+1];
        System.arraycopy(objects, 0, temp, 0, length);
        temp[length] = o;
        return temp;
    }

    static Object peek(Object[] objects){
        return objects[objects.length-1];
    }

    static Object pop(){
        Object popElement = objects[objects.length-1];
        int length = objects.length;
        Object[] temp = new Object[length-1];
        System.arraycopy(objects, 0, temp, 0, length-1);
        objects = temp;
        return popElement;
    }

}

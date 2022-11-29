package sem3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*Создать список типа ArrayList<String>.
Поместить в него как строки, так и целые числа. 
Пройти по списку, найти и удалить целые числа.
 */
public class Task03Sem3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("5");
        list.add("строка1");
        list.add(String.valueOf(8));
        list.add("строка");
        list.add("2");
        list.add("строка2");
        list.add(String.valueOf(10));
        System.out.println(list);

        Iterator<String> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            if (isInteger(item)) {
                listIterator.remove();
            }
        }
        System.out.println("Удаляем целые числа: " + list);

    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

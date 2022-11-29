package sem3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*Заполнить список десятью случайными числами. 
Отсортировать список методом sort() и вывести его на экран.

 */
public class Task01Sem3 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <10; i++) {
            list.add(random.ints(1,(100)).findFirst().getAsInt());
        }
System.out.println(list);
// list.sort(null);
Collections.sort(list);

System.out.println(list);

        
    }


}

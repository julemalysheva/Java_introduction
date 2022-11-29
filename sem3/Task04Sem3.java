/* Каталог товаров книжного магазина сохранен в виде двумерного списка 
List<ArrayList<String>> так, что на 0й позиции каждого внутреннего списка 
содержится название жанра, а на остальных позициях - названия книг. 
Напишите метод для заполнения данной структуры.
*/

/* Ссылки на материал по теме вложенных списков
https://stackoverflow.com/questions/10866205/two-dimensional-array-list
https://www.delftstack.com/ru/howto/java/nested-arraylists-java/
 * 
 */
package sem3;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Task04Sem3
 */
public class Task04Sem3 {

    public static void main(String[] args) {
       // List<String> listBook = new ArrayList<>();
       List<ArrayList<String>> listBook = new ArrayList<ArrayList<String>>();
       listBook.add(new ArrayList<>(List.of("проза", "Война и мир", "12 стульев", "Преступление и наказание")));
       listBook.add(new ArrayList<>(List.of("поэзия", "Бородино", "Парус", "Евгений Онегин")));
       listBook.add(new ArrayList<>(List.of("научная", "История человечества", "История времени", "Физика невозможного")));

       for(ArrayList obj: listBook){
        ArrayList<String> temp = obj; 
        for(String el : temp){
            System.out.print(el + " "); 
        }
        System.out.println(); 

        /*вывод
         * проза Война и мир 12 стульев Преступление и наказание
            поэзия Бородино Парус Евгений Онегин
            научная История человечества История времени Физика невозможного
         */
    }
    
    System.out.println(listBook); 


    }


}
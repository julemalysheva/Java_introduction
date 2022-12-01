package sem3;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями. 
Вывести название каждой планеты и количество его повторений в списке.
 */
public class Task02Sem3 {
    public static void main(String[] args) {
        List<String> listPlanet = new ArrayList<>();
        listPlanet.add("Земля");
        listPlanet.add("Марс");
        listPlanet.add("Венера");
        listPlanet.add("Меркурий");
        listPlanet.add("Нептун");
        listPlanet.add("Венера");
        listPlanet.add("Юпитер");
        listPlanet.add("Земля");
        listPlanet.add("Сатурн");
        listPlanet.add("Уран");
        listPlanet.add("Нептун");
        listPlanet.add("Земля");
        listPlanet.add("Юпитер");


        Map<String, Integer> strCount = new HashMap<>();
        // Integer count = 0;
        for (String string : listPlanet) {
            if (!strCount.containsKey(string)) {
                strCount.put(string, 1);
            } else {
                Integer count = strCount.get(string);
                count++;
                strCount.put(string, count);
            }
        }


        System.out.println(listPlanet);
        System.out.println(strCount);
        //удаление через итерацию по словарю
        delDuplicatesForMap(listPlanet, strCount);


        // Collections.sort(listPlanet);
        // System.out.println("Сортирован"+listPlanet);

        // removePlanet(listPlanet);

        //removeDuplicates(listPlanet);
        System.out.println("Удалены дубликаты"+listPlanet);

    }

    /*
     * Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.
     * Вариант Сергея Ильина
     */
    public static void removeDuplicates(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    j--;
                }
            }
        }

    }

    //вариант удаления после сортировки, если след.равен предыдущему, удаляем
    static void removePlanet(List<String> list){
        //удаление по индесам // Remove the element at index `5`
        //programmingLanguages.remove(5);
        for (int i = 0; i < list.size()-1; i++) {
            //т.к. массив отсортирован - можем проверять подряд
            if(list.get(i).equals(list.get(i+1))){
                list.remove(i);
                i--; //смещаем индекс после удаления
            }
        }
    }

    //также можно сделать удаление по числу значения в Мапе, если >1.в цикле по числу значения - 1 
    //удаляем элементы по ключу
    static void delDuplicatesForMap(List<String> list, Map<String, Integer> strCount){
        strCount.forEach((planet, count) -> {
            // System.out.println(planet + " => " + count);
            if (count>1){
                for (int i = 1; i < count; i++) {
                    list.remove(planet);
                }
            }
        });

    }

}

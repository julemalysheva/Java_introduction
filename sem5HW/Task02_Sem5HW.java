package sem5HW;
/*Пусть дан список сотрудников:
Иван Иванов Светлана Петрова Кристина Белова Анна Мусина Анна Крутова Иван Юрин Петр Лыков Павел Чернов
Петр Чернышов Мария Федорова Марина Светлова Мария Савина Мария Рыкова Марина Лугова Анна Владимирова
Иван Мечников Петр Петин Иван Ежов
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности.*/

import java.util.*;

public class Task02_Sem5HW {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(List.of(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"
                ));

        repeatingElements(arrayList);
    }

    static void repeatingElements(ArrayList<String> arr){
        HashMap<String, Integer> mapName = new HashMap<>();
        for (String el: arr) {
            String[] worker = el.split(" ");
            if (mapName.containsKey(worker[0])){
                int count = mapName.get(worker[0]);
                mapName.put(worker[0], ++count);
            } else {
                mapName.put(worker[0], 1);
            }
        }
        System.out.println(mapName);
//на данном этапе мне ближе такой вариант вывода, т.к. не до конца понимаю, как сортировать Map по значению
//как в инете entrySet().stream().sorted(Comparator. и т.д.- не разобралась
//делаю по-простому - нахожу макс.среди значений и в цикле иду вниз - вывожу в консоль
        //Collection<Integer> value = mapName.values();
        //System.out.println(value);
        Object[] valArray = mapName.values().toArray();
        int max = Integer.parseInt(String.valueOf(valArray[0]));
        for (int i = 1; i < valArray.length; i++) {
            if (Integer.parseInt(String.valueOf(valArray[i]))>max){
                max = Integer.parseInt(String.valueOf(valArray[i]));
            }
        }
        System.out.println("max = " + max);
        for (int i = max; i > 1 ; i--) {
            for (Map.Entry<String,Integer> entry: mapName.entrySet()) {
                if (entry.getValue() == i){
                    System.out.println(entry.getKey() + " - число повторов = " + entry.getValue());
                }
            }
        }
    }
}

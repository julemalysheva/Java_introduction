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
        //1й вариант с HashMap
        repeatingElements(arrayList);
        //пробую 2ой вариант через TreeMap
        System.out.println("\nВариант 2:");
        countRepeat(arrayList);
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
//на данном этапе мне ближе такой вариант вывода, т.к. не до конца понимаю, как сортировать Map по значению
//как в инете entrySet().stream().sorted(Comparator. и т.д.- не разобралась
//делаю по-простому - нахожу макс.среди значений и в цикле иду вниз - вывожу в консоль
        Object[] valArray = mapName.values().toArray();
        int max = Integer.parseInt(String.valueOf(valArray[0]));
        for (int i = 1; i < valArray.length; i++) {
            if (Integer.parseInt(String.valueOf(valArray[i]))>max){
                max = Integer.parseInt(String.valueOf(valArray[i]));
            }
        }
       //System.out.println("max = " + max);
        for (int i = max; i > 1 ; i--) {
            for (Map.Entry<String,Integer> entry: mapName.entrySet()) {
                if (entry.getValue() == i){
                    System.out.println(entry.getKey() + " - число повторов = " + entry.getValue());
                }
            }
        }
    }
//второй вариант, TreeMap, где ключом делаю число повторов, элелемнты - это списки строк,т.к. есть повторы имен
    //вывожу в обратном порядке по убыванию ключей
    static void countRepeat(ArrayList<String> array){
        TreeMap<Integer, ArrayList<String>> mapRepeat = new TreeMap<>();
        Collection<ArrayList<String>> values = mapRepeat.values();
        for (int i = 0; i < array.size(); i++) {
            String[] worker = array.get(i).split(" ");
            int count;
            if (!checkValue(worker[0], values)) {
                count = 1;
                for (int j = i + 1; j < array.size(); j++) {
                    if (array.get(j).split(" ")[0].equals(worker[0])) {
                        count++;
                    }
                }
                if (count > 1) {
                    ArrayList<String> temp;
                    if (mapRepeat.containsKey(count)) {
                        temp = mapRepeat.get(count);
                    } else {
                        temp = new ArrayList<>();
                    }
                    temp.add(worker[0]);
                    mapRepeat.put(count, temp);
                }
            }
        }

        System.out.println(mapRepeat.descendingMap()); //{4=[Иван], 3=[Анна, Петр, Мария], 2=[Марина]}
        for (Map.Entry<Integer, ArrayList<String>> entry: mapRepeat.descendingMap().entrySet()) {
            for (String str: entry.getValue()) {
                System.out.println(str + " число повторов = " + entry.getKey());
            }
        }
    }

    static boolean checkValue(String item, Collection<ArrayList<String>> val){
        for (ArrayList<String> arr: val) {
            for (String el: arr) {
                if (item.equals(el)) {
                    return true;
                }
            }
        }
        return false;
    }

}

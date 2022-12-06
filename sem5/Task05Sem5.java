package sem5;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*Взять набор строк, например,Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись.
Написать метод, который отсортирует эти строки по длине с помощью TreeMap. Строки с одинаковой длиной не должны “потеряться”.

*/
public class Task05Sem5 {
    public static void main(String[] args) {
        ArrayList<String> arrayString = new ArrayList<>(List.of("Мороз и солнце день чудесный","Пора красавица проснись.","Мороз и солнце день чудесный","Еще ты дремлешь друг прелестный","Пора красавица проснись."));
        sortTreeMap(arrayString);
    }

    static void sortTreeMap(ArrayList<String> arr){
        TreeMap<Integer, ArrayList<String>> treeMap = new TreeMap<>();
        for (String str: arr) {
            int length = str.length();
            ArrayList<String> tmp;
            if (treeMap.containsKey(length)){
                tmp = treeMap.get(length);
            } else {
                tmp = new ArrayList<>();
            }
            tmp.add(str);
            treeMap.put(length, tmp);
        }

        for (ArrayList<String> array: treeMap.values()) {
            for (String string: array) {
                System.out.println(string);
            }
        }
    }
}

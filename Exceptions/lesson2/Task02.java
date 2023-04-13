package Exceptions.lesson2;

/*Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если студенты с ним знакомы).
В отдельном методе нужно будет пройти по структуре данных, если сохранено значение ?, заменить его на соответствующее число.
Если на каком-то месте встречается символ, отличный от числа или ?, бросить подходящее исключение.
Записать в тот же файл данные с замененными символами ?.*/

//import org.json.simple.JSONArray;
//
//import org.json.simple.JSONObject;
//
//import org.json.simple.parser.*;
//import java.io.FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) throws FileNotFoundException {
        //реализация с Семинара. не обрабатывает исключения, если это не число и не ?
        try (FileReader reader = new FileReader("A:\\GB\\Java\\Java_introduction\\Exceptions\\lesson2\\names.txt");
             FileWriter writer = new FileWriter("A:\\GB\\Java\\Java_introduction\\Exceptions\\lesson2\\targetnames.txt");
             Scanner scan = new Scanner(reader);
             Scanner input = new Scanner(System.in)) {
            Map<String, Integer> name = new HashMap<>();//не использовали на семинаре
            while (scan.hasNext()){
                String s = scan.next();
                String number = null;
                if (s.equals("?")){
                    System.out.println("Введите число: ");
                    number = input.nextLine();
                    Integer.parseInt(Objects.requireNonNull(number));
                    writer.write(number + " ");
                    continue;
                }
                writer.write(s + " ");
            }

        } catch (IOException | NumberFormatException e){
            System.out.println(e.getMessage());
        }

             //добавить свою реализацию



//        Object o = new JSONParser().parse(new FileReader("names.json"));
//
//        JSONObject j = (JSONObject) o;
//        String name = (String) j.get("Name");
//        System.out.println(name);

//что-то пробовали
//        JSONObject j = new JSONObject();
//
//        j.put("Name", "Kotte");
//
//        j.put("College", "BVRIT");
//
//        j.put("Branch" , "Computer science engineering");
//
//        j.put("Section", "CSE-C");
//
//        System.out.println(j);


    }


}

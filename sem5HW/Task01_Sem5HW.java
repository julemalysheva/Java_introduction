package sem5HW;

import java.util.*;

/*Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
что 1 человек может иметь несколько телефонов.*/
public class Task01_Sem5HW {
    public static void main(String[] args) {
        //можно добавить описание к номеру, тогда значением будет HashMap, где ключ - описание, значение - номер
        HashMap<String, ArrayList<String>> mapPhone = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int input = 0; String name = null, phone; ArrayList<String> arrPhone = null;
        while (true) {
            System.out.println("""
                Введите:
                1 - добавить контакт
                2 - добавить ещё один телефон контакту
                3 - вывести справочник
                4 - показать телефоны контакта
                5 - завершить работу""");

            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
            } else System.out.println("Некорректный ввод");

            if (input == 1) {
                System.out.println("ФИО: ");
                if (scanner.hasNext()) {
                    name = scanner.next();
                    System.out.println("phone №: ");
                }
                if (scanner.hasNext()) {
                    phone = scanner.next();
                    arrPhone = new ArrayList<>(List.of(phone));
                    mapPhone.put(name, arrPhone);
                }
            } else if (input == 2) {
                System.out.println("Выберите/введите контакт, кому добавляем номер: \n" + mapPhone.keySet());
                if (scanner.hasNext()){
                name = scanner.next();
                arrPhone = mapPhone.get(name);}
                if (arrPhone != null) {
                    System.out.println("phone №: ");
                    if(scanner.hasNext()){
                    arrPhone.add(scanner.next());
                    mapPhone.put(name, arrPhone);}
                } else System.out.println("Контакт не найден");
            } else if (input == 3) {
                for (Map.Entry<String, ArrayList<String>> entry : mapPhone.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue());
                }
            } else if (input == 4) {
                System.out.println("Выберите/введите контакт для поиска: \n" + mapPhone.keySet());
                if (scanner.hasNext()) {
                name = scanner.next();
                arrPhone = mapPhone.get(name); }
                if (arrPhone != null) {
                    System.out.println(name + ": " + arrPhone);
                } else System.out.println("Контакт не найден");
            }  else if (input == 5) break;
            else {
                throw new IllegalStateException("Unexpected value: " + input);
            }
        }
        scanner.close();


    }
}

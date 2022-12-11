package Seminar6_final_HW;

import java.util.*;

public class Final_project_sem6HW {

    public static void main(String[] args) {
        Laptop lt1 = new Laptop("Acer Aspire 3 A315-23-R3LH",  15.6,
                "AMD Athlon Silver 3050U",2, 2.3, 4, 256,
                "DOS", false,"black", 12, 9,1.9, 29999);
        Laptop lt2 = new Laptop("Xiaomi RedmiBook 15",  15.6,
                "Intel Core i3 1115G4",2, 3, 8, 256,
                "Windows 11 Домашняя", false,"black", 12, 9,1.8,
                39999);
        Laptop lt3 = new Laptop("HP Victus 16-e0152ur",  16.1,
                "AMD Ryzen 5",6, 3.3, 16, 512,
                "DOS", true,"silver", 18, 8.5, 2.46, 84990);
        Laptop lt4 = new Laptop("Acer Aspire 3 A315-23-R3LH",  15.6,
                "AMD Athlon Silver 3050U",2, 2.3, 4, 256,
                "DOS", false,"black", 12, 9,1.9, 29999);
        Laptop lt5 = new Laptop("HAIER GG1502XD",  15.6,
                "Intel Core i5",6, 2.4, 16, 512,
                "DOS", true,"black", 18, 5,2.2, 79990);
        Laptop lt6 = new Laptop("Acer Aspire 3 A315-23-R3LH",  14.6,
                "AMD Athlon Silver 3050U",2, 2.0, 4, 128,
                "Windows", false,"black", 12, 6,1.9, 24999);


        //System.out.println(lt4.equals(lt1));//true
        HashSet<Laptop> laptopsSet = new HashSet<>(Arrays.asList(lt1 , lt2, lt3, lt4, lt5, lt6));
        System.out.println("Размер множества: " + laptopsSet.size());
        printSet(laptopsSet);
        try {
            HashSet<Laptop> filterSet = userFilter(laptopsSet);
            System.out.println("user filter:");
            printSet(filterSet);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    static HashSet<Laptop> userFilter(HashSet<Laptop> laptops){
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> userMapFilter = new HashMap<>();
        HashMap<Integer, String> viewFilter = new HashMap<>();
        viewFilter.put(1, "Модель - по вхождению строки");
        viewFilter.put(2, "Диагональ экрана - минимум");
        viewFilter.put(3, "Процессор тип - по вхождению строки");
        viewFilter.put(4, "Число ядер - минимум");
        viewFilter.put(5, "Частота процессора ГГц - минимум");
        viewFilter.put(6, "RAM - минимум");
        viewFilter.put(7, "SSD - минимум");
        viewFilter.put(8, "Операционная система - по вхождению строки");
        viewFilter.put(9, "Игровой? - Да/Нет");
        viewFilter.put(10, "Цвет - по вхождению строки");
        viewFilter.put(11, "Гарантия в месяцах - минимум");
        viewFilter.put(12, "Макс.часов автономной работы батареи - минимум");
        viewFilter.put(13, "Вес - минимум");
        viewFilter.put(14, "Цена - минимум");

        System.out.println("Введите число или числа через запятую, соответствующие критериям отбора.\nНапример, 5 или 1,3 и т.п. ");
        for (Map.Entry<Integer, String> el:viewFilter.entrySet()) {
            System.out.println(el.getKey() + " - " + el.getValue());
        }
        System.out.println("Ожидается ввод: ");
        if (scanner.hasNext()){
            String input = scanner.next();
            ArrayList<Integer> userChoice = new ArrayList<>();
            if (isDigit(input) && viewFilter.containsKey(Integer.parseInt(input))) userChoice.add(Integer.parseInt(input));
            else {
                for (String str: input.split(",")) {
                    if (viewFilter.containsKey(Integer.parseInt(str))){
                        userChoice.add(Integer.parseInt(str));
                    }
                }
            }
            //System.out.println(userChoice);
            if (!userChoice.isEmpty()){
                for (Integer item:userChoice) {
                    System.out.println("Введите значение отбора по - " + viewFilter.get(item));
                    if (scanner.hasNext()){
                        input = scanner.next();
                        userMapFilter.put(item, input);
                    }
                }
            } else System.out.println("Некорректный ввод");
        }
        scanner.close();
        System.out.println("Задан фильтр: " + userMapFilter);
        HashSet<Laptop> tmpLaptops = new HashSet<>(laptops);

        for (Map.Entry<Integer, String> entry:userMapFilter.entrySet()) {
//            System.out.println("смотрим " + entry.getKey() + " " + entry.getValue());
            tmpLaptops.removeIf(laptop -> !laptop.checkUsersFilter(entry.getKey(), entry.getValue()));
        }
        return tmpLaptops;
    }

    static void printSet(HashSet<Laptop> lap){
        for (Laptop laptop : lap) {
            if (laptop != null){
                System.out.println(laptop);
            }
        }
    }
    static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

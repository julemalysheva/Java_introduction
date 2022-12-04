package lec.myTestCollection;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        /*Создание древовидной карты
1. Простая древовидная карта
В этом примере показано, как создать простой TreeMap и добавить в него новые пары ключ-значение.
Записи в TreeMap будут отсортированы на основе естественного порядка ключей —*/
// Creating a TreeMap
        SortedMap<String, String> fileExtensions  = new TreeMap<>();

        // Adding new key-value pairs to a TreeMap
        fileExtensions.put("python", ".py");
        fileExtensions.put("c++", ".cpp");
        fileExtensions.put("kotlin", ".kt");
        fileExtensions.put("golang", ".go");
        fileExtensions.put("java", ".java");

        // Printing the TreeMap (Output will be sorted based on keys)
        System.out.println(fileExtensions);

        /*reeMap с пользовательским компаратором (в порядке убывания)
В этом примере показано, как создать TreeMap с пользовательским компаратором,
который упорядочивает записи TreeMap в порядке убывания ключей.*/
        // Creating a TreeMap with a Custom comparator (Descending order)
        SortedMap<String, String> fileExtensions2 = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });

        /*
            The above TreeMap with custom Comparator can be simply written as -
            SortedMap<String, String> fileExtensions = new TreeMap<>(Comparator.reverseOrder());
        */

        // Adding new key-value pairs to a TreeMap
        fileExtensions2.put("python", ".py");
        fileExtensions2.put("c++", ".cpp");
        fileExtensions2.put("kotlin", ".kt");
        fileExtensions2.put("golang", ".go");
        fileExtensions2.put("java", ".java");

        // Printing the TreeMap (The keys will be sorted based on the supplied comparator)
        System.out.println(fileExtensions2);

        /*Доступ к записям TreeMap
В следующем примере показано, как:

Найдите размер TreeMap.
Проверьте, существует ли данный ключ в TreeMap.
Получите первую запись в TreeMap.
Получить последнюю запись в TreeMap.
Получить запись, ключ которой чуть ниже заданного ключа.
Получить запись, ключ которой чуть выше заданного ключа.*/
        TreeMap<Integer, String> employees = new TreeMap<>();

        employees.put(1003, "Rajeev");
        employees.put(1001, "James");
        employees.put(1002, "Sachin");
        employees.put(1004, "Chris");

        System.out.println("Employees map : " + employees);

        // Finding the size of a TreeMap
        System.out.println("Total number of employees : " + employees.size());

        // Check if a given key exists in a TreeMap
        Integer id = 1004;
        if(employees.containsKey(id)) {
            // Get the value associated with a given key in a TreeMap
            String name = employees.get(id);
            System.out.println("Employee with id " + id + " : " + name);
        } else {
            System.out.println("Employee does not exist with id : " + id);
        }

        // Find the first and last entry
        System.out.println("First entry in employees map : " + employees.firstEntry());
        System.out.println("Last entry in employees map : " + employees.lastEntry());

        // Find the entry whose key is just less than the given key
        Map.Entry<Integer, String> employeeJustBelow = employees.lowerEntry(1002);
        System.out.println("Employee just below id 1002 : " + employeeJustBelow);

        // Find the entry whose key is just higher than the given key
        Map.Entry<Integer, String> employeeJustAbove = employees.higherEntry(1002);
        System.out.println("Employee just above id 1002 : " + employeeJustAbove);
/*Удаление записей из TreeMap
В приведенном ниже примере показано, как:

Удалить ключ из TreeMap.
Удаляйте ключ из TreeMap, только если он связан с заданным значением.
Удалите первую запись TreeMap.
Удалите последнюю запись TreeMap.*/

        TreeMap<String, String> countryISOCodeMapping = new TreeMap<>();

        countryISOCodeMapping.put("India", "IN");
        countryISOCodeMapping.put("United States of America", "US");
        countryISOCodeMapping.put("China", "CN");
        countryISOCodeMapping.put("United Kingdom", "UK");
        countryISOCodeMapping.put("Russia", "RU");
        countryISOCodeMapping.put("Japan", "JP");

        System.out.println("CountryISOCodeMapping : " + countryISOCodeMapping);

        // Remove the mapping for a given key
        String countryName = "Japan";
        String isoCode = countryISOCodeMapping.remove(countryName);
        if(isoCode != null) {
            System.out.println("Removed (" + countryName + " => " + isoCode + ") from the TreeMap. New TreeMap " + countryISOCodeMapping);
        } else {
            System.out.println(countryName + " does not exist, or it is mapped to a null value");
        }

        // Remove the mapping for the given key only if it is mapped to the given value
        countryName = "India";
        boolean isRemoved = countryISOCodeMapping.remove(countryName, "IA");
        System.out.println("Was the mapping removed for " + countryName + "? : " + isRemoved);

        // Remove the first entry from the TreeMap
        Map.Entry<String, String> firstEntry = countryISOCodeMapping.pollFirstEntry();
        System.out.println("Removed firstEntry : " + firstEntry + ", New TreeMap : " + countryISOCodeMapping);

        // Remove the last entry from the TreeMap
        Map.Entry<String, String> lastEntry = countryISOCodeMapping.pollLastEntry();
        System.out.println("Removed lastEntry : " + lastEntry + ", New TreeMap : " + countryISOCodeMapping);

    }
}

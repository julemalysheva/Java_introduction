package lec.myTestCollection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        /*Создание и инициализация LinkedHashMap
В следующем примере показано, как создать LinkedHashMap и добавить в него новые пары ключ-значение.*/
        // Creating a LinkedHashMap
        LinkedHashMap<String, Integer> wordNumberMapping = new LinkedHashMap<>();

        // Adding new key-value pairs to the LinkedHashMap
        wordNumberMapping.put("one", 1);
        wordNumberMapping.put("two", 2);
        wordNumberMapping.put("three", 3);
        wordNumberMapping.put("four", 4);

        // Add a new key-value pair only if the key does not exist in the LinkedHashMap, or is mapped to `null`
        wordNumberMapping.putIfAbsent("five", 5);

        System.out.println(wordNumberMapping);

        /*Доступ к записям LinkedHashMap
В этом примере показано, как

Проверьте, существует ли ключ в LinkedHashMap.
Проверьте, существует ли значение в LinkedHashMap.
Измените значение, связанное с данным ключом в LinkedHashMap.*/
        LinkedHashMap<Integer, String> customerIdNameMapping = new LinkedHashMap<>();

        customerIdNameMapping.put(1001, "Jack");
        customerIdNameMapping.put(1002, "David");
        customerIdNameMapping.put(1003, "Steve");
        customerIdNameMapping.put(1004, "Alice");
        customerIdNameMapping.put(1005, "Marie");

        System.out.println("customerIdNameMapping : " + customerIdNameMapping);

        // Check if a key exists in the LinkedHashMap
        Integer id = 1005;
        if(customerIdNameMapping.containsKey(id)) {
            System.out.println("Found the customer with id " + id + " : " + customerIdNameMapping.get(id));
        } else {
            System.out.println("Customer with id " + id + " does not exist");
        }

        // Check if a value exists in the LinkedHashMap
        String name = "David";
        if(customerIdNameMapping.containsValue(name)) {
            System.out.println("A customer named " + name + " exist in the map");
        } else {
            System.out.println("No customer found with name " + name + " in the map");
        }

        // Change the value associated with an existing key
        id = 1004;
        customerIdNameMapping.put(id, "Bob");
        System.out.println("Changed the name of customer with id " + id + ", New mapping : " + customerIdNameMapping);

        /*Удаление записей из LinkedHashMap
Пример ниже показывает, как

Удалить ключ из LinkedHashMap.
Удаляйте ключ из LinkedHashMap, только если он связан с данным значением.*/
        LinkedHashMap<String, String> husbandWifeMapping = new LinkedHashMap<>();

        husbandWifeMapping.put("Rajeev", "Jennifer");
        husbandWifeMapping.put("John", "Maria");
        husbandWifeMapping.put("Chris", "Lisa");
        husbandWifeMapping.put("Steve", "Susan");

        System.out.println("husbandWifeMapping : " + husbandWifeMapping);

        // Remove a key from the LinkedHashMap
        String wife = husbandWifeMapping.remove("John");
        System.out.println("Removed John and his wife " + wife + " from the mapping. New husbandWifeMapping : " + husbandWifeMapping);

        // Remove a key from the LinkedHashMap only if it is mapped to the given value
        boolean isRemoved = husbandWifeMapping.remove("John", "Susan");
        System.out.println("Did John get removed from the mapping? : " + isRemoved);

        /*Итерация по LinkedHashMap
Пример в этом разделе показывает различные способы перебора LinkedHashMap:

Перебор LinkedHashMap с использованием Java 8 forEach и лямбда-выражения.
Итерация по набору записей LinkedHashMap с использованием Java 8 forEach и лямбда-выражения.
Перебрать набор записей LinkedHashMap с помощью iterator().
Выполните итерацию по набору записей LinkedHashMap, используя iterator() и метод Java 8 forEachRemaining().*/

        LinkedHashMap<String, String> userCityMapping = new LinkedHashMap<>();

        userCityMapping.put("Rajeev", "Bengaluru");
        userCityMapping.put("Chris", "London");
        userCityMapping.put("David", "Paris");
        userCityMapping.put("Jesse", "California");

        System.out.println("=== Iterating over a LinkedHashMap using Java 8 forEach and lambda ===");
        userCityMapping.forEach((user, city) -> {
            System.out.println(user + " => " + city);
        });

        System.out.println("\n=== Iterating over the LinkedHashMap's entrySet using Java 8 forEach and lambda ===");
        userCityMapping.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        });

        System.out.println("\n=== Iterating over the entrySet of a LinkedHashMap using iterator() ===");
        Iterator<Map.Entry<String, String>> userCityMappingIterator = userCityMapping.entrySet().iterator();
        while (userCityMappingIterator.hasNext()) {
            Map.Entry<String, String> entry = userCityMappingIterator.next();
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("\n=== Iterating over the entrySet of a LinkedHashMap using iterator() and forEachRemaining ===");
        userCityMappingIterator = userCityMapping.entrySet().iterator();
        userCityMappingIterator.forEachRemaining(entry -> {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        });
    }
}

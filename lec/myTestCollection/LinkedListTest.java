package lec.myTestCollection;
/*https://www.callicoder.com/java-linkedlist/
Java LinkedList — это реализация двусвязного списка Java Listи Dequeинтерфейсов.
*/

import java.util.*;


public class LinkedListTest {
    public static void main(String[] args) {
/*В следующем примере показано, как создать LinkedList и добавить в него новые элементы.
Обратите внимание на использование addFirst()и addLast()методов в примере. Эти методы исходят из Dequeинтерфейса.*/
// Creating a LinkedList
        LinkedList<String> friends = new LinkedList<>();

        // Adding new elements to the end of the LinkedList using add() method.
        friends.add("Rajeev");
        friends.add("John");
        friends.add("David");
        friends.add("Chris");

        System.out.println("Initial LinkedList : " + friends);

        // Adding an element at the specified position in the LinkedList
        friends.add(3, "Lisa");
        System.out.println("After add(3, \"Lisa\") : " + friends);

        // Adding an element at the beginning of the LinkedList
        friends.addFirst("Steve");
        System.out.println("After addFirst(\"Steve\") : " + friends);

        // Adding an element at the end of the LinkedList (This method is equivalent to the add() method)
        friends.addLast("Jennifer");
        System.out.println("After addLast(\"Jennifer\") : " + friends);

        // Adding all the elements from an existing collection to the end of the LinkedList
        List<String> familyFriends = new ArrayList<>();
        familyFriends.add("Jesse");
        familyFriends.add("Walt");

        friends.addAll(familyFriends);
        System.out.println("After addAll(familyFriends) : " + friends);

        /*В следующем примере показано:
Как получить первый элемент в LinkedList.
Как получить последний элемент в LinkedList.
Как получить элемент по заданному индексу в LinkedList.*/
        // A LinkedList containing Stock Prices of a company for the last 6 days
        LinkedList<Double> stockPrices = new LinkedList<>();

        stockPrices.add(45.00);
        stockPrices.add(51.00);
        stockPrices.add(62.50);
        stockPrices.add(42.75);
        stockPrices.add(36.80);
        stockPrices.add(68.40);

        // Getting the first element in the LinkedList using getFirst()
        // The getFirst() method throws NoSuchElementException if the LinkedList is empty
        Double firstElement = stockPrices.getFirst();
        System.out.println("Initial Stock Price : " + firstElement);

        // Getting the last element in the LinkedList using getLast()
        // The getLast() method throws NoSuchElementException if the LinkedList is empty
        Double lastElement = stockPrices.getLast();
        System.out.println("Current Stock Price : " + lastElement);

        // Getting the element at a given position in the LinkedList
        Double stockPriceOn3rdDay = stockPrices.get(2);
        System.out.println("Stock Price on 3rd Day : " + stockPriceOn3rdDay);

        /*Пример ниже показывает:
Как удалить первый элемент в LinkedList.
Как удалить последний элемент в LinkedList.
Как удалить первое вхождение данного элемента в LinkedList.
Как удалить все элементы, удовлетворяющие заданному предикату, из LinkedList.
Как полностью очистить LinkedList.*/
        LinkedList<String> programmingLanguages = new LinkedList<>();

        programmingLanguages.add("Assembly");
        programmingLanguages.add("Fortran");
        programmingLanguages.add("Pascal");
        programmingLanguages.add("C");
        programmingLanguages.add("C++");
        programmingLanguages.add("Java");
        programmingLanguages.add("C#");
        programmingLanguages.add("Kotlin");

        System.out.println("Initial LinkedList = " + programmingLanguages);

        // Remove the first element in the LinkedList
        String element = programmingLanguages.removeFirst();  // Throws NoSuchElementException if the LinkedList is empty
        System.out.println("Removed the first element " + element + " => " + programmingLanguages);

        // Remove the last element in the LinkedList
        element = programmingLanguages.removeLast();   // Throws NoSuchElementException if the LinkedList is empty
        System.out.println("Removed the last element " + element + " => " + programmingLanguages);

        // Remove the first occurrence of the specified element from the LinkedList
        boolean isRemoved = programmingLanguages.remove("C#");
        if(isRemoved) {
            System.out.println("Removed C# => " + programmingLanguages);
        }

        // Remove all the elements that satisfy the given predicate
        programmingLanguages.removeIf(programmingLanguage -> programmingLanguage.startsWith("C"));
        System.out.println("Removed elements starting with C => " + programmingLanguages);

        // Clear the LinkedList by removing all elements
        programmingLanguages.clear();
        System.out.println("Cleared the LinkedList => " + programmingLanguages);

        /*Пример ниже показывает:
Как проверить, существует ли элемент в LinkedList.
Как найти индекс первого вхождения элемента в LinkedList.
Как найти индекс последнего вхождения элемента в LinkedList.*/
        LinkedList<String> employees = new LinkedList<>();

        employees.add("John");
        employees.add("David");
        employees.add("Lara");
        employees.add("Chris");
        employees.add("Steve");
        employees.add("David");

        // Check if the LinkedList contains an element
        System.out.println("Does Employees LinkedList contain \"Lara\"? : " + employees.contains("Lara"));

        // Find the index of the first occurrence of an element in the LinkedList
        System.out.println("indexOf \"Steve\" : " + employees.indexOf("Steve"));
        System.out.println("indexOf \"Mark\" : " + employees.indexOf("Mark"));

        // Find the index of the last occurrence of an element in the LinkedList
        System.out.println("lastIndexOf \"David\" : " + employees.lastIndexOf("David"));
        System.out.println("lastIndexOf \"Bob\" : " + employees.lastIndexOf("Bob"));

        /*В следующем примере показано, как выполнить итерацию по LinkedList, используя
Java 8 forEach()и лямбда-выражение.
итератор()
метод iterator() и Java 8 forEachRemaining()
нисходящий итератор()
списокитератор()
простой цикл for-each.*/
        LinkedList<String> humanSpecies = new LinkedList<>();

        humanSpecies.add("Homo Sapiens");
        humanSpecies.add("Homo Neanderthalensis");
        humanSpecies.add("Homo Erectus");
        humanSpecies.add("Home Habilis");

        System.out.println("=== Iterate over a LinkedList using Java 8 forEach and lambda ===");
        humanSpecies.forEach(name -> {
            System.out.println(name);
        });


        System.out.println("\n=== Iterate over a LinkedList using iterator() ===");
        Iterator<String> humanSpeciesIterator = humanSpecies.iterator();
        while (humanSpeciesIterator.hasNext()) {
            String speciesName = humanSpeciesIterator.next();
            System.out.println(speciesName);
        }

        System.out.println("\n=== Iterate over a LinkedList using iterator() and Java 8 forEachRemaining() method ===");
        humanSpeciesIterator = humanSpecies.iterator();
        humanSpeciesIterator.forEachRemaining(speciesName -> {
            System.out.println(speciesName);
        });

        System.out.println("\n=== Iterate over a LinkedList using descendingIterator() ===");
        Iterator<String> descendingHumanSpeciesIterator = humanSpecies.descendingIterator();
        while (descendingHumanSpeciesIterator.hasNext()) {
            String speciesName = descendingHumanSpeciesIterator.next();
            System.out.println(speciesName);
        }


        System.out.println("\n=== Iterate over a LinkedList using listIterator() ===");
        // ListIterator can be used to iterate over the LinkedList in both forward and backward directions
        // In this example, we start from the end of the list and traverse backwards
        ListIterator<String> humanSpeciesListIterator = humanSpecies.listIterator(humanSpecies.size());
        while (humanSpeciesListIterator.hasPrevious()) {
            String speciesName = humanSpeciesListIterator.previous();
            System.out.println(speciesName);
        }

        System.out.println("\n=== Iterate over a LinkedList using simple for-each loop ===");
        for(String speciesName: humanSpecies) {
            System.out.println(speciesName);
        }

    }
}

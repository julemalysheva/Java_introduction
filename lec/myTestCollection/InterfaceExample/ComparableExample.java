package lec.myTestCollection.InterfaceExample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*Давайте теперь посмотрим, как Employee объекты могут быть отсортированы автоматически по Collections.sort методу —*/
public class ComparableExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
        employees.add(new Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
        employees.add(new Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));

        System.out.println("Employees (Before Sorting) : " + employees);

        // This will use the `compareTo()` method of the `Employee` class to compare two employees and sort them.
        Collections.sort(employees);

        System.out.println("\nEmployees (After Sorting) : " + employees);
    }
}
/*Любой класс, реализующий интерфейс Comparable, готов работать с Sorted Sets и Sorted Maps.*/

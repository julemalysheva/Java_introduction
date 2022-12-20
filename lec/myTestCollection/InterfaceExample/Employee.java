package lec.myTestCollection.InterfaceExample;

import java.time.LocalDate;
import java.util.Objects;
/*Пример сопоставимого интерфейса Java
В приведенном ниже примере показано, как реализовать Comparable интерфейс в определяемом пользователем классе
 и определить compareTo()метод, чтобы сделать объекты этого класса сопоставимыми.*/
class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private double salary;
    private LocalDate joiningDate;

    public Employee(int id, String name, double salary, LocalDate joiningDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    // Compare Two Employees based on their ID
    /**
     * @param   anotherEmployee - The Employee to be compared.
     * @return  A negative integer, zero, or a positive integer as this employee
     *          is less than, equal to, or greater than the supplied employee object.
     */
    @Override
    public int compareTo(Employee anotherEmployee) {
        return this.getId() - anotherEmployee.getId();
    }

    // Two employees are equal if their IDs are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                '}';
    }
}
/*В приведенном выше примере мы сравниваем двух сотрудников по их идентификаторам.

Мы просто возвращаемся this.getId() - anotherEmployee.getId()из compareTo()функции, которая будет

negative если идентификатор этого сотрудника меньше, чем идентификатор предоставленного сотрудника,
zero если идентификатор этого сотрудника равен идентификатору предоставленного сотрудника, и
positive если идентификатор этого сотрудника больше, чем идентификатор предоставленного сотрудника.
Это просто краткий способ написать следующее:*/
/*public int compareTo(Employee anotherEmployee) {
    if(this.getId() < anotherEmployee.getId()) {
        return -1;
    } else if (this.getId() > anotherEmployee.getId()) {
        return 1;
    } else {
        return 0;
    }
}*/

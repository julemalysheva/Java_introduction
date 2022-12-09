package lec.Lesson_06.part2;
//создаем и наполняем свой класс
//как только мы создали новый класс - появляется новый тип, который используем на стороне клиентского кода
public class Worker {
    //наполняем сущность общими характеристиками и методами
    int id;
    int salary;
    String firstName;
    String lastName;

    @Override
    public String toString() {
        //убираем базовое поведение, переопределяем свое поведение метода
        return String.format("ID: %d, Name: %s %s salary: %d", id, firstName, lastName, salary);
    }
//в реальности сравниваются все поля, а может быть и поведение
    @Override
    public boolean equals(Object obj) {
        Worker t = (Worker) obj;//приводим к типу worker
        return id == t.id && firstName == t.firstName; //возвращаем равны ли id и имена
    }

    //в больших проектах описывается своя функция, сейчас просто как пример
    @Override
    public int hashCode() {
        return id; //в нашем простом примере хэш это id
    }
}
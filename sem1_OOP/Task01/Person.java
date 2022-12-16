package sem1_OOP.Task01;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private String name;
    private String surname;
    private int birthYear;
    private final Map<Person, RelationDegree> communications;

    //вынесла в отдельный класс
//    public enum RelationDegree{
//        Children, Mother, Father, GrandMother, GrandFather, Sister, Brother, Spouse, GrandChild
//    }

    public Person(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.communications = new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d года рождения", this.name, this.surname, this.birthYear);
    }

    public int getBirthYear(){
        return this.birthYear;
    }

    public Map<Person, RelationDegree> getCommunications(){
        return this.communications;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

}

package sem2_OOP_HW.Task01;


import java.util.*;

public abstract class Person {
    private String name;
    private String surname;
    protected int birthYear, power, beauty;
    private final Map<Person, RelationDegree> communications;
    protected static Random r;
    static List<Person> personList;
    static {
        r = new Random();
        personList = new ArrayList<>();
    }

    public Person(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.communications = new HashMap<>();
        personList.add(this);
//        this.beauty = r.nextInt(10,50);
//        this.power = r.nextInt(10,50);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d года рождения, beauty = %d, power = %d",
                this.name, this.surname, this.birthYear, this.beauty, this.power);
    }

    public Map<Person, RelationDegree> getCommunications(){
        return this.communications;
    }

    public void addCommunications(Person person, RelationDegree degree){
       this.communications.put(person, degree) ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getBeauty() {
        return beauty;
    }

    public void setBeauty(int beauty) {
        this.beauty = beauty;
    }
//переопределяю данные методы, т.к. Person является ключом Map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return birthYear == person.birthYear && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthYear);
    }
}
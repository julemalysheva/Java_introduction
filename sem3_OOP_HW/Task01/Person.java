package sem3_OOP_HW.Task01;


import java.util.*;

public abstract class Person implements Comparable<Person>{
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
    //можно также сам personList выводить по году рождения

    public Person(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        //заменила на TreeMap с Comparator<Person>
        this.communications = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return switch (Integer.compare(o1.birthYear, o2.birthYear)) {
                    case 1, -1 -> Integer.compare(o1.birthYear, o2.birthYear);//o1.compareTo(o2);
                    case 0 -> o1.getName().compareTo(o2.getName());
                    default -> o1.compareTo(o2);
                };
                //return o1.compareTo(o2); //жду вывод в порядке убывания
            }
        });//ломается логика добавления нов.связей, если компоратор TreeMap проверяет только по году рождения
        //this.communications = new HashMap<>(); так было раньше
        personList.add(this);
    }

//добавила свое переопределение compareTo для сравнения объектов
    @Override
    public int compareTo(Person o) {
        //return this.birthYear - o.birthYear;
        return Integer.compare(this.birthYear, o.birthYear);
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

    //добавила для получения и сравнения значения в компараторе
    public String getName() {
        return name;
    }
}
package sem3_OOP_HW.Task01;


import java.util.*;

public abstract class Person implements Comparable<Person>, FamilyTree{
    protected String name;
    private String surname;
    protected int birthYear, power, beauty;
    private final Map<Person, RelationDegree> communications;
    //в ДЗ 3 семинара добавила новую сущность RelationsTree, которая также хранит связи - делаю это для отработки итерации
    protected RelationsTree relationsTree;
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
        //заменила на TreeMap с Comparator<Person>
        this.communications = new TreeMap<>((o1, o2) -> o1.birthYear == o2.birthYear ?
                o1.getName().compareTo(o2.getName()) :
                o1.compareTo(o2));//ломается логика добавления нов.связей, если компоратор TreeMap проверяет
        // только по году рождения //поэтому если год равен, сравниваем по имени
//        this.communications = new HashMap<>(); //так было раньше
        personList.add(this);
        //новому человеку создаем новую сущность для хранения связей - по типу TreeMap, но собств.типа
        relationsTree = new RelationsTree();
    }

//добавила свое переопределение compareTo для сравнения объектов
    @Override
    public int compareTo(Person o) {
        return this.birthYear - o.birthYear;
        //return Integer.compare(this.birthYear, o.birthYear);
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

    //методы интерфейса FamilyTree очень схожи для Man Woman - поэтому изначально определяю их в базовом классе
   //в дочерних останутся лишь тонкости реализации
    //добавлены условия compareTo при добавлении детей/родителей
    //также для отработки интерфейсов добавляю связи в новую сущность RelationsTree
    @Override
    public void addParent(Person person) {
        if ((!this.getCommunications().containsKey(person)) && (this.compareTo(person) > 12)){
            if (person instanceof Man) {
                addCommunications(person, RelationDegree.Father);
                this.relationsTree.addRelation(new Relation(person, RelationDegree.Father));
                ((Man) person).transferPower(this);
            }
            else if (person instanceof Woman) {
                addCommunications(person, RelationDegree.Mother);
                this.relationsTree.addRelation(new Relation(person, RelationDegree.Mother));
                ((Woman) person).transferBeauty(this);
            }
        }
    }

    @Override
    public void addChildren(Person person) {
        if (person instanceof Man) {
            addCommunications(person, RelationDegree.Son);
            this.relationsTree.addRelation(new Relation(person, RelationDegree.Son));
        }
        else if (person instanceof Woman) {
            addCommunications(person, RelationDegree.Daughter);
            this.relationsTree.addRelation(new Relation(person, RelationDegree.Daughter));
        }
    }

    @Override
    public void addBrotherSister(Person person) {
        if (!this.getCommunications().containsKey(person)){
            if (person instanceof Man) {
                addCommunications(person, RelationDegree.Brother);
                this.relationsTree.addRelation(new Relation(person, RelationDegree.Brother));
            }
            else if (person instanceof Woman) {
                addCommunications(person, RelationDegree.Sister);
                this.relationsTree.addRelation(new Relation(person, RelationDegree.Sister));
            }
        }
    }

    @Override
    public void addSpouse(Person person) {
        if (!this.getCommunications().containsKey(person)){
            addCommunications(person, RelationDegree.Spouse);
            this.relationsTree.addRelation(new Relation(person, RelationDegree.Spouse));}
        if (!person.getCommunications().containsKey(this)){
            person.addCommunications(this, RelationDegree.Spouse);
            person.relationsTree.addRelation(new Relation(this, RelationDegree.Spouse));
        }
    }
}
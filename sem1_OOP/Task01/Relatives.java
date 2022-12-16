package sem1_OOP.Task01;

public class Relatives {
    private final Person personFirst;
    private final Person personSecond;

    /**
     * Конструктор родственной связи
     * @param personFirst человек, который является degreeKinship по отношению к personSecond
     * @param personSecond человек, кому добавляем связь, указанную в degreeKinship
     * @param degreeKinship степень родства - кем приходится personFirst для personSecond
     */
    public Relatives(Person personFirst, Person personSecond, String degreeKinship) {
        this.personFirst = personFirst;
        this.personSecond = personSecond;
        switch (degreeKinship) {
            case "parent" -> setParent();
            case "child" -> setChild();
            case "grandparent" -> setGrandparent();
            case "spouse" -> setSpouse();
            case "brother" -> setBrother();
            default -> System.out.println("Неизвестная степени родства");
        }
    }

    private void setBrother() {
        if (personFirst instanceof Man){
            personSecond.getCommunications().put(personFirst, RelationDegree.Brother);
        } else if (personFirst instanceof Woman){
            personSecond.getCommunications().put(personFirst, RelationDegree.Sister);
            }
        if (personSecond instanceof Man) {
            personFirst.getCommunications().put(personSecond, RelationDegree.Brother);
        }
        else if (personSecond instanceof Woman) {
            personFirst.getCommunications().put(personSecond, RelationDegree.Sister);
        }
    }

    private void setSpouse() {
        if ((personFirst instanceof Man && personSecond instanceof Woman) ||
        (personFirst instanceof Woman && personSecond instanceof Man)){
        personFirst.getCommunications().put(personSecond, RelationDegree.Spouse);
        personSecond.getCommunications().put(personFirst, RelationDegree.Spouse);
        }
        else System.out.println(personFirst + "и " + personSecond + "не могут быть супругами");
    }

    private void setGrandparent() {
        personFirst.getCommunications().put(personSecond, RelationDegree.GrandChild);

        if (this.personFirst instanceof Man){
            personSecond.getCommunications().put(personFirst, RelationDegree.GrandFather);
        }
        else if (this.personFirst instanceof Woman){
            personSecond.getCommunications().put(personFirst, RelationDegree.GrandMother);
        }

    }

    private void setChild() {
        personSecond.getCommunications().put(personFirst, RelationDegree.Children);
        if (this.personSecond instanceof Man){
            personFirst.getCommunications().put(personSecond, RelationDegree.Father);
        }
        else if (this.personSecond instanceof Woman){
            personFirst.getCommunications().put(personSecond, RelationDegree.Mother);
        }

    }

    private void setParent(){
        if (this.personFirst instanceof Man){
            personSecond.getCommunications().put(personFirst, RelationDegree.Father);
        }
        else if (this.personFirst instanceof Woman){
            personSecond.getCommunications().put(personFirst, RelationDegree.Mother);
        }
        personFirst.getCommunications().put(personSecond, RelationDegree.Children);
    }

    public Person getPersonFirst() {
        return personFirst;
    }

    public Person getPersonSecond() {
        return personSecond;
    }
}

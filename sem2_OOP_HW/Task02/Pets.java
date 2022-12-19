package sem2_OOP_HW.Task02;

import java.util.Objects;

public abstract class Pets extends Mammalian {
    protected HomoSapiens owner;
    String gender;
    String nickName;
    int age;

    public Pets(String gender, String nickName, int age, double weight, String color) {
        this.gender = gender;
        this.nickName = nickName;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }


    void setOwner(HomoSapiens person){
        this.owner = person;
    }

    public abstract void giveBenefit();//приносят пользу или зависят от человека
    //можно рандомно вызывать разные действия или определить в enum, в зависимости от типа строить реакции
    public  void ignoreCommand(Commands commands){
        System.out.println(this.getClass().getSimpleName() + " чаще игнорирует команду " + commands);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pets pets = (Pets) o;
        return age == pets.age && Objects.equals(gender, pets.gender) && Objects.equals(nickName, pets.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, nickName, age);
    }

    public HomoSapiens getOwner() {
        return owner;
    }
}

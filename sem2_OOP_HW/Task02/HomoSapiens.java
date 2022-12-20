package sem2_OOP_HW.Task02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomoSapiens extends Mammalian implements Omnivorous, OwnerPets{
    private String gender;
    private String name;
    private int age;
    private double weight;
    private List<Pets> petsList;
    {
        petsList = new ArrayList<>();
    }

    public HomoSapiens(String gender, String name, int age, double weight) {
        this.gender = gender;
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HomoSapiens{" +
                "gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    @Override
    public void eats(Food food) {
        eatsAll(food);
    }

    public List<Pets> getPetsList() {
        return petsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomoSapiens that = (HomoSapiens) o;
        return age == that.age && Double.compare(that.weight, weight) == 0 && Objects.equals(gender, that.gender) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, name, age, weight);
    }

    @Override
    public void addPet(Pets pet) {
        if (!this.getPetsList().contains(pet)){
            this.getPetsList().add(pet);
            pet.setOwner(this);
        }
    }

    @Override
    public void replacePet(Pets petOld, Pets petNew) {
        if (!petOld.equals(petNew) && this.getPetsList().contains(petOld) && !this.getPetsList().contains(petNew)){
            this.getPetsList().remove(petOld);
            petOld.setOwner(null);
            this.getPetsList().add(petNew);
            petNew.setOwner(this);
        }
    }

    @Override
    public void feedPet(Pets pet, Food food) {
        if (pet.getOwner() != null && pet.getOwner().equals(this))//разрешаем кормить только владельцам
            pet.eats(food);
    }

    @Override
    public void giveCommand(Pets pet, Commands com) {
        if (pet instanceof Cat){
            switch (com){
                case KISKIS -> pet.sounds();
                case TOPLACE, BYNAME, WALK -> pet.ignoreCommand(com);
                case  PLAY -> pet.move();
            }
        } else if (pet instanceof Dog) {
            switch (com){
                case KISKIS -> pet.ignoreCommand(com);
                case TOPLACE, BYNAME, WALK -> pet.move();
                case PLAY -> pet.sounds();
            }
        }
    }
}

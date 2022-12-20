package sem2_OOP_HW.Task02;

public interface OwnerPets {
    void addPet(Pets pet);
    void replacePet(Pets petOld, Pets petNew);
    void feedPet(Pets pet, Food food);
    void giveCommand(Pets pet, Commands com);
}

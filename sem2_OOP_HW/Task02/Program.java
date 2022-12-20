package sem2_OOP_HW.Task02;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Hamster hamster = new Hamster("male","baby",1, 0.6, "white");
        Food food1 = new Food(true, "курица");
        Food food2 = new Food(false, "овес");
        Cat cat1 = new Cat("female","Murka", 2, 2.5, "шотландский вислоухий", "brown");
        Dog dog1 = new Dog("female" , "Gerda", 7, 11.5, "brown", "taksa");
        HomoSapiens person1 = new HomoSapiens("male", "Sergey", 38, 85);
        HomoSapiens person2 = new HomoSapiens("female", "Vika", 18, 60);

        person1.feedPet(hamster, food1);//ничего не происходит - кормить разрешили только владельцам - он не установлен
        person1.addPet(hamster);
        person1.feedPet(hamster, food1);//Hamster Травоядное не ест Food{name='курица'}
        person1.addPet(cat1);
        person1.feedPet(cat1, food2);//Cat Хищник вряд ли будет есть Food{name='овес'}
        person2.addPet(dog1);
        person2.feedPet(dog1, food1);//Dog Хищник съест Food{name='курица'}

        person1.replacePet(hamster, new Hamster("male", "chuvak", 1, 1, "beige"));
        System.out.println("Питомцы " + person1 + " \n" + person1.getPetsList());
        System.out.println(hamster.getOwner());//null

        List<Pets> petsList = new ArrayList<>(List.of(cat1, dog1));
        List<HomoSapiens> list = new ArrayList<>(List.of(person1, person2));
        for (HomoSapiens person:list) {
            System.out.println(person + "\n");
            for (Pets pet: petsList) {
                System.out.println(pet + "\n");
                person.giveCommand(pet, Commands.KISKIS);
                person.giveCommand(pet, Commands.BYNAME);
                person.giveCommand(pet, Commands.TOPLACE);
                person.giveCommand(pet, Commands.WALK);
                person.giveCommand(pet, Commands.PLAY);
            }
        }


    }
}

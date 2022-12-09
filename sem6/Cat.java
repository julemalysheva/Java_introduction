package sem6;
/*1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, которое является
а) информационной системой ветеринарной клиники
б) архивом выставки котов
в) информационной системой Театра кошек Ю. Д. Куклачёва
Можно записать в текстовом виде, не обязательно реализовывать в java.
1. Реализуйте 1 из вариантов класса Cat из предыдущего задания, можно использовать не все придуманные поля и методы.
 Создайте несколько экземпляров этого класса, выведите их в консоль.
2. Добейтесь того, чтобы при выводе в консоль объекта типа Cat, выводилась его кличка, цвет и возраст
(или другие параметры на ваше усмотрение).
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Cat {
    //информационной системой ветеринарной клиники
    int id;
    int age;
    String owner;
    String breed;//порода
    double weight;

//    //выставка
//    String color;
//    int id;
//    boolean win;
//    String nomination;
//    //театр кошек
//    String name;
//    String temperament;
//    String role;

    //создаем конструктор. название как и у класса
    public Cat(int id, int age, String owner, String breed, double weight){
        this.id = id;
        this.age = age;
        this.owner = owner;
        this.breed = breed;
        this.weight = weight;
    }
//сочетание Alt+Insert помогает создавать элементы класса
    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", age=" + age +
                ", owner='" + owner + '\'' +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Cat c = (Cat) obj;
        return id == c.id && age == c.age && Objects.equals(owner, c.owner) && Objects.equals(breed, c.breed) && weight == c.weight;
    }

//    Создайте метод public int hashCode()
//    который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно использовать Objects.hash(...))
    @Override
    public int hashCode() {
        return Objects.hash(id, age, owner, breed, weight);
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat(1, 3, "Малышева", "Сфинкс", 4.2);
        Cat cat2 = new Cat(2, 2, "Попова", "Сиамская", 3.2);
        Cat cat3 = new Cat(3, 4, "Куркина", "Неизвестно", 2.7);
        Cat cat4 = new Cat(1, 3, "Малышева", "Сфинкс", 4.2);

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(cat1.equals(cat4));//true

    /*1. Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>.
    Поместите в него некоторое количество объектов.
2. Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество.
Убедитесь, что все они сохранились во множество.
3. Создайте метод public boolean equals(Object o)
Пропишите в нём логику сравнения котов по параметрам, хранимым в полях. То есть, метод должен возвращать true,
только если значения во всех полях сравниваемых объектов равны.
4. Создайте метод public int hashCode()
который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно использовать Objects.hash(...))
5. Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились.
*/
        HashSet<Cat> cats = new HashSet<>(Arrays.asList(cat1, cat2, cat3, cat4));
        System.out.println(cats);
        //даже когда переопределили equals и он дает true при сравнение cat1 и cat4. множество по-прежнему содержит 4
        //элемента, а не 3 - нужно переопределить хэш-функцию
        System.out.println("size " + cats.size());//3 после того, как переопределили hashCode
        //т.к. Set строит свою уникальность именно на хэш-кодах
    }
}

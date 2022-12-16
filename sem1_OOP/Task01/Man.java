package sem1_OOP.Task01;
//данные классы Man и Woman создаю только для проработки наследования, в целом можно обойтись классом person
public class Man extends Person{
    private final String GENDER = "male";

    public Man(String name, String surname, int birthYear) {
        super(name, surname, birthYear);
    }

    //можно добавить индивидуально вывод в консоль, типа Отец/мужчина ...переопределить вывод к примеру

    @Override
    public String toString() {
        return GENDER + " " + super.toString();
    }

    public String getGENDER() {
        return GENDER;
    }
}

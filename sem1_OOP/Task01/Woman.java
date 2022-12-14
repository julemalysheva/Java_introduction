package sem1_OOP.Task01;

public class Woman extends Person {
    private final String GENDER = "female";

    public Woman(String name, String surname, int birthYear) {
        super(name, surname, birthYear);
    }
    @Override
    public String toString() {
        return GENDER + " " + super.toString();
    }

    public String getGENDER() {
        return GENDER;
    }

}

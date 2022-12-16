package sem2_OOP.lesson1_4;

public interface MyI {
    int getUserId();

    default int getAdminId() { //Объявление метода по умалчанию
        return 1;
    }//метод интерф.по умолчанию - сработает, если не переопределить

    static int universalId() {
        return 0;
    }//статич.метод интерф. - вызывается при обращении не к классу или экземпл.,
    //а именно к интерф.
}

package Sem6_OOP_HW.MVP.CalcRational;


import Sem6_OOP_HW.MVP.PresenterCalc;
import Sem6_OOP_HW.MVP.View;

/**
 * Класс управления связью между Model и View для работы с рациональными числами
 * наследуется от абстрактного класса PresenterCalc
 */
public class PresenterRational extends PresenterCalc {
    /**
     * конструктор компоненты управления связями с параметром
     * @param v экземпляр интерфейса пользователя
     */
    public PresenterRational(View v) {
        view = v;
    }

    /**
     * Метод устанавливает конкретный тип/подкласс модели расчета, с которой будет работать текущая компонента
     * управления связями - в зависимости от пользовательского выбора операции
     * @param number номер операции
     */
    @Override
public void setModel(int number) {
        switch (number){
            case 1: this.model = new SumModelRational(); break;
            case 2: this.model = new SubModelRational(); break;
            case 3: this.model = new MulModelRational(); break;
            case 4: this.model = new DivModelRational(); break;
            default: //Exception или? по идее такого быть не может
        }
    }

    /**
     * Метод запуска текущей компоненты управления связями -
     * поведение, заданное интерфейсом I__Presenter, переопределяется в каждом дочернем классе
     */
    @Override
    public void buttonClick() {
        Double res = null;
        int operation = 0;
        Double first = view.getValue("Введите число: ");
        while (true) {
            operation = view.getVariant(""" 
                    Выберите операцию - введите число пункта меню:
                        1 - сложить (+)
                        2 - вычесть (-)
                        3 - умножить (*)
                        4 - разделить (/)
                    """);
            //текст для вывода можно вынести куда-то отдельно в константы
            if (operation >= 1 && operation<=4) break;
        }
        Double second = view.getValue("Введите число: ");
        //дальше вызвать setModel в зависимости от операции
        setModel(operation); //установили модель по типу операции
        model.setX(first);
        model.setY(second);
        try {
        res = (Double) model.result();}
        catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        if (res != null) {
            view.viewData(String.format("%s", res), String.format("Результат операции %s с числами: %s, %s = ",
                    operation, first, second));
        } else{
            view.viewData(String.format("%s", res), String.format("Некорректное выражение операции %s с числами: %s, %s = ",
                    operation, first, second));
        }

    }

}

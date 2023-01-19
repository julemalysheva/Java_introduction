package Sem6_OOP_HW.MVP.CalcComlex;


import Sem6_OOP_HW.Infrastructure.Complex;
import Sem6_OOP_HW.MVP.PresenterCalc;
import Sem6_OOP_HW.MVP.View;

/**
 * Класс управления связью между Model и View для работы с комплексными числами
 * наследуется от абстрактного класса PresenterCalc
 */
public class PresenterComplex extends PresenterCalc {
    /**
     * конструктор компоненты управления связями с параметром
     * @param v экземпляр интерфейса пользователя
     */
    public PresenterComplex(View v) {
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
            case 1: this.model = new SumModelComplex(); break;
            case 2: this.model = new SubModelComplex(); break;
            case 3: this.model = new MulModelComplex(); break;
            case 4: this.model = new DivModelComplex(); break;
        }
    }

    /**
     * Метод запуска текущей компоненты управления связями -
     * поведение, заданное интерфейсом I__Presenter, переопределяется в каждом дочернем классе
     */
    @Override
    public void buttonClick() {
        Complex res = null;
        int operation = 0;
        Complex firstNum = new Complex(view.getValue("Введите реальную часть компл.числа: "),
                view.getValue("Введите мнимую часть компл.числа: "));
        while (true) {
            operation = view.getVariant(""" 
                    Выберите операцию - введите число пункта меню:
                        1 - сложить (+)
                        2 - вычесть (-)
                        3 - умножить (*)
                        4 - разделить (/)
                    """);
            if (operation >= 1 && operation<=4) break;
        }
        Complex secondNum = new Complex(view.getValue("Введите реальную часть компл.числа: "),
                view.getValue("Введите мнимую часть компл.числа: "));
        this.setModel(operation); //установили модель по типу операции
        //передали значения чисел в модель
        model.setX(firstNum);
        model.setY(secondNum);
        try {
            res = (Complex) model.result();
        } catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        if (res != null) {
            view.viewData(String.format("%s", res), String.format("Результат операции %s с числами: %s, %s = ",
                    operation, firstNum, secondNum));
        } else {
            view.viewData(String.format("%s", res), String.format("Некорректное выражение операции %s с числами: %s, %s = ",
                    operation, firstNum, secondNum));
        }

    }


}

package Sem5_OOP.MVP;


import Sem5_OOP.Infrastructure.Complex;
import Sem5_OOP.Logger.MyLog;
import Sem5_OOP.MVP.CalcComlex.CalcComplexModel;
import Sem5_OOP.MVP.CalcRational.CalcRationalModel;

import java.util.logging.Logger;

public class Presenter <T extends CalcModel> {
    static MyLog myLog = new MyLog(Logger.getLogger(Presenter.class.getName()));

    View view;
    Model model;

    public Presenter(T m, View v) {
        model = m;
        view = v;
    }

    //или создать отдельный класс для обработки PresenterComplex, экз-р которого запускать в App при соотв.выборе?
    public void buttonClick(){
        if (this.model instanceof CalcRationalModel) this.buttonClickRational();
        else if (this.model instanceof CalcComplexModel) buttonClickComplex();
    }
    public void buttonClickRational() {
        Double res = null;
        Double first = view.getValue("Введите число: ");
        char operation = view.getOperation("Введите операцию (+,-,*,/): ");
        Double second = view.getValue("Введите число: ");
        model.setX(first);
        model.setY(second);
        try {
        res = (Double) model.result(operation);}
        catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        view.viewResult(String.format("%s", res), String.format("%s %s %s = ", first, operation,second));

    }
    public void buttonClickComplex(){
        Complex res = null;
        Complex firstNum = new Complex(view.getValue("Введите реальную часть компл.числа: "),
                view.getValue("Введите мнимую часть компл.числа: "));
        char operation = view.getOperation("Введите операцию (+,-,*,/): ");
        Complex secondNum = new Complex(view.getValue("Введите реальную часть компл.числа: "),
                view.getValue("Введите мнимую часть компл.числа: "));
        model.setX(firstNum);
        model.setY(secondNum);
        try {
            res = (Complex) model.result(operation);}
        catch (Exception e){
            e.printStackTrace();
            myLog.log(e.getMessage());
        }
        view.viewResult(String.format("%s", res), String.format("%s %s %s = ", firstNum, operation, secondNum));


    }


}

package Sem6_OOP_HW.MVP.CalcRational;

import Sem6_OOP_HW.MVP.CalcModel;

/**
 * Класс описывает модель Деления рациональных чисел
 */
public class DivModelRational extends CalcModel<Double> {

    /**
     * метод расчета
     * @return результат расчета
     */
    @Override
    public Double result()  {
        if (y != 0) return x / y;
        return null;
    }

}

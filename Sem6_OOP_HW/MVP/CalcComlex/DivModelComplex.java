package Sem6_OOP_HW.MVP.CalcComlex;

import Sem6_OOP_HW.Infrastructure.Complex;
import Sem6_OOP_HW.MVP.CalcModel;

/**
 * Класс описывает модель Деления комплексных чисел
 */
public class DivModelComplex extends CalcModel<Complex> {
    /**
     * Метод расчета
     * @return результат расчета
     */
    @Override
    public Complex result() {
        if (this.y.getReal() == 0 && this.y.getImage() == 0) {
            return null;
        } else return this.x.div(this.y);
    }
}




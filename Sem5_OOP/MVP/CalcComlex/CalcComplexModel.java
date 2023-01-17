package Sem5_OOP.MVP.CalcComlex;

import Sem5_OOP.Infrastructure.Complex;
import Sem5_OOP.MVP.CalcModel;

public class CalcComplexModel extends CalcModel<Complex> {

    @Override
    public Complex result(char operation) throws Exception {
        Complex result = null;
        switch (operation) {
            case '+' -> result = this.x.add(this.y);
            case '-' -> result = this.x.sub(this.y);
            case '*' -> result = this.x.mul(this.y);
            case '/' -> {
                if (this.y.getReal() == 0 && this.y.getImage()==0) {
                    throw new Exception("Деление на --0--!");
                } else result = this.x.div(this.y);
            }
            default -> System.out.println("Операция не распознана. Повторите ввод.");
        }
        return result;    }

    @Override
    public void setX(Complex value) {
        this.x = value;
    }

    @Override
    public void setY(Complex value) {
        this.y = value;
    }
}

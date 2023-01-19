package Sem6_OOP_HW.Infrastructure;

/**
 * Класс определяет операции над комплексными числами и формат вывода числа
 */
public class Complex {
    private double real;
    private double image;

    /**
     * Конструктор комплексного числа с параметрами
     * @param real реальная часть
     * @param image мнимая часть
     */
    public Complex(double real, double image) {
        this.real = real;
        this.image = image;
    }

    /**
     * Метод позволяет получить реальную часть комплексного числа
     * @return реальная часть типа double
     */
    public double getReal() {
        return real;
    }

    /**
     * Метод позволяет задать реальную часть комплексного числа
     * @param real реальная часть
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * Метод позволяет получить мнимую часть комплексного числа
     * @return мнимая часть типа double
     */
    public double getImage() {
        return image;
    }

    /**
     * Метод позволяет задать мнимую часть комплексного числа
     * @param image мнимая часть
     */
    public void setImage(double image) {
        this.image = image;
    }

    /**
     * Метод добавления (сложения) комплексного числа
     * @param a Комплексное число, которое нужно добавить
     * @return новое комплексное число, являющееся суммой двух чисел: this и a
     */
    public Complex add (Complex a) {
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = real + real2;
        double newImage = image + image2;
        return new Complex(newReal,newImage);
    }

    /**
     * Метод разности (вычитания) комплексного числа
     * @param a Комплексное число, которое нужно вычесть
     * @return новое комплексное число, являющееся разностью двух чисел: this и a
     */
    public Complex sub (Complex a) {
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = real - real2;
        double newImage = image - image2;
        return new Complex(newReal,newImage);
    }

    /**
     * Метод умножения на комплексное число
     * @param a Комплексное число, на которое нужно умножить
     * @return новое комплексное число, являющееся произведением двух чисел: this и a
     */
    public Complex mul (Complex a) {
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = real*real2 - image*image2;
        double newImage = image*real2 + real*image2;
        return new Complex(newReal,newImage);
    }

    /**
     * Метод деления на комплексное число
     * @param a Комплексное число, на которое нужно разделить
     * @return новое комплексное число, являющееся результатом деления двух чисел: this на a
     */
    public Complex div (Complex a) {
        double real2 = a.getReal();
        double image2 = a.getImage();
        double newReal = (real*real2 + image*image2)/(real2*real2 + image2*image2);
        double newImage = (image*real2 - real*image2)/(real2*real2 + image2*image2);
        return new Complex(newReal,newImage);
    }

    /**
     * Строковое представление комплексного числа
     * @return Комплексное число для вывода на печать/в консоль в формате x +- yi
     */
    @Override
    public String toString() {
        StringBuilder complex = new StringBuilder();
        if(image > 0){
            complex.append(real).append(" + ").append(image).append("i");
        }else if(image < 0){
            complex.append(real).append(image).append("i");
        }else{
            complex.append(real);
        }

        return complex.toString();
    }
}

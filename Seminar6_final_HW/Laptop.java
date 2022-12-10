package Seminar6_final_HW;

import java.util.Objects;

public class Laptop {
    String model;
    double screenDiagonal;
    String processor;
    int coresNumber;
    double frequencyProcessorGHz;
    int amountRAM;
    int SSD_Capacity;
    String OS;
    boolean gamingLaptop;
    String color;
    int warrantyMonths;//гарантия в месяцах
    double maxBatteryLife; // макс.время автоном.работы в часах
    double weight; //в кг
    int price;

    public Laptop(String model, double screenDiagonal, String processor, int coresNumber,
                  double frequencyProcessorGHz, int amountRAM, int SSD_Capacity, String OS, boolean gamingLaptop,
                  String color, int warrantyMonths, double maxBatteryLife, double weight, int price) {
        this.model = model;
        this.screenDiagonal = screenDiagonal;
        this.processor = processor;
        this.coresNumber = coresNumber;
        this.frequencyProcessorGHz = frequencyProcessorGHz;
        this.amountRAM = amountRAM;
        this.SSD_Capacity = SSD_Capacity;
        this.OS = OS;
        this.gamingLaptop = gamingLaptop;
        this.color = color;
        this.warrantyMonths = warrantyMonths;
        this.maxBatteryLife = maxBatteryLife;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", scrDiagonal=" + screenDiagonal +
                ", processor='" + processor + '\'' +
                ", cores=" + coresNumber +
                ", ProcessorGHz=" + frequencyProcessorGHz +
                ", RAM=" + amountRAM +
                ", SSD=" + SSD_Capacity +
                ", OS='" + OS + '\'' +
                ", gaming='" + gamingLaptop + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Laptop laptop = (Laptop) o;
        return laptop.screenDiagonal == screenDiagonal && coresNumber == laptop.coresNumber
                && laptop.frequencyProcessorGHz == frequencyProcessorGHz &&
                amountRAM == laptop.amountRAM && SSD_Capacity == laptop.SSD_Capacity &&
                gamingLaptop == laptop.gamingLaptop && warrantyMonths == laptop.warrantyMonths &&
                maxBatteryLife == laptop.maxBatteryLife && laptop.weight == weight &&
                price == laptop.price && model.equals(laptop.model) &&
                processor.equals(laptop.processor) && OS.equals(laptop.OS) && color.equals(laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, screenDiagonal, processor, coresNumber, frequencyProcessorGHz,
                amountRAM, SSD_Capacity, OS, gamingLaptop, color, warrantyMonths, maxBatteryLife, weight, price);
    }

    //метод проверки соответствия пользовательскому фильтру
    //на вход число (критерий отбора)- ключ словаря и строка - значение критерия
    //true когда числовые значения >= заданному, строковые - если содержат заданную, bool если в запросе Да
    public boolean checkUsersFilter(Integer key, String filter){
        switch (key) {
            case 1 -> {
                return this.model.toLowerCase().contains(filter.toLowerCase());
            }
            case 2 -> {
                return this.screenDiagonal >= Double.parseDouble(filter);
            }
            case 3 -> {
                return this.processor.toLowerCase().contains(filter.toLowerCase());
            }
            case 4 -> {
                return this.coresNumber >= Integer.parseInt(filter);
            }
            case 5 -> {
                return this.frequencyProcessorGHz >= Double.parseDouble(filter);
            }
            case 6 -> {
                return this.amountRAM >= Integer.parseInt(filter);
            }
            case 7 -> {
                return this.SSD_Capacity >= Integer.parseInt(filter);
            }
            case 8 -> {
                return this.OS.toLowerCase().contains(filter.toLowerCase());
            }
            case 9 -> {
                if (filter.equalsIgnoreCase("да")) return gamingLaptop;
                else return !gamingLaptop;
            }
            case 10 -> {
                return this.color.toLowerCase().contains(filter.toLowerCase());
            }
            case 11 -> {
                return this.warrantyMonths >= Integer.parseInt(filter);
            }
            case 12 -> {
                return this.maxBatteryLife >= Double.parseDouble(filter);
            }
            case 13 -> {
                return this.weight >= Double.parseDouble(filter);
            }
            case 14 -> {
                return this.price >= Integer.parseInt(filter);
            }

        }
        return false;
    }

}

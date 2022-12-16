package sem2_OOP.lesson1_2;
//класс реализует интерф.IConst, константы интерфейса используются внутри класса
public class ErConst implements IConst {
    public static void main(String[] args) {
        int[] nums = new int[max];
        for (int i = min; i < 11; i++) {
            if (i >= max) {
                System.out.println(error);
            }else {
                nums[i] = i;
                System.out.println(nums[i] + " ");
            }
        }
    }
}

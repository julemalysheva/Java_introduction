package sem2;

import java.io.File;

/*Напишите метод, который определит тип (расширение) файлов из текущей папки и
выведет в консоль результат вида
			1 Расширение файла: txt
			2 Расширение файла: pdf
			3 Расширение файла: 
			4 Расширение файла: jpg
 */
public class task06Sem2 {
    public static void main(String[] args) {
        String pathProject = System.getProperty("user.dir");
        File file = new File(pathProject);
        String[] listFolder = file.list();
        if (listFolder != null){
            //здесь выводит в т..ч. папки вида .ИмяПапки
            System.out.println("Выводим все содержимое, включая папки с точкой (.) в имени");
            System.out.println(makeStrFileExtensions(listFolder));}
        else System.out.println("Папка пуста");

//        дальше пробую проверять, если это файл в полученном списке - тогда собирать строку с расширением
//        так мы увидим список полных путей к папкам и файлам в каталоге
        File[] listFiles = file.listFiles();
        //System.out.println(Arrays.toString(listFolder));
        if (listFiles != null) {
//        for (File fl:listFiles) {
//            if (fl.isFile()) {
//                System.out.println(fl);
//            }
//        }
            System.out.println("Выводим только расширения файлов:");
            System.out.println(makeStrFiles(listFiles));
        }
    }

    static String makeStrFileExtensions(String[] folderList){
        StringBuilder sb = new StringBuilder();
        int number = 1;
        for (String item: folderList) {
            if (item.contains(".")){
                String[] strArr = item.split("\\.");
                //1 Расширение файла: txt
                sb.append(number).append(" ").append("Расширение файла: ").append(strArr[strArr.length-1]).append("\n");
                number++;
            }
        }
        return sb.toString();
    }

    static String makeStrFiles(File[] list){
        StringBuilder sb = new StringBuilder();

        if (list != null) {
            int number = 1;

            for (File fl:list) {
                if (fl.isFile()) {
                    //собираем строку
                    String[] strArr = fl.getName().split("\\.");
                    //1 Расширение файла: txt
                    sb.append(number).append(" ").append("Расширение файла: ").append(strArr[strArr.length-1]).append("\n");
                    number++;
                }
            }
        } else sb.append("Нет файлов");
    return sb.toString();
    }
}

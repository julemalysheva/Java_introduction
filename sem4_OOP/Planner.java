package sem4_OOP;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

//добавление/изменение/удаление задач - можно работать через экземпляр, например; пользовательский ввод
public class Planner {
    Scanner sc = new Scanner(System.in);

//    private LocalDateTime InputDeadlineDate(){ //вспомог.метод для запроса дедлайна из строки
//        boolean checkInput = false;
//        LocalDateTime deadline = null;
//        while (!checkInput) {
//            System.out.println("Введите дату дедлайна для задачи в формате:\nГГГГ-ММ-ДД" +
//                    "\nнапример, 2023-01-10 - для 10.01.2023 г. ");
//            LocalDate deadlineDate = null;
//            if (sc.hasNextLine()) {
//                deadlineDate = LocalDate.parse(sc.nextLine());
//                System.out.println(deadlineDate);
//            }
//            System.out.println("Введите время дедлайна для задачи в формате ЧЧ:ММ");
//            LocalTime deadlineTime = null;
//            if (sc.hasNextLine()) {
//                deadlineTime = LocalTime.parse(sc.nextLine());
//                System.out.println(deadlineTime);
//            }
//            assert deadlineDate != null;
//            assert deadlineTime != null;
//            deadline = LocalDateTime.of(deadlineDate, deadlineTime);
//            System.out.println(deadline);
//            checkInput = true;
//        }
//        return deadline;
//    }
    public void inputTask() {//добавление задачи через пользовательский ввод
        boolean checkInput = false;
        LocalDateTime deadline = null;
        while (!checkInput) {
            System.out.println("Введите дату дедлайна для задачи в формате:\nГГГГ-ММ-ДД" +
                    "\nнапример, 2023-01-10 - для 10.01.2023 г. ");
            LocalDate deadlineDate = null;
            if (sc.hasNextLine()) {
                deadlineDate = LocalDate.parse(sc.nextLine());
                System.out.println(deadlineDate);
            }
            System.out.println("Введите время дедлайна для задачи в формате ЧЧ:ММ");
            LocalTime deadlineTime = null;
            if (sc.hasNextLine()) {
                deadlineTime = LocalTime.parse(sc.nextLine());
                System.out.println(deadlineTime);
            }
            assert deadlineDate != null;
            assert deadlineTime != null;
            deadline = LocalDateTime.of(deadlineDate, deadlineTime);
            System.out.println(deadline);
            checkInput = true;
        }
//        LocalDateTime deadline = this.InputDeadlineDate();
        System.out.println("Введите ФИО автора задачи:");
        String author = null;
        if (sc.hasNextLine()) {
            author = sc.nextLine();
        }
        System.out.println("Введите описание задачи:");
        String description = null;
        if (sc.hasNextLine()) {
            description = sc.nextLine();
        }
        TaskTree.addTask(new Task(LocalDate.now(), LocalDateTime.now().toLocalTime(), deadline, author, description));
    }

    public void chosenDateDeadline(){//выбор даты дедлайна и показ планнера на эту дату

    }
    //сейчас здесь какие-то проблемы со сканером, доработать - может поменять на next вместо nextLine?
    public void changeTask(){
        System.out.println("Введите id задачи для изменений:");
        String searchId = sc.nextLine();
        Task searchTask = TaskTree.searchById(searchId);
        if (searchTask!=null){
            try {
            boolean checkInput = false;
            while (!checkInput){
                System.out.println("Что будем менять?\n1 - дату/время дедлайна\n2 - описание задачи");
                if (sc.hasNextInt()){
                    int choice = sc.nextInt();//?
                switch (choice) {
                    case 1 -> {
                        checkInput = true;
                        System.out.println("Текущее значение: " + searchTask.getDeadlineTask());
//                        LocalDateTime deadline = this.InputDeadlineDate();
                        //сначала вынесла запрос даты/времени в отд.ф-цию - сканер сбивается - прописала пока все в каждом случае
                        System.out.println("Введите дату дедлайна для задачи в формате:\nГГГГ-ММ-ДД" +
                                "\nнапример, 2023-01-10 - для 10.01.2023 г. ");
                        LocalDate deadlineDate = null;
                        if (sc.hasNext()) {//hasNextLine
                            deadlineDate = LocalDate.parse(sc.next());//nextLine
                            System.out.println(deadlineDate);
                        }
                        System.out.println("Введите время дедлайна для задачи в формате ЧЧ:ММ");
                        LocalTime deadlineTime = null;
                        if (sc.hasNext()) {//hasNextLine
                            deadlineTime = LocalTime.parse(sc.next());//nextLine
                            System.out.println(deadlineTime);
                        }
                        assert deadlineDate != null;
                        assert deadlineTime != null;
//                        deadline = LocalDateTime.of(deadlineDate, deadlineTime);
//                        System.out.println(deadline);
                        searchTask.setDeadlineTask(LocalDateTime.of(deadlineDate, deadlineTime));
                    }
                    case 2 -> {
                        checkInput = true;
                        System.out.println("Текущее значение: " + searchTask.getTaskDescription());
                        System.out.println("Введите новое описание задачи:");
                        if (sc.hasNext()) {//hasNextLine
                            String description = sc.next();//nextLine
                            searchTask.setTaskDescription(description);
                        }
                    }
                    default -> System.out.println("Ошибка ввода - попробуйте снова");
                }
                }
            }
        } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } else System.out.println("Задача не найдена");
    }
    public void deleteTask(){

    }
    public void saveData(){

    }
    public void loadData(){

    }

}

package sem4_OOP;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

//добавление/изменение/удаление задач - можно работать через экземпляр, например;
// пользовательский ввод
public class Planner {
    static Scanner sc = new Scanner(System.in);//добавила static

    private LocalDateTime InputDeadlineDate(){ //вспомог.метод для запроса дедлайна из строки
        boolean checkInput = false;
        LocalDateTime deadline = null;
        while (!checkInput) {
            System.out.println("Введите дату дедлайна для задачи в формате:\nГГГГ-ММ-ДД" +
                    "\nнапример, 2023-01-10 - для 10.01.2023 г. ");
            LocalDate deadlineDate = null;
            if (sc.hasNextLine()) {//hasNextLine hasNext
                deadlineDate = LocalDate.parse(sc.nextLine());//nextLine next
                System.out.println(deadlineDate);
            }
            System.out.println("Введите время дедлайна для задачи в формате ЧЧ:ММ");
            LocalTime deadlineTime = null;
            if (sc.hasNextLine()) {//hasNextLine hasNext
                deadlineTime = LocalTime.parse(sc.nextLine());//nextLine next
                System.out.println(deadlineTime);
            }
            assert deadlineDate != null;
            assert deadlineTime != null;
            deadline = LocalDateTime.of(deadlineDate, deadlineTime);
            System.out.println(deadline);
            checkInput = true;
        }
        return deadline;
    }
    public void inputTask() {//добавление задачи через пользовательский ввод
        LocalDateTime deadline = this.InputDeadlineDate();
        System.out.println("Введите ФИО автора задачи:");
        String author = null;
        if (sc.hasNextLine()) {//   hasNext hasNextLine
            author = sc.nextLine();//   next nextLine
        }
        System.out.println("Введите описание задачи:");
        String description = null;
        if (sc.hasNextLine()) {// hasNext hasNextLine
            description = sc.nextLine();//nextLine next
        }
        TaskTree.addTask(new Task(LocalDate.now(), LocalDateTime.now().toLocalTime(), deadline, author, description));
    }

    public void chosenDateDeadline(){//выбор даты дедлайна и показ планнера на эту дату
        System.out.println("Введите дату дедлайна, по которую нужно показать задачи. ");
        System.out.println("В формате ГГГГ-ММ-ДД, например, 2023-01-10 - до 10.01.2023 г.");
        if (sc.hasNextLine()) {
            LocalDate deadlineDate = LocalDate.parse(sc.nextLine());
            System.out.println(deadlineDate);
            TaskTree.printTaskBeforeDate(deadlineDate);
        }

    }
    public void changeTask(){
        System.out.println("Введите id задачи для изменений:");
        String searchId = sc.nextLine();
        Task searchTask = TaskTree.searchById(searchId);
        if (searchTask!=null){
            try {
            boolean checkInput = false;
            while (!checkInput){
                System.out.println("Что будем менять?\n1 - дату/время дедлайна\n2 - описание задачи");
                if (sc.hasNextLine()){//hasNextInt
                    String choice = sc.nextLine();//?nextInt
                switch (choice) {
                    case "1" -> {
                        checkInput = true;
                        System.out.println("Текущее значение: " + searchTask.getDeadlineTask());
                        LocalDateTime deadline = this.InputDeadlineDate();
                        searchTask.setDeadlineTask(deadline);//LocalDateTime.of(deadlineDate, deadlineTime)
                    }
                    case "2" -> {
                        checkInput = true;
                        System.out.println("Текущее значение: " + searchTask.getTaskDescription());
                        System.out.println("Введите новое описание задачи:");
                        if (sc.hasNextLine()) {//hasNextLine hasNext
                            String description = sc.nextLine();//nextLine next
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
        System.out.println("Введите id задачи для удаления:");
        String searchId = sc.nextLine();
        Task searchTask = TaskTree.searchById(searchId);
        if (searchTask!=null){
            TaskTree.removeTaskByID(searchId);
            System.out.println("Задача отменена успешно");
        }
    }
    public void saveData() throws IOException {
        //здесь можно выбирать формат и путь к файлу, после чего вести на разные методы/классы, но т.к. пока не успеваю
        //просто вызывается метод записи в csv
        DataExchange.csvWriter();
    }
    public void loadData(){
       //здесь аналогично подумать над иерархией классов/методов - пока просто вызов загрузки csv
        //DataExchange.csvReader();
        System.out.println("На данный момент метод в разработке))");
    }

}

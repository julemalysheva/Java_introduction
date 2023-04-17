package Exceptions.lesson3.sem3HW;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные: Фамилия Имя Отчество датарождения номертелефона пол");
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new IllegalArgumentException("Неверное количество данных");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];

            if (!isValidDate(birthDate)) {
                throw new IllegalArgumentException("Неверный формат даты рождения");
            }

            long phone = parsePhoneNumber(phoneNumber);

            if (!isValidGender(gender)) {
                throw new IllegalArgumentException("Неверный пол");
            }

            String fileName = lastName + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(lastName).append(firstName).append(middleName)
                    .append(birthDate).append(" ").append(String.valueOf(phone))
                    .append(gender).append(System.lineSeparator());
            writer.close();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidDate(String date) {
        // Проверка формата даты
        if (date == null || !date.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(false);

        try {
            sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }

        return true;
    }

    private static long parsePhoneNumber(String phoneNumber) {
        // Парсинг номера телефона
        if (phoneNumber == null || !phoneNumber.matches("\\d+")) {
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }

        try {
            return Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат номера телефона", e);
        }
    }

    private static boolean isValidGender(String gender) {
        // Проверка корректности значения пола
        return gender != null && gender.length() == 1 && (gender.equalsIgnoreCase("m") ||
                gender.equalsIgnoreCase("f"));
    }



}

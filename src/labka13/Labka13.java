/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labka13;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Головний клас програми, який містить точку входу.
 */
public class Labka13 {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static String[] subjects = {"Математика", "Фізика", "Комбінаторика", "Проектування", "Інформатика"};

    /**
     * Точка входу в програму.
     *
     * @param args Масив аргументів командного рядка.
     */
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Додати нового студента.");
            System.out.println("2. Вивести всіх студентів.");
            System.out.println("3. Додати оцінки існуючим студентам.");
            System.out.println("4. Відрахувати студентів з середнім балом менше 3.");
            System.out.println("5. Вийти.");
            System.out.print("Введіть число для вибору: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addNewStudent();
                        break;
                    case 2:
                        displayAllStudents();
                        break;
                    case 3:
                        addGrades();
                        break;
                    case 4:
                        removeStudentsWithLowGPA();
                        break;
                    case 5:
                        System.out.println("Вихід з програми.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Помилка, введіть число від 1 до 5.");
                }
            } else {
                System.out.println("Помилка, введіть ціле число.");
                scanner.next();
            }
        }
    }

    /**
     * Додає нового студента.
     */
    private static void addNewStudent() {
        do {
            System.out.print("Введіть ім'я студента: ");
            String name = scanner.nextLine();
            System.out.print("Введіть ID студента: ");
            String id = scanner.nextLine();

            if (!name.isEmpty() && !id.isEmpty()) {
                students.add(new Student(name, id));
                System.out.println("Студента додано до списку.");
                break;
            } else {
                System.out.println("Ім'я та ID студента не можуть бути пустими.");
            }
        } while (true);
    }

    /**
     * Виводить усіх студентів.
     */
    private static void displayAllStudents() {
        System.out.println("========================");
        if (students.isEmpty()) {
            System.out.println("Немає студентів у списку.");
        } else {
            for (Student student : students) {
                System.out.println("Ім'я: " + student.getName() + ", ID: " + student.getId());
                student.getTranscript().displayTranscript(student.getName());
            }
        }
        System.out.println("========================");
    }

    /**
     * Додає оцінки існуючим студентам.
     */
    private static void addGrades() {
        if (students.isEmpty()) {
            System.out.println("Немає студентів у списку.");
            return;
        }

        System.out.print("Введіть ID студента: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Виберіть предмет: ");
                for (int i = 0; i < subjects.length; i++) {
                    System.out.println((i + 1) + ". " + subjects[i]);
                }

                int subjectIndex;
                do {
                    System.out.print("Введіть номер предмету: ");
                    subjectIndex = scanner.nextInt();
                    scanner.nextLine();

                    if (subjectIndex < 1 || subjectIndex > subjects.length) {
                        System.out.println("Неправильний вибір предмету.");
                    }
                } while (subjectIndex < 1 || subjectIndex > subjects.length);

                int grade;
                do {
                    System.out.print("Введіть оцінку: ");
                    grade = scanner.nextInt();
                    scanner.nextLine();

                    if (grade < 1 || grade > 5) {
                        System.out.println("Оцінка повинна бути в діапазоні від 1 до 5.");
                    }
                } while (grade < 1 || grade > 5);

                student.getTranscript().addGrade(subjects[subjectIndex - 1], grade);
                System.out.println("Оцінку додано.");
                return;
            }
        }
        System.out.println("Студента з айді " + id + " не знайдено.");
    }

    /**
     * Видаляє студентів з середнім балом менше 3.
     */
    private static void removeStudentsWithLowGPA() {
        if (students.isEmpty()) {
            System.out.println("Список студентів пустий.");
            return;
        }
        ArrayList<Student> toRemove = new ArrayList<>();
        for (Student student : students) {
            if (student.getTranscript().calculateGPA() < 3.0) {
                toRemove.add(student);
            }
        }
        for (Student student : toRemove) {
            students.remove(student);
            System.out.println("Студента " + student.getName() + " з айді " + student.getId() + " було відраховано.");
        }
    }
}

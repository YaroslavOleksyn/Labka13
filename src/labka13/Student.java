/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labka13;

import java.util.ArrayList;

/**
 * Клас для представлення студента.
 */
class Student {
    private String name;
    private String id;
    private Transcript transcript;

    /**
     * Конструює об'єкта Студента
     */
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.transcript = new Transcript();
    }

    /**
     * Повертає ім'я студента.
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає ідентифікатор студента.
     */
    public String getId() {
        return id;
    }

    /**
     * Повертає заліковку студента.
     */
    public Transcript getTranscript() {
        return transcript;
    }

    /**
     * Представляє сутність Студентського Квитка.
     */
    static class StudentCard {
        private String cardNumber;

        /**
         * Конструює студентського квитка.
         */
        public StudentCard(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        /**
         * Повертає номер картки студентського квитка.
         */
        public String getCardNumber() {
            return cardNumber;
        }
    }

    /**
     * Представляє Залікову Книжку.
     */
    static class Transcript {
        private ArrayList<String> subjects;
        private ArrayList<Integer> grades;

        /**
         * Конструює Залікової Книжки.
         */
        public Transcript() {
            this.subjects = new ArrayList<>();
            this.grades = new ArrayList<>();
        }

        /**
         * Додає оцінку для предмета до залікової книжки.
         */
        public void addGrade(String subject, int grade) {
            subjects.add(subject);
            grades.add(grade);
        }

        /**
         * Відображає заліковку студента.
         */
        public void displayTranscript(String studentName) {
            System.out.println("Залікова книжка  " + studentName + ":");
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println(subjects.get(i) + ": " + grades.get(i));
            }
        }

        /**
         * Обчислює Середній Бал залікової книжки.
         */
        public double calculateGPA() {
            if (grades.isEmpty()) {
                return 0.0;
            }
            int sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return (double) sum / grades.size();
        }
    }
}

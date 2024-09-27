public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}


javac StudentManagement.java
java StudentManagement

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {




    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + '}';
    }
}

public class StudentManagement {
    private List<Student> students;
    private Scanner scanner;

    public StudentManagement() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student's age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        students.add(new Student(name, age));
        System.out.println("Student added successfully!");
    }

    public void removeStudent() {
        System.out.print("Enter the student's name to remove: ");
        String name = scanner.nextLine();
        students.removeIf(student -> student.getName().equalsIgnoreCase(name));
        System.out.println("Student removed successfully!");
    }

    public void displayStudents() {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    management.addStudent();
                    break;
                case 2:
                    management.removeStudent();
                    break;
                case 3:
                    management.displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}

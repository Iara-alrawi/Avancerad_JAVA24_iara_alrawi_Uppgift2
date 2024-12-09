package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = StudentManager.getInstance();
        String filename = "students.txt";

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Display All Students"); // Detta alternativ är med här
            System.out.println("4. Save Students to File");
            System.out.println("5. Load Students from File");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.println("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Student Grade: ");
                    double grade = scanner.nextDouble();
                    manager.addStudent(id, name, grade);
                    break;

                case 2:
                    System.out.println("Enter Student ID to Search: ");
                    id = scanner.nextLine();
                    Student student = manager.searchStudentById(id);
                    if (student != null) {
                        System.out.println(student);
                    }else{
                        System.out.println("Student not found." );
                    }
                    break;

                case 3:
                    manager.displayAllStudents();
                    break;

                    case 4:
                        manager.saveToFile(filename);
                        break;

                        case 5:
                            manager.loadFromFile(filename);
                            break;

                            case 6:
                                System.out.println("Exiting...");
                                scanner.close();
                                return;

                                default:
                                    System.out.println("Invalid choice. Please try again. ");
            }
        }
    }
}
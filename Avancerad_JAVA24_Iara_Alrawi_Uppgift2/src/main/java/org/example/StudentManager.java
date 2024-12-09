package org.example;
import java.io.*;
import java.util.*;

public class StudentManager {
    private static StudentManager instance;
    private Map<String, Student> studentMap;

    private StudentManager() {
        studentMap = new HashMap<>();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public void addStudent(String id, String name, double grade) {
        if (studentMap.containsKey(id)) {
            System.out.println("Student ID already exists.");
        } else {
            studentMap.put(id, new Student(id, name, grade));
            System.out.println("Student added successfully.");
        }
    }

    public Student searchStudentById(String id) {
        return studentMap.get(id);
    }

    public void displayAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students found.");
        } else {
            studentMap.values().forEach(System.out::println);
        }
    }

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : studentMap.values()) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getGrade());
                writer.newLine();
            }
            System.out.println("Data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    addStudent(parts[0], parts[1], Double.parseDouble(parts[2]));
                }
            }
            System.out.println("Data loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }
}

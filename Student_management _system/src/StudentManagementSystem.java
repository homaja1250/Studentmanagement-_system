
import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    String course;

    // Constructor to initialize student details
    public Student(int rollNo, String name, String course) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Student Roll No: " + rollNo);
        System.out.println("Student Name: " + name);
        System.out.println("Student Course: " + course);
    }
}

public class StudentManagementSystem {
    static Student[] students = new Student[10]; // Array to store student objects
    static int studentCount = 0; // Tracks the number of students

    // Method to add a student
    public static void addStudent(int rollNo, String name, String course) {
        if (studentCount < students.length) {
            students[studentCount] = new Student(rollNo, name, course);
            studentCount++;
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Student list is full.");
        }
    }

    // Method to view all students
    public static void viewStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                students[i].displayStudentDetails();
                System.out.println("----------------------------");
            }
        }
    }

    // Method to remove student by roll number
    public static void removeStudent(int rollNo) {
        boolean found = false;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].rollNo == rollNo) {
                // Shift elements left to remove the student
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null; // Clear last student
                studentCount--;
                found = true;
                System.out.println("Student removed successfully.");
                break;
            }
        }
        if (!found) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        while (true) {
            System.out.println("\n*** Student Management System ***");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    // Add student
                    System.out.print("Enter Student Roll No: ");
                    int rollNo = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Course: ");
                    String course = scanner.nextLine();
                    addStudent(rollNo, name, course);
                    break;
                    
                case 2:
                    // View all students
                    viewStudents();
                    break;
                    
                case 3:
                    // Remove student
                    System.out.print("Enter Student Roll No to remove: ");
                    int removeRollNo = scanner.nextInt();
                    removeStudent(removeRollNo);
                    break;
                    
                case 4:
                    // Exit
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
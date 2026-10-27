package Assignment3ExamRegistration;

import java.util.Scanner;

class InvalidRegistrationException extends Exception {

    public InvalidRegistrationException(String message) {
        super(message);
    }
}

public class ExamRegistration {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== EXAM REGISTRATION SYSTEM =====");

        try {
            System.out.print("Enter Student ID: ");
            String studentID = input.nextLine();

            System.out.print("Enter Student Name: ");
            String studentName = input.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(input.nextLine());

            System.out.print("Enter Exam Mark: ");
            double examMark = Double.parseDouble(input.nextLine());

            System.out.print("Enter Number of Subjects: ");
            int subjects = Integer.parseInt(input.nextLine());

            if (studentID.trim().isEmpty()) {
                throw new InvalidRegistrationException(
                        "Student ID cannot be empty.");
            }

            if (age < 18) {
                throw new InvalidRegistrationException(
                        "Student age must be at least 18.");
            }

            if (examMark < 0 || examMark > 100) {
                throw new InvalidRegistrationException(
                        "Exam mark must be between 0 and 100.");
            }

            if (subjects < 1 || subjects > 5) {
                throw new InvalidRegistrationException(
                        "Students can register for 1 to 5 subjects.");
            }

            System.out.println("\nRegistration Successful!");
            System.out.println("Student: " + studentName);
            System.out.println("Registered Subjects: " + subjects);

        } catch (InvalidRegistrationException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: " + e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("\nRegistration Failed!");
            System.out.println("Error: Please enter valid numbers.");

        } finally {
            System.out.println("\nRegistration attempt completed.");
            input.close();
        }
    }
}


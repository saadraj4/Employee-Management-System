import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeRecordManager recordManager = new EmployeeRecordManager();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("-------------------------------------");
            System.out.println("1. Insert employee record");
            System.out.println("2. Delete employee record");
            System.out.println("3. Update employee records");
            System.out.println("4. Show details of an employee");
            System.out.println("5. Show all records");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.println("-------------------------------------");

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter employee details:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Start Date (yyyy-MM-dd): ");
                    String startDateStr = scanner.nextLine();
                    LocalDate startDate;
                    try {
                        startDate = LocalDate.parse(startDateStr, dateFormatter);
                    } catch (Exception e) {
                        System.out.println("Please Enter date in default format (yyyy-MM-dd)");
                        return;
                    }
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Work Hours: ");
                    int workHours = scanner.nextInt();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    double updatedSalary = recordManager.updateSalary(salary, workHours);
                    Employee newEmployee = new Employee(name, id, startDate, phoneNumber, address, workHours, updatedSalary);
                    recordManager.insertRecord(newEmployee);
                }
                case 2 -> {
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    int result = recordManager.deleteRecord(deleteId);
                    if (result != -1) {
                        System.out.println("Record with ID " + deleteId + " deleted successfully.");
                    } else {
                        System.out.println("Record with ID " + deleteId + " not found.");
                    }
                }
                case 3 -> {
                    System.out.print("Enter ID to update: ");
                    int newId = scanner.nextInt();
                    System.out.println("Enter new details:");
                    scanner.nextLine(); // Consume newline
                    System.out.print("Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Start Date (yyyy-MM-dd): ");
                    String newStartDateStr = scanner.nextLine();
                    LocalDate newStartDate;
                    try {
                        newStartDate = LocalDate.parse(newStartDateStr, dateFormatter);
                    } catch (Exception e) {
                        System.out.println("Please Enter date in default format (yyyy-MM-dd)");
                        return;
                    }
                    System.out.print("Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Work Hours: ");
                    int newWorkHours = scanner.nextInt();
                    System.out.print("Salary: ");
                    double newSalary = scanner.nextDouble();
                    double newUpdatedSalary = recordManager.updateSalary(newSalary, newWorkHours);
                    Employee updatedEmployee = new Employee(newName, newId, newStartDate, newPhoneNumber, newAddress, newWorkHours, newUpdatedSalary);
                    recordManager.updateRecord(newId, updatedEmployee);
                }
                case 4 -> {
                    System.out.print("Enter ID to show details: ");
                    int showId = scanner.nextInt();
                    recordManager.searchRecord(showId);
                }
                case 5 -> recordManager.showAllRecords();
                case 6 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

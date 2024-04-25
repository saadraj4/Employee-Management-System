import java.util.*;

public class Main {
    public static void main(String[] args) {
        EmployeeRecordManager recordManager = new EmployeeRecordManager();
        Scanner scanner = new Scanner(System.in);

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
                case 1:
                    System.out.println("Enter employee details:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Start Date: ");
                    String startDate = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Work Hours: ");
                    int workHours = scanner.nextInt();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();

                    Employee newEmployee = new Employee(name, id, startDate, phoneNumber, address, workHours, salary);
                    recordManager.insertRecord(newEmployee);
                    break;
                case 2:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    int result = recordManager.deleteRecord(deleteId);
                    if (result != -1) {
                        System.out.println("Record with ID " + deleteId + " deleted successfully.");
                    }
                    else {
                        System.out.println("Record with ID " + deleteId + " not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter ID to update: ");
                    int newId = scanner.nextInt();
                    System.out.println("Enter new details:");
                    scanner.nextLine(); // Consume newline
                    System.out.print("Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Start Date: ");
                    String newStartDate = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Work Hours: ");
                    int newWorkHours = scanner.nextInt();
                    System.out.print("Salary: ");
                    double newSalary = scanner.nextDouble();

                    Employee updatedEmployee = new Employee(newName, newId, newStartDate, newPhoneNumber, newAddress, newWorkHours, newSalary);
                    recordManager.updateRecord(newId, updatedEmployee);
                    break;
                case 4:
                    System.out.print("Enter ID to show details: ");
                    int showId = scanner.nextInt();
                    recordManager.searchRecord(showId);
                    break;
                case 5:
                    recordManager.showAllRecords();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

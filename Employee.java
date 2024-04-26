public class Employee {
    String name;
    int id;
    String startDate;
    String phoneNumber;
    String address;
    int workHours;
    double salary;

    public Employee(String name, int id, String startDate, String phoneNumber, String address, int workHours, double salary) {
        this.name = name;
        this.id = id;
        this.startDate = startDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.workHours = workHours;
        this.salary = salary;
    }


    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nStart Date: " + startDate + "\nPhone Number: " + phoneNumber
                + "\nAddress: " + address + "\nWork Hours: " + workHours + "\nSalary: $" + String.format("%.2f", salary);
    }
}

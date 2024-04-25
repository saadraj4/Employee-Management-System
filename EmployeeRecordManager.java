public class EmployeeRecordManager {
    private EmployeeNode head;

    private class EmployeeNode {
        Employee employee;
        EmployeeNode next;

        public EmployeeNode(Employee employee) {
            this.employee = employee;
            this.next = null;
        }
    }

    public EmployeeRecordManager() {
        this.head = null;
    }

    public void insertRecord(Employee employee) {
        if (checkRecord(employee.id)) {
            System.out.println("Record with same id already exist.");
            return;
        }
        if (head == null || employee.id < head.employee.id) {
            EmployeeNode newNode = new EmployeeNode(employee);
            newNode.next = head;
            head = newNode;
            System.out.println("Record inserted successfully.");
            return;
        }

        EmployeeNode current = head;
        while (current.next != null && current.next.employee.id < employee.id) {
            current = current.next;
        }
        EmployeeNode newNode = new EmployeeNode(employee);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Record inserted successfully.");

    }


//    Utility function to check if the record with same id exist
    public boolean checkRecord(int id) {
        EmployeeNode current = head;
        while (current != null) {
            if (current.employee.id == id) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int deleteRecord(int id) {
        if (head == null) {
            System.out.println("No records to delete.");
            return -1;
        }

        if (head.employee.id == id) {
            head = head.next;
            System.out.println("Record deleted successfully.");
            return 0;
        }

        EmployeeNode current = head;
        while (current.next != null && current.next.employee.id != id) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
            return 0;
        } else {
            return -1;
                }
    }



    public void searchRecord(int id) {
        EmployeeNode current = head;
        while (current != null) {
            if (current.employee.id == id) {
                System.out.println(current.employee);
                return;
            }
            current = current.next;
        }
        System.out.println("Record not found.");
    }


    public void showAllRecords() {
        if (head == null) {
            System.out.println("No records to display.");
            return;
        }

        EmployeeNode current = head;
        while (current != null) {
            System.out.println(current.employee);
            current = current.next;
        }
    }
    public void updateRecord(int newId, Employee updatedEmployee) {
        EmployeeNode current = head;
        while (current != null && current.employee.id != newId) {
            current = current.next;
        }
        if (current != null) {
            current.employee = updatedEmployee;
        } else {
            System.out.println("Record not found.");
        }

        System.out.println("Record updated successfully.");
    }
}

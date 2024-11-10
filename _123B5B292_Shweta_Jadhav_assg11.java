import java.io.*;
import java.util.Scanner;

public class _123B5B292_Shweta_Jadhav_assg11 {
    class Employee {
        String name;
        int id;
        String department;

        public Employee(int id, String name, String department) {
            this.id = id;
            this.name = name;
            this.department = department;
        }
    }

    private Employee[] table;
    private static final int TABLE_SIZE = 10; 

    public _123B5B292_Shweta_Jadhav_assg11() {
        table = new Employee[TABLE_SIZE];
    }

    private int hash(int id) {
        return id % TABLE_SIZE;
    }

    public void insert(Employee employee) {
        int index = hash(employee.id);
        int originalIndex = index;

        while (table[index] != null) {
            if (table[index].id == employee.id) {
                return;
            }
            index = (index + 1) % TABLE_SIZE;
            if (index == originalIndex) {
                break;
            }
        }
        table[index] = employee;
    }

    public Employee search(int id) {
        int index = hash(id);
        int originalIndex = index;

        while (table[index] != null) {
            if (table[index].id == id) {
                return table[index];
            }
            index = (index + 1) % TABLE_SIZE;
            if (index == originalIndex) {
                break;
            }
        }
        return null;
    }

    public void loadEmployeesFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String department = parts[2];
                insert(new Employee(id, name, department));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        _123B5B292_Shweta_Jadhav_assg11 hashTable = new _123B5B292_Shweta_Jadhav_assg11();

        hashTable.loadEmployeesFromFile("employee.txt");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID to search: ");
        int searchId = scanner.nextInt();

        Employee foundEmployee = hashTable.search(searchId);
        if (foundEmployee != null) {
            System.out.println("Employee Found: ID: " + foundEmployee.id + ", Name: " + foundEmployee.name + ", Department: " + foundEmployee.department);
        } else {
            System.out.println("Employee with ID " + searchId + " not found.");
        }

        scanner.close();
    }
}

package Day3.Seralization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%-8d%-15s%-10s%-8.2f", id, name, department, salary);
    }
}

public class SaveAndRetriveObject {
    private static final String FILE_PATH = "input.txt";

    public static void addData(Employee employee) {
        List<Employee> employees = new ArrayList<>();

        File file = new File(FILE_PATH);
        if (file.exists()) {
            employees = readAllData();
        }

        employees.add(employee);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            for (Employee e : employees) {
                oos.writeObject(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readAllData() {
        List<Employee> employees = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            while (true) {
                try {
                    employees.add((Employee) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void displayData() {
        List<Employee> employees = readAllData();
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(6516, "Kushagra", "IT", 651358.65);
        Employee emp2 = new Employee(5613, "Shreya", "HR", 656513.46);

        addData(emp1);
        addData(emp2);

        displayData();
    }
}

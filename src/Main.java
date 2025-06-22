import java.util.Arrays;
import java.util.Comparator;


public class Main {
    private static final Employee[] employees = new Employee[10]; // Массив сотрудников


    public static void main(String[] args) {
        // Заполняем массив тестовыми сотрудниками
        fillEmployees();

        // Получаем полный список сотрудников
        System.out.println("\nСписок всех сотрудников:");
        printAllEmployees();

        // Общая сумма затрат на зарплату
        System.out.println("\nОбщая сумма заработной платы: " + calculateTotalSalary());

        // Сотрудник с минимальной зарплатой
        Employee minSalaryEmp = findMinSalaryEmployee();
        System.out.println("\nМинимальная зарплата: " + minSalaryEmp.getSalary() + ". Сотрудник: " + minSalaryEmp.getFirstName() + " " + minSalaryEmp.getLastName());

        // Сотрудник с максимальной зарплатой
        Employee maxSalaryEmp = findMaxSalaryEmployee();
        System.out.println("\nМаксимальная зарплата: " + maxSalaryEmp.getSalary() + ". Сотрудник: " + maxSalaryEmp.getFirstName() + " " + maxSalaryEmp.getLastName());

        // Среднее значение зарплат
        System.out.println("\nСредняя заработная плата: " + calculateAverageSalary());

        // Список фамилий всех сотрудников
        printNamesOfEmployees();
    }

    // Методы обработки массива сотрудников
    private static void fillEmployees() {
        employees[0] = new Employee("Иван", "Иванов", 1, 80_000);
        employees[1] = new Employee("Сергей", "Сергеев", 2, 120_000);
        employees[2] = new Employee("Алексей", "Александров", 3, 90_000);
        employees[3] = new Employee("Анна", "Андреева", 4, 70_000);
        employees[4] = new Employee("Михаил", "Михайлов", 5, 100_000);
        employees[5] = new Employee("Ольга", "Орехова", 1, 60_000);
        employees[6] = new Employee("Дмитрий", "Дмитриев", 2, 110_000);
        employees[7] = new Employee("Евгений", "Егоркин", 3, 85_000);
        employees[8] = new Employee("Маргарита", "Маркова", 4, 75_000);
        employees[9] = new Employee("Павел", "Петров", 5, 95_000);
    }

    // Метод вывода списка всех сотрудников
    private static void printAllEmployees() {
        Arrays.stream(employees).forEach(System.out::println);
    }

    // Сумма затрат на зарплату
    private static double calculateTotalSalary() {
        return Arrays.stream(employees).mapToDouble(Employee::getSalary).sum();
    }

    // Минимальная зарплата среди сотрудников

    private static Employee findMinSalaryEmployee() {
        return Arrays.stream(employees).min(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
    }

    // Максимальная зарплата среди сотрудников
    private static Employee findMaxSalaryEmployee() {
        return Arrays.stream(employees).max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
    }

    // Средняя зарплата
    private static double calculateAverageSalary() {
        return Arrays.stream(employees).mapToDouble(Employee::getSalary).average().orElse(Double.NaN);
    }

    // Печать только имен сотрудников
    private static void printNamesOfEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp.getFirstName() + " " + emp.getLastName());
        }
    }
}










import java.util.Objects;

public class Employee {
    private static int nextId = 1; // Статический счётчик ID

    private final int id;          // Идентификатор сотрудника
    private String firstName;      // Имя
    private String lastName;       // Фамилия
    private int department;        // Номер отдела (от 1 до 5)
    private double salary;         // Зарплата

    public Employee(String firstName, String lastName, int department, double salary) {
        this.id = nextId++;
        this.firstName= firstName; // Без проверки
        this.lastName=lastName;     // Без проверки
        this.department=department;   // Без проверки
        this.salary=salary;    // Без проверки
    }
    // Геттеры и сеттеры для каждого поля
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!firstName.isEmpty()) {
            this.firstName = firstName.trim();
        } else {
            throw new IllegalArgumentException("Имя должно быть задано.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!lastName.isEmpty()) {
            this.lastName = lastName.trim();
        } else {
            throw new IllegalArgumentException("Фамилия должна быть задана.");
        }
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department >= 1 && department <= 5) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Отдел должен быть от 1 до 5");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Зарплата должна быть положительной.");
        }
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, department, salary);
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", ФИО: " + firstName + ' ' + lastName +
                ", Отдел: " + department +
                ", Зарплата: " + salary;
    }
}






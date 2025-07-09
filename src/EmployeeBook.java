public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void printAllEmployees(){
        employees[0] = new Employee("Андреев", "Денис", 0,  78489);
        employees[1] = new Employee("Иванова", "Дарья", 1,  65785);
        employees[2] = new Employee("Петров", "Павел", 2,  74548);
        employees[3] = new Employee("Сидоров", "Илья", 3,  68546);
        employees[4] = new Employee("Лазуренко", "Ольга", 4,  59865);
        employees[5] = new Employee("Михайлова", "Екатерина", 5,  85479);

    }

    public boolean addEmployee(Employee newEmployee){
        for (int i = 0; i < employees.length; i++) {
            if(employees[i] == null){
                employees[i] = newEmployee;

                return true;
            }
        }
        return false;
    }
    public void print(){
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

            public double calculateSumOfSalary() {
                double sum = 0.0;  // Используем double для хранения суммы
                for (Employee employee : employees) {
                    if (employee != null) {  // Проверяем, что элемент массива не null
                        sum += employee.getSalary();  // Правильно складываем зарплату
                    }
                }
                return sum;
            }

    public Employee findMinimumWageEmployee() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }
    }
import java.util.Random;

public class Main {

//Базовая сложность

    private final static Random RANDOM = new Random();
    private final static String[] NAMES = {"Данила", "Александр", "Виктор", "Вадим", "Антон", "Роман", "Константин", "Евгений", "Вячеслав", "Николай"};
    private final static String[] FAMILIYA = {"Петров", "Смирнов", "Кузнецов", "Жуков", "Крылов", "Денисов", "Борисов", "Агутин", "Наумов", "Дроздов"};
    private final static String[] OTCHESTVO = {"Александрович", "Алексеевич", "Владимирович", "Петрович", "Макарович", "Сергеевич", "Игоревич", "Валентинович", "Михайлович", "Петрович"};


    private final static Employee[] EMPLOYEES = new Employee[10];

    private static void initEmployees() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = FAMILIYA[RANDOM.nextInt(0, FAMILIYA.length)] + " " +
                    NAMES[RANDOM.nextInt(0, NAMES.length)] + " " +
                    OTCHESTVO[RANDOM.nextInt(0, OTCHESTVO.length)];

            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 10), RANDOM.nextInt(30_000, 100_000));

        }
    }

    public static void main(String[] args) {
        initEmployees();
        print();
        System.out.println(" Сумма ЗП сотрудников: " + calculateSumOfSalaries());
        System.out.println(" Сотрудника с min ЗП: " + findEmployeeWithMinSalary());
        System.out.println(" Сотрудника с max ЗП: " + findEmployeeWithMaxSalary());
        System.out.println(" Средняя ЗП: " + calculateAverageOfSalaries());
        printFullName();
    }

    private static void print() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int calculateSumOfSalaries() {
        int sum = 0;
        for (Employee employee : EMPLOYEES) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;

    }

    private static double calculateAverageOfSalaries() {
        return (double) calculateSumOfSalaries() / EMPLOYEES.length;
    }

    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }
    }
}
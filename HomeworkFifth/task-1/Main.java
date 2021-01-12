public class Main {

    public static void main(String[] args) {
        Employee[] employeeArray = createsEmployees();

        showEmployeesCertainAge(employeeArray, 40);

    }

    public static Employee[] createsEmployees() {
        Employee[] employeeArray = new Employee[5];

        employeeArray[0] = new Employee("Sergey",
                "Bordak", "Michalovich",
                "Programmer", "siarheibo@gmail.com",
                "+375336808097", 1000, 31);
        employeeArray[1] = new Employee("Olga",
                "Andreeva", "Petrovna",
                "Manager", "olga1996@mail.ru",
                "+375445704057", 800, 25);
        employeeArray[2] = new Employee("Michail",
                "Petrov", "Maksimov",
                "Technical Director", "superPetrov@yandex.ru",
                "+375294324421", 1500, 41);
        employeeArray[3] = new Employee("Mariya",
                "Smirnova", "Sergeevna",
                "Chief Accountant", "smirnova@gmail.com",
                "+375335698723", 1400, 42);
        employeeArray[4] = new Employee("Maksim",
                "Kylov", "Ivanov",
                "programmer", "Ivanov777@mail.ru",
                "+37533745637", 1000, 28);

        return employeeArray;
    }

    public static void showEmployeesCertainAge(Employee[] employeeArray, int age) {
        for (Employee employee : employeeArray) {
            if (employee.getAge() > age) {
                System.out.println(employee.printEmployee());
            }
        }
    }
}

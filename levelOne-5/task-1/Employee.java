public class Employee {
    private String name;
    private String surname;
    private String patronymic;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String surname, String patronymic, String position, String email, String phone, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public String printEmployee() {
        return "Employee " +
                "name: " + name  +
                ", surname: " + surname +
                ", patronymic: " + patronymic +
                ", position: " + position +
                ", email: " + email +
                ", phone: " + phone +
                ", salary: " + salary +
                ", age: " + age + ".";
    }

    public int getAge() {
        return age;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company comp = Company.getComp();
        comp.add(new Executive("Михаил"));
        comp.add(new Manager("Иван"));
        Employee tany = new HourlyEmployee("Татьяна");
        comp.add(tany);
        System.out.println(comp);
        comp.dismiss(tany);
        System.out.println(comp);
    }
}
class Company
{
    private static Company comp = new Company();
    List<Employee> list = new ArrayList<>();
    private Company() {
    }

    public static Company getComp() {
        return comp;
    }

    void add(Employee emp) {
        list.add(emp);
    }

    void dismiss(Employee emp) {
        list.remove(emp);
    }

    @Override
    public String toString() {
        String imp = "";
        for(Employee emp: list) imp+=emp.toString()+" "+emp.calculateSalary()+"\n";
        return imp;
    }
}

abstract class Employee
{
    private String name;
    Employee(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
    abstract int calculateSalary();
}

class HourlyEmployee extends Employee
{
    HourlyEmployee(String name) {
        super(name);
    }
    @Override
    int calculateSalary() {
        System.out.println("Зарплата Hourly");
        return 0;
    }
}
class SalariedEmplyee extends Employee
{
    SalariedEmplyee(String name) {
        super(name);
    }
    @Override
    int calculateSalary() {
        System.out.println("Зарплата Salaried");
        return 0;
    }
}
class Manager extends Employee
{
    Manager(String name) {
        super(name);
    }
    @Override
    int calculateSalary() {
        System.out.println("Зарплпта Менеджера");
        return 0;
    }
}
class Executive extends Employee
{
    Executive(String name) {
        super(name);
    }
    @Override
    int calculateSalary() {
        System.out.println("Зарплата Executive");
        return 0;
    }
}
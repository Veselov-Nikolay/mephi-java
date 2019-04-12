import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company comp = Company.getComp();
        comp.add(new Executive("Михаил"));
        Employee ivan = new Manager("Иван");
        comp.add(ivan);
        Employee tany = new HourlyEmployee("Татьяна");
        //Примем на работу Татьяну
        comp.add(tany);
        System.out.println(comp);
        //Уволим Татьяну
        comp.dismiss(tany);
        System.out.println(comp);
        //Теперь Иван Executive
        comp.change(ivan,"Executive");
        System.out.println(comp);
        ////////
        System.out.println(comp.toString2());
        System.out.println(comp.toString3());
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

    Employee change(Employee emp, String position)
    {
        Employee newEmp = null;
        switch (position) {
            case "HourlyEmployee":
                newEmp =  new HourlyEmployee(emp.toString());
                break;
            case "SalariedEmplyee":
                newEmp = new SalariedEmplyee(emp.toString());
                break;
            case "Manager":
                newEmp = new Manager(emp.toString());
                break;
            case "Executive":
                newEmp = new Executive(emp.toString());
                break;
             default:
                 newEmp = emp;
                 break;
        }
        dismiss(emp);
        add(newEmp);
        return newEmp;
    }

    private int sum()
    {
        int sum = 0;
        for (Employee emp: list) sum+=emp.calculateSalary();
        return sum;
    }

    private int averageSumForMonth()
    {
        return (int) sum()/list.size();
    }

    private int averageSumForYear()
    {
        return 12*averageSumForMonth();
    }

    public String toString2()
    {
        String str = "";
        str+=list.size()+" "+sum()+" "+ averageSumForMonth()+" "+averageSumForYear();
        return str;
    }

    public String toString3()
    {
        String str = "";
        int hourlyEmp = 0;
        int hourlyEmpSum = 0;
        int AVhourlyEmpSum = 0;
        int salariedEmp = 0;
        int salariedEmpSum = 0;
        int AVsalariedEmpSum = 0;
        int executive = 0;
        int executiveSum = 0;
        int AVexecutiveSum = 0;
        int manager = 0;
        int managerSum = 0;
        int AVmanagerSum = 0;
        for(Employee emp: list)
        {
            if(emp instanceof HourlyEmployee)
            {
                hourlyEmp++;
                hourlyEmpSum+=emp.calculateSalary();
            }
            else if (emp instanceof SalariedEmplyee)
            {
                salariedEmp++;
                salariedEmpSum+=emp.calculateSalary();
            }
            else if (emp instanceof Executive)
            {
                executive++;
                executiveSum+=emp.calculateSalary();
            }
            else if (emp instanceof Manager)
            {
                manager++;
                managerSum+=emp.calculateSalary();
            }
        }
        if (manager == 0) AVmanagerSum = 0;
        else AVmanagerSum = managerSum/manager;

        if (executive == 0) AVexecutiveSum = 0;
        else AVexecutiveSum = executiveSum/executive;

        AVhourlyEmpSum = (hourlyEmp==0)?0:hourlyEmpSum/hourlyEmp;

        AVsalariedEmpSum = (salariedEmp==0)?0:salariedEmpSum/salariedEmp;

        str = "HourlyEmployee"+" "+hourlyEmp+" "+AVhourlyEmpSum+" "+AVhourlyEmpSum*12+"\n"+
                "SalariedEmplyee"+" "+salariedEmp+" "+AVsalariedEmpSum+" "+ AVsalariedEmpSum*12+"\n"+
                "Executive"+" "+ executive+" "+AVexecutiveSum+" "+AVexecutiveSum*12+"\n"+
                "Manager"+" "+manager+" "+AVmanagerSum+" "+AVmanagerSum*12;
        return str;
    }

    @Override
    public String toString() {
        String imp = "";
        for(Employee emp: list) imp+=emp.getClass().getName()+" "+emp.toString()+", в месяц = "+emp.calculateSalary()+", в год = "+ emp.calculateSalary()*12+"\n";
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
       // System.out.println("........Зарплата Hourly");
        return 20;
    }
}
class SalariedEmplyee extends Employee
{
    SalariedEmplyee(String name) {
        super(name);
    }
    @Override
    int calculateSalary() {
       // System.out.println("........Зарплата Salaried");
        return 30;
    }
}
class Manager extends Employee
{
    Manager(String name) {
        super(name);
    }
    @Override
    int calculateSalary() {
     //   System.out.println("........Зарплпта Менеджера");
        return 40;
    }
}
class Executive extends Employee
{
    Executive(String name) {
        super(name);
    }
    @Override
    int calculateSalary() {
    //    System.out.println("........Зарплата Executive");
        return 50;
    }
}
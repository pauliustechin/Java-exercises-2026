package employee;

public class Main {

    public static void main(String[] args){

        Employee employee = new Employee(1, "Jonas", "Jonaitis", 1000);

        employee.setSalary(1200);
        System.out.println(employee);

        employee.raiseSalary();
        System.out.println(employee);

    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // create a instance of Employee class here
        Employee emp1 = new Employee(1, "Emp1", 2000, new Address("Address 1", 444));
        Employee emp2 = new Employee(2, "Emp2", 4000, new Address("Address 2", 222));
        Employee emp3 = new Employee(3, "Emp3", 1000, new Address("Address 3", 333));
        Employee emp4 = new Employee(4, "Emp4", 3000, new Address("Address 4", 111));

        List<Employee> empList = new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(emp3);
        empList.add(emp4);
        System.out.println("Unsorted list: " + empList);
        Collections.sort(empList, new SalaryComparator());
        System.out.println("Sorted list: " + empList);

    }
}

package StreamCollect;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollect {
  public static void main(String[] args) {
    List<Employee> empList = new ArrayList<Employee>();
    empList.add(new Employee(101, "siva", 101, true, 2000));
    empList.add(new Employee(102, "reddy", 101, true, 5000));
    empList.add(new Employee(103, "raju", 102, false, 6000));
    empList.add(new Employee(104, "shivam", 102, false, 4000));
    empList.add(new Employee(105, "bob", 103, true, 3500));
    empList.add(new Employee(106, "alice", 103, false, 5500));
    empList.add(new Employee(107, "srinu", 104, true, 3500));
    empList.add(new Employee(108, "ram", 103, true, 2500));
    empList.add(new Employee(108, "kamal", 101, true, 3000));

    // Stream<Employee> empStream = empList.stream(); // Bad Idea !!! if used more than once, it will throw at Runtime
    // java.lang.IllegalStateException: stream has already been operated upon or closed

    // # Problem 1
    // use collect method of stream to group by employees in empList by department
    // Just printing without storing in map
    // use collect method of stream to group by employees in empList by department
    // storing in a map and then printing
    Map<Integer, List<Employee>> deptMap = empList.stream()
      .collect(Collectors.groupingBy(Employee::getDeptId));
    deptMap.entrySet().forEach(entry -> {
      System.out.println("Employees working in dept " + entry.getKey() + " : " + entry.getValue());
    });
    System.out.println("==================================");
    empList.stream()
      .collect(Collectors.groupingBy(Employee::getDeptId))
      .forEach((dept, listEmp) -> {
        System.out.println("Employees working in dept " + dept + " :");
        listEmp.forEach(System.out::println);
      });
    System.out.println("==================================");
    
    // # Problem 2
    // use collect method to count the employees by departments
    // print
    empList.stream()
      .collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()))
      .forEach((dept, count) -> {
        System.out.println(dept + " department employee count is : " + count);
      });
    System.out.println("==================================");
    // store in map
    Map<String, Long> deptCountMap = empList.stream()
      .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    deptCountMap.entrySet().forEach(entry -> {
      System.out.println(entry.getKey() + " department employee count is : " + entry.getValue());
    });
    System.out.println("==================================");

    // # Problem 3
    // make a map according to active boolean field
    Map<Boolean, List<Employee>> activityList = empList.stream()
      .collect(Collectors.partitioningBy(Employee::isActive));
    activityList.entrySet().forEach(entry -> {
      System.out.println("Active: " + entry.getKey() + "\nList of Emp: " + entry.getValue());
    });
    System.out.println("==================================");

    // # Problem 4
    // name should start with 'r'
    Stream<Employee> nameStream = empList.stream().filter(emp -> emp.getName().startsWith("r"));
    nameStream.forEach(System.out::println); // print elements of Streams<Employee> in this way
    // long nameCount = nameStream.count(); // java.lang.IllegalStateException: stream has already been operated upon or closed
    // System.out.println(nameCount);
    System.out.println("==================================");
    // salary greater than 3000
    Stream<Employee> salaryStream = empList.stream().filter(emp -> (emp.getSalary() > 3000)); 
    salaryStream.forEach(System.out::println); // print elements of Streams<Employee> in this way
    // long salaryCount = salaryStream.count(); // java.lang.IllegalStateException: stream has already been operated upon or closed
    // System.out.println(salaryCount);
    System.out.println("==================================");

    // Problem 5
    // print employee with min/max salary
    Optional<Employee> minSalary = empList.stream().min(Comparator.comparing(Employee::getSalary));
    Optional<Employee> maxSalary = empList.stream().max(Comparator.comparing(Employee::getSalary)); // returns Optional<Employee>
    System.out.println(
      "Employee with min salary: " + minSalary +
      "\nEmployee with max salary: " + maxSalary
    );
    System.out.println("==================================");

    // Department wise max salary
    Map<String, Optional<Employee>> maxSalaryMap = empList.stream()
      .collect(
        Collectors.groupingBy(
          Employee::getDepartment,
          Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))
        )
      );
    maxSalaryMap.entrySet().forEach(System.out::println);
    System.out.println("==================================");
  }

}

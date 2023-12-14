package ComparableEx;

import java.util.ArrayList;
import java.util.Collections;

public class SortExample {
    public static void main(String[] args){
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(16);
        intList.add(15);
        intList.add(18);
        intList.add(17);
        System.out.println(intList);
        // intList.sort(null); // Dosn't have a comparator interface yet
        Collections.sort(intList); // this works!
        System.out.println(intList);

        ArrayList<Employee> empList = new ArrayList<>();
        SortExample myExample = new SortExample();
        empList.add(myExample.new Employee("Siddharth", "8447447076", 7));
        empList.add(myExample.new Employee("Sharvil", "8447447076", 2));
        empList.add(myExample.new Employee("Shashank", "8447447076", 11));
        System.out.println(empList);
        Collections.sort(empList); // Will not work until it implements comparator interface
        System.out.println(empList); // Only one property can be changed at a time AND existing code will be changed
    }

    public class Employee implements Comparable<Employee> {
        private String name;
        private String phone;
        private int empId;

        public Employee(String name, String phone, int empId) {
            this.name = name;
            this.phone = phone;
            this.empId = empId;
        }
        @Override
        public String toString() {
            return "Employee {" + name + " " + phone + " " + empId + "}";
        }
        @Override
        public int compareTo(Employee emp) {
            return this.empId - emp.empId;
        }
    }
}

